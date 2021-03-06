package org.random.test.utils;

import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.random.test.pages.Loadable;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Predicate;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 30;

    private WaitUtils() {
        // utility class
    }

    public static <T extends Loadable> T waitUntilLoaded(T loadable) {
        createWait(loadable).until(Loadable::isLoaded);

        return loadable;
    }

    public static <T extends Loadable> T waitUntilLoaded(Class<T> loadableCLass) {
        try {
            return waitUntilLoaded(loadableCLass.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to create an instance", e);
        }
    }

    private static <T> FluentWait<T> createWait(T subject) {
        return new FluentWait<T>(subject)
                .ignoring(WebDriverException.class)
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public static void waitForElement(WebElement element, Predicate<WebElement> predicate) {
        createWait(element).until(predicate::test);
    }

    public static WebElement waitVisible(WebElement element) {
        return createWait(element).until((el) -> {
            if (ElementUtils.isDisplayed(el)) {
                return el;
            } else {
                return null;
            }
        });
    }

    public static void waitAsserted(Runnable assertion) {
        Mutable<AssertionError> lastError = new MutableObject<>(null);

        try {
            createWait(assertion).until(runnable -> {
                try {
                    runnable.run();
                    return true;
                } catch (AssertionError e) {
                    lastError.setValue(e);
                    return null;
                }
            });
        } catch (TimeoutException e) {
            AssertionError assertionError = lastError.getValue();

            if (Objects.nonNull(assertionError)) {
                throw assertionError;
            }
        }
    }
}

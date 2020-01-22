package org.random.test.utils;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.random.test.pages.Loadable;

import java.time.Duration;
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
}

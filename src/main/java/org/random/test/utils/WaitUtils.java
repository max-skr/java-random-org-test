package org.random.test.utils;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.FluentWait;
import org.random.test.pages.Loadable;

import java.time.Duration;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 30;

    private WaitUtils() {
        // utility class
    }

    public static <T extends Loadable> T waitUntilLoaded(T loadable) {
        new FluentWait<T>(loadable)
                .ignoring(WebDriverException.class)
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT)).until(Loadable::isLoaded);

        return loadable;
    }

}

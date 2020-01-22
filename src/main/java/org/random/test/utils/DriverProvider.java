package org.random.test.utils;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class DriverProvider {

    private static final ThreadLocal<WebDriver> DRIVER_HOLDER = new ThreadLocal<>();

    public static WebDriver start(Browser browser) {
        Objects.requireNonNull(browser, "Browser should be defined");
        switch (browser) {
            case CHROME:
                return createChrome();
            case FIREFOX:
                return createFirefox();
            default:
                throw new IllegalArgumentException(String.format("Browser %s not supported!", browser));
        }
    }

    public static WebDriver getCurrentDriver() {
        return Optional.ofNullable(DRIVER_HOLDER.get())
                .orElseThrow(() -> new NoSuchElementException(
                        "No driver initialized for thread: " + Thread.currentThread()));
    }

    public static void releaseCurrentDriver() {
        Optional.ofNullable(DRIVER_HOLDER.get())
                .ifPresent(driver -> {
                    driver.quit();
                    DRIVER_HOLDER.set(null);
                });
    }

    private static WebDriver createChrome() {
        String path = Paths.get("src", "main", "resources", "selenium", "drivers", "chromedriver.exe").toString();
        System.setProperty("webdriver.chrome.driver", path);

        WebDriver driver = new ChromeDriver();
        DRIVER_HOLDER.set(driver);
        return driver;
    }

    private static WebDriver createFirefox() {
        throw new NotImplementedException("temporary...");
    }
}

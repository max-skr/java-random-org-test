package org.random.test.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ElementUtils {

    private ElementUtils() {
        // utility class
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

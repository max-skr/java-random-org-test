package org.random.test.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    public static boolean isNotDisplayed(WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return true;
        }
    }

    public static void setValue(WebElement element, String value) {
        WaitUtils.waitForElement(element, ElementUtils::isDisplayed);
        element.clear();
        element.sendKeys(value);
    }

    public static void mouseOver(WebElement element) {
        new Actions(DriverProvider.getCurrentDriver()).moveToElement(element).perform();
    }
}

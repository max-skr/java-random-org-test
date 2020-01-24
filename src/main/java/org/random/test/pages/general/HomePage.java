package org.random.test.pages.general;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.utils.ElementUtils;

import java.util.Objects;

public class HomePage extends NavigationPage<HomePage> {

    @FindBy(id = "homepage-wide-column")
    private WebElement wideCol;

    @FindBy(id = "true-random-integer-generator-min")
    private WebElement minField;

    @FindBy(id = "true-random-integer-generator-max")
    private WebElement maxField;

    @FindBy(id = "true-random-integer-generator-button")
    private WebElement generateButton;

    @FindBy(id = "true-random-integer-generator-result")
    private WebElement resultElement;

    @FindBy(css = "iframe")
    private WebElement generatorFrame;

    public boolean isLoaded() {
        return ElementUtils.isDisplayed(wideCol);
    }

    public HomePage generateNumber(Integer min, Integer max) {
        getDriver().switchTo().frame(generatorFrame);
        if (Objects.nonNull(min)) {
            ElementUtils.setValue(minField, String.valueOf(min));
        }

        if (Objects.nonNull(max)) {
            ElementUtils.setValue(maxField, String.valueOf(max));
        }

        generateButton.click();
        getDriver().switchTo().defaultContent();
        return this;
    }

    public Integer getGeneratedNumber() {
        getDriver().switchTo().frame(generatorFrame);
        String result = resultElement.getText();
        getDriver().switchTo().defaultContent();

        if (result.matches("[-]?\\d+")) {
            return Integer.parseInt(result);
        } else {
            return null;
        }
    }
}

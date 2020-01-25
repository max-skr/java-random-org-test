package org.random.test.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.utils.ElementUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class HomePageNumberGeneratorComponent extends IFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageNumberGeneratorComponent.class);

    @FindBy(id = "true-random-integer-generator-min")
    private WebElement minField;

    @FindBy(id = "true-random-integer-generator-max")
    private WebElement maxField;

    @FindBy(id = "true-random-integer-generator-button")
    private WebElement generateButton;

    @FindBy(id = "true-random-integer-generator-result")
    private WebElement resultElement;

    public HomePageNumberGeneratorComponent(WebElement frameElement) {
        super(frameElement);
    }

    public void generateNumber(Integer min, Integer max) {
        this.perform(() -> {
            if (Objects.nonNull(min)) {
                LOGGER.info("Going to set '{}' to Min field.", min);
                ElementUtils.setValue(minField, String.valueOf(min));
            }

            if (Objects.nonNull(max)) {
                LOGGER.info("Going to set '{}' to Max field.", max);
                ElementUtils.setValue(maxField, String.valueOf(max));
            }

            LOGGER.info("Going to click Generate button.");
            generateButton.click();
        });
    }

    public Integer getGeneratedNumber() {
        String result = this.perform(() -> resultElement.getText());

        if (result.matches("[-]?\\d+")) {
            return Integer.parseInt(result);
        } else {
            return null;
        }
    }
}

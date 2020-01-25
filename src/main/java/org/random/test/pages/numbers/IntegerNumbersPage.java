package org.random.test.pages.numbers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.pages.PagePath;
import org.random.test.pages.general.NavigationPage;
import org.random.test.utils.ElementUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@PagePath("/integers")
public class IntegerNumbersPage extends NavigationPage<IntegerNumbersPage> {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegerNumbersPage.class);

    @FindBy(xpath = "//h2[text() = 'Random Integer Generator']")
    private WebElement pageHeadingElement;

    @FindBy(name = "num")
    private WebElement numCountField;

    @FindBy(name = "max")
    private WebElement maxField;

    @FindBy(name = "min")
    private WebElement minField;

    @FindBy(name = "col")
    private WebElement rowSizeField;

    @FindBy(css = "input[value='Get Numbers']")
    private WebElement getNumbersButton;

    @FindBy(css = "pre.data")
    private WebElement dataContainer;

    @Override
    public boolean isLoaded() {
        return ElementUtils.isDisplayed(pageHeadingElement);
    }

    public IntegerNumbersPage getIntegers(int numbersCount, int min, int max, int rowSize) {
        LOGGER.info("Going to set '{}' to numbers count field.", numbersCount);
        ElementUtils.setValue(numCountField, String.valueOf(numbersCount));

        LOGGER.info("Going to set '{}' to min field.", min);
        ElementUtils.setValue(minField, String.valueOf(min));

        LOGGER.info("Going to set '{}' to max field.", max);
        ElementUtils.setValue(maxField, String.valueOf(max));

        LOGGER.info("Going to set '{}' to rows size field.", rowSize);
        ElementUtils.setValue(rowSizeField, String.valueOf(rowSize));

        LOGGER.info("Going to click Get Numbers button");
        getNumbersButton.click();
        return this;
    }

    public List<List<Integer>> getResults() {
        String rawData = ElementUtils.getText(dataContainer);

        return Stream.of(rawData.split("\n"))
                .map(rawRow -> Stream.of(rawRow.trim().split("\\s"))
                        .map(Integer::parseInt).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}

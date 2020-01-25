package org.random.test.pages.general;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.pages.components.HomePageNumberGeneratorComponent;
import org.random.test.utils.ElementUtils;

public class HomePage extends NavigationPage<HomePage> {

    @FindBy(id = "homepage-wide-column")
    private WebElement wideCol;

    @FindBy(css = "iframe")
    private WebElement generatorFrame;

    public boolean isLoaded() {
        return ElementUtils.isDisplayed(wideCol);
    }

    public HomePage generateNumber(Integer min, Integer max) {
        getNumberGenerator().generateNumber(min, max);
        return this;
    }

    public Integer getGeneratedNumber() {
        return getNumberGenerator().getGeneratedNumber();
    }

    private HomePageNumberGeneratorComponent getNumberGenerator() {
        return new HomePageNumberGeneratorComponent(generatorFrame);
    }
}

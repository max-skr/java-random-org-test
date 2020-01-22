package org.random.test.pages.games;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.pages.general.NavigationPage;
import org.random.test.utils.ElementUtils;

public class CoinFlipperGamePage extends NavigationPage<CoinFlipperGamePage> {

    @FindBy(xpath = "//h2[text() = 'Coin Flipper']")
    private WebElement pageHeadingElement;

    @Override
    public boolean isLoaded() {
        return ElementUtils.isDisplayed(pageHeadingElement);
    }

}

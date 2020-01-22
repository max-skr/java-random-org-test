package org.random.test.pages.games;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.pages.general.NavigationPage;
import org.random.test.utils.ElementUtils;

public class DiceRollerGamePage extends NavigationPage<DiceRollerGamePage> {

    @FindBy(xpath = "//h2[text() = 'Dice Roller']")
    private WebElement pageHeadingElement;

    @Override
    public boolean isLoaded() {
        return ElementUtils.isDisplayed(pageHeadingElement);
    }

}

package org.random.test.pages.games;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.pages.general.NavigationPage;
import org.random.test.utils.ElementUtils;

public class KenoQuickPickGamePage extends NavigationPage<KenoQuickPickGamePage> {

    @FindBy(xpath = "//h2[text() = 'Keno Quick Pick']")
    private WebElement pageHeadingElement;

    @Override
    public boolean isLoaded() {
        return ElementUtils.isDisplayed(pageHeadingElement);
    }

}

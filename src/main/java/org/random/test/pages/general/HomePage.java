package org.random.test.pages.general;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.utils.ElementUtils;

public class HomePage extends NavigationPage<HomePage> {

    @FindBy(id = "homepage-wide-column")
    private WebElement wideCol;

    public boolean isLoaded() {
        return ElementUtils.isDisplayed(wideCol);
    }
}

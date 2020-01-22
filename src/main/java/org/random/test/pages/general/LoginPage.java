package org.random.test.pages.general;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.pages.AbstractPage;
import org.random.test.utils.ElementUtils;

public class LoginPage extends AbstractPage<LoginPage> {

    @FindBy(id = "login-login")
    private WebElement loginField;

    @Override
    public boolean isLoaded() {
        return ElementUtils.isDisplayed(loginField);
    }
}

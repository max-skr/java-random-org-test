package org.random.test.pages.numbers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.pages.general.NavigationPage;
import org.random.test.utils.ElementUtils;

public class SequencesNumbersPage extends NavigationPage<GaussianNumbersPage> {

    @FindBy(xpath = "//h2[text() = 'Random Sequence Generator']")
    private WebElement pageHeadingElement;

    @Override
    public boolean isLoaded() {
        return ElementUtils.isDisplayed(pageHeadingElement);
    }

}

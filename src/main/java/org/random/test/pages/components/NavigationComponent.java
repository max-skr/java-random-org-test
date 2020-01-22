package org.random.test.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.data.navigation.NavigationItem;
import org.random.test.utils.ElementUtils;
import org.random.test.utils.WaitUtils;

public class NavigationComponent extends AbstractComponent {

    @FindBy(css = "ul")
    private WebElement listElement;

    public NavigationComponent(WebElement baseElement) {
        super(baseElement);
    }

    public void navigate(NavigationItem item) {
        openNavigation();
        clickItem(item);
    }

    private void clickItem(NavigationItem item) {
        By contextXpath = By.xpath(String.format(".//a[@href][text() = '%s']", item.getName()));
        WebElement targetItem = getWrappedElement().findElement(contextXpath);
        targetItem.click();
        WaitUtils.waitForElement(targetItem, ElementUtils::isNotDisplayed);
    }

    private void openNavigation() {
        ElementUtils.mouseOver(this.getWrappedElement());
        WaitUtils.waitForElement(listElement, ElementUtils::isDisplayed);
    }

}

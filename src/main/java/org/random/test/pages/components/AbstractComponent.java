package org.random.test.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.random.test.pages.Loadable;
import org.random.test.utils.ElementUtils;

public abstract class AbstractComponent implements Loadable, WrapsElement {

    private final WebElement baseElement;

    public AbstractComponent(WebElement baseElement) {
        PageFactory.initElements(new DefaultElementLocatorFactory(baseElement), this);
        this.baseElement = baseElement; // this should be after initialization of elements (rewrite)
    }

    @Override
    public boolean isLoaded() {
        return ElementUtils.isDisplayed(baseElement);
    }

    @Override
    public WebElement getWrappedElement() {
        return baseElement;
    }
}

package org.random.test.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.random.test.utils.DriverProvider;
import org.random.test.utils.WaitUtils;

public abstract class AbstractPage<T extends AbstractPage<T>> implements Loadable {

    private static final String BASE_URL = "https://random.org";

    public AbstractPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @SuppressWarnings("unchecked")
    public T get() {
        loadPage();

        return (T) WaitUtils.waitUntilLoaded(this);
    }

    protected void loadPage() {
        getDriver().get(getBaseUrl() + getPath());
    }

    private String getPath() {
        if (this.getClass().isAnnotationPresent(PagePath.class)) {
            return this.getClass().getAnnotation(PagePath.class).value();
        } else {
            return StringUtils.EMPTY;
        }
    }

    private String getBaseUrl() {
        return BASE_URL;
    }

    protected WebDriver getDriver() {
        return DriverProvider.getCurrentDriver();
    }
}

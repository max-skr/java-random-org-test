package org.random.test.pages.general;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.random.test.data.navigation.GamesNavigation;
import org.random.test.data.navigation.NavigationItem;
import org.random.test.data.navigation.NumbersNavigation;
import org.random.test.pages.AbstractPage;
import org.random.test.pages.components.NavigationComponent;
import org.random.test.utils.WaitUtils;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public abstract class NavigationPage<T extends NavigationPage<T>> extends AbstractPage<T> {

    private static final Map<Class<? extends NavigationItem>, NavigationSection> CLASS_NAVIGATION_SECTION_MAP =
            ImmutableMap.<Class<? extends NavigationItem>, NavigationSection>builder()
                    .put(GamesNavigation.class, NavigationSection.GAMES)
                    .put(NumbersNavigation.class, NavigationSection.NUMBERS)
                    .build();

    @FindBy(xpath = "//ul[@id = 'navigation']//a[text() = 'Home']")
    private WebElement homeButton;

    @FindBy(xpath = "//ul[@id = 'navigation']//a[text() = 'Login']")
    private WebElement loginButton;

    public void navigateTo(NavigationItem item) {
        Objects.requireNonNull(item, "Navigation item should be defined");
        NavigationSection section = Optional.ofNullable(CLASS_NAVIGATION_SECTION_MAP.get(item.getClass()))
                .orElseThrow(() -> new NoSuchElementException("No mapping for navigation item: " + item));
        getNavigationComponent(section).navigate(item);
    }

    public HomePage navigateHome() {
        homeButton.click();
        return WaitUtils.waitUntilLoaded(new HomePage());
    }

    public LoginPage navigateToLogin() {
        loginButton.click();
        return WaitUtils.waitUntilLoaded(new LoginPage());
    }

    private NavigationComponent getNavigationComponent(NavigationSection section) {
        By sectionLocator = By.xpath(String.format("//li[child::a[text() = '%s']]", section.desc));
        return new NavigationComponent(getDriver().findElement(sectionLocator));
    }

    private enum NavigationSection {
        GAMES("Games"),
        NUMBERS("Numbers"),
        LIST("Lists & More"),
        DRAWINGS("Drawings"),
        WEB_TOOLS("Web Tools"),
        STATISTICS("Statistics"),
        TESTIMONIALS("Testimonials"),
        LEARN_MORE("Learn More");

        private final String desc;

        NavigationSection(String description) {
            this.desc = description;
        }

    }
}

package org.random.test.tests.essential;

import org.random.test.data.navigation.NavigationItem;
import org.random.test.pages.general.HomePage;
import org.random.test.pages.general.NavigationPage;
import org.random.test.tests.AbstractTest;
import org.random.test.tests.data.NavigationDataProvider;
import org.random.test.utils.WaitUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationTest extends AbstractTest {

    private NavigationPage<?> navigationPage;

    @BeforeTest
    public void loadHomePage() {
        navigationPage = new HomePage().get();
    }

    @Test(dataProviderClass = NavigationDataProvider.class, dataProvider = "gamesNavigation")
    public void testGamesNavigation(NavigationItem item) {
        testNavigation(item);
    }

    @Test(dataProviderClass = NavigationDataProvider.class, dataProvider = "numbersNavigation")
    public void testNumbersNavigation(NavigationItem item) {
        testNavigation(item);
    }

    private void testNavigation(NavigationItem item) {
        navigationPage.navigateTo(item);
        WaitUtils.waitUntilLoaded(item.getRedirectionTarget());
    }
}

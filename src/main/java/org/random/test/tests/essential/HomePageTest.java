package org.random.test.tests.essential;

import org.random.test.pages.general.HomePage;
import org.random.test.tests.AbstractTest;
import org.random.test.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractTest {

    @Test
    public void testLoadHomePage() {
        Assert.assertTrue(new HomePage().get().isLoaded(), "Home page is not loaded!");
    }

    @Test(dataProvider = "limitsDataProvider")
    public void testHomePageRandomGeneratorForm(int min, int max) {
        HomePage homePage = new HomePage().get().generateNumber(min, max);

        verifyGeneratedNumber(homePage, min, max);
    }

    @Test(dataProvider = "maxValues")
    public void testHomePageRandomGeneratorAutomaticLimitsMaxValueCorrection(int max) {
        int min = max + 5;
        int expectedMax = min + 1;
        HomePage homePage = new HomePage().get().generateNumber(min, max);

        verifyGeneratedNumber(homePage, min, expectedMax);
    }

    private void verifyGeneratedNumber(HomePage page, int min, int max) {
        WaitUtils.waitAsserted(() -> {
            Integer result = page.getGeneratedNumber();
            Assert.assertNotNull(result, "Result should be not null");
            String message = String.format("Result should be in limits: min = '%s' and max = '%s'", min, max);
            Assert.assertTrue((result <= max && result >= min), message);
        });
    }

    @DataProvider
    private static Object[][] limitsDataProvider() {
        return new Object[][] {
                {1, 5},
                {0, 100},
                {-10, -1}
        };
    }

    @DataProvider
    private static Object[][] maxValues() {
        return new Object[][] {{100}, {0}, {-999}};
    }
}

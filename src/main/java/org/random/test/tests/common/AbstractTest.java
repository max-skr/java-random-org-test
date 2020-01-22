package org.random.test.tests.common;

import org.random.test.utils.Browser;
import org.random.test.utils.DriverProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractTest {

    @BeforeTest
    public void setupDriver() {
        DriverProvider.start(Browser.CHROME);
    }

    @AfterTest(alwaysRun = true)
    public void stopDriver() {
        DriverProvider.releaseCurrentDriver();
    }
}

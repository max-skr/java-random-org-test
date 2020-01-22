package org.random.test.tests.common;

import org.random.test.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonTest extends AbstractTest {

    @Test
    public void testLoadHomePage() {
        Assert.assertTrue(new HomePage().get().isLoaded(), "Home page is not loaded!");
    }

}

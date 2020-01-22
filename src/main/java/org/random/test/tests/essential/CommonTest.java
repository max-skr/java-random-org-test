package org.random.test.tests.essential;

import org.random.test.pages.general.HomePage;
import org.random.test.tests.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonTest extends AbstractTest {

    @Test
    public void testLoadHomePage() {
        Assert.assertTrue(new HomePage().get().isLoaded(), "Home page is not loaded!");
    }

}
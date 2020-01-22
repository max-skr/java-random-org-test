package org.random.test.tests.data;

import org.random.test.data.navigation.GamesNavigation;
import org.testng.annotations.DataProvider;

public class NavigationDataProvider {

    @DataProvider
    public static Object[][] gamesNavigation() {
        return new Object[][] {
                {GamesNavigation.LOTTERY},
                {GamesNavigation.KENO},
                {GamesNavigation.COIN},
                {GamesNavigation.DICE},
                {GamesNavigation.CARD_SHUFFLER},
                {GamesNavigation.BIRDIE}
        };
    }

}

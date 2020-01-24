package org.random.test.tests.data;

import org.random.test.data.navigation.GamesNavigation;
import org.random.test.data.navigation.NumbersNavigation;
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

    @DataProvider
    public static Object[][] numbersNavigation() {
        return new Object[][] {
                {NumbersNavigation.INTEGERS},
                {NumbersNavigation.SEQUENCES},
                {NumbersNavigation.INTEGERS_SETS},
                {NumbersNavigation.GAUSSIAN_NUMBERS},
                {NumbersNavigation.DECIMAL_FRACTIONS},
                {NumbersNavigation.RAW_BYTES}
        };
    }

}

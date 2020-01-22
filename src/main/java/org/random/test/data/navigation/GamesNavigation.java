package org.random.test.data.navigation;

import org.random.test.pages.AbstractPage;
import org.random.test.pages.games.*;

public enum GamesNavigation implements NavigationItem {
    LOTTERY("Lottery Quick Pick", LotteryQuickPickGamePage.class),
    KENO("Keno Quick Pick", KenoQuickPickGamePage.class),
    COIN("Coin Flipper", CoinFlipperGamePage.class),
    DICE("Dice Roller", DiceRollerGamePage.class),
    CARD_SHUFFLER("Playing Card Shuffler", PlayingCardShufflerGamePage.class),
    BIRDIE("Birdie Fund Generator", BirdieFundRandomizerGamePage.class);

    private final String description;

    private final Class<? extends AbstractPage<?>> redirectionTarget;

    GamesNavigation(String desc, Class<? extends AbstractPage<?>> redirectionTarget) {
        this.description = desc;
        this.redirectionTarget = redirectionTarget;
    }

    @Override
    public String getName() {
        return this.description;
    }

    @Override
    public Class<? extends AbstractPage<?>> getRedirectionTarget() {
        return redirectionTarget;
    }
}

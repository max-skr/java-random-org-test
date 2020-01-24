package org.random.test.data.navigation;

import org.random.test.pages.AbstractPage;
import org.random.test.pages.numbers.*;

public enum NumbersNavigation implements NavigationItem {

    INTEGERS("Integers", IntegerNumbersPage.class),
    SEQUENCES("Sequences", SequencesNumbersPage.class),
    INTEGERS_SETS("Integer Sets", IntegerSetsNumbersPage.class),
    GAUSSIAN_NUMBERS("Gaussian Numbers", GaussianNumbersPage.class),
    DECIMAL_FRACTIONS("Decimal Fractions", DecimalFractionsNumbersPage.class),
    RAW_BYTES("Raw Bytes", RawBytesNumbersPage.class);

    private final String description;

    private final Class<? extends AbstractPage<?>> redirectionTarget;

    NumbersNavigation(String desc, Class<? extends AbstractPage<?>> redirectionTarget) {
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

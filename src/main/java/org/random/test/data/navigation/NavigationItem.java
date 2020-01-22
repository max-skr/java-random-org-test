package org.random.test.data.navigation;

import org.random.test.pages.AbstractPage;

public interface NavigationItem {

    String getName();

    Class<? extends AbstractPage<?>> getRedirectionTarget();

}

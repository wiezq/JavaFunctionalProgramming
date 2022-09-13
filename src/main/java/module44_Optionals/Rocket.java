package module44_Optionals;

import java.util.*;

class Rocket {
    private final NavigationModule navigationModule;

    public Rocket(NavigationModule navigationModule) {
        this.navigationModule = navigationModule;
    }

    public Optional<NavigationModule> getNavigationModule() {
        return Optional.ofNullable(navigationModule);

    }
}

class NavigationModule {
    private final String title;

    public NavigationModule(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
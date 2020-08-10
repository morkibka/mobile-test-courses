package lib.ui.mobileWeb;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    static {
        MyListLink = "css:a[data-event-name='watchlist']";
        OpenNavigation = "css:#mw-mf-main-menu-button";

    }
    public MWNavigationUI(RemoteWebDriver driver){
        super(driver);
    }
}


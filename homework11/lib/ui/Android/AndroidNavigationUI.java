package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyLIsts;
import lib.ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {
    static {
        MyListLink = "xpath://android.widget.ImageView[@content-desc='My lists']";
    }
    public AndroidNavigationUI(AppiumDriver driver){
        super(driver);
    }
}

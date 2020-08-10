package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyLIsts;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI {
    static {
        MyListLink = "xpath://android.widget.ImageView[@content-desc='My lists']";
    }
    public AndroidNavigationUI(RemoteWebDriver driver){
        super(driver);
    }
}

package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidNavigationUI;
import lib.ui.IOS.IOSNavigationUI;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory {
    public static NavigationUI get (RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(driver);
        } else {
            return new IOSNavigationUI(driver);
        }
    }
}

package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidMyListPageObj;
import lib.ui.IOS.IOSMyListPageObj;
import lib.ui.MyLIsts;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListPageObjectFactory {
    public static MyLIsts get(RemoteWebDriver driver){
        if(Platform.getInstance().isAndroid()){
            return new AndroidMyListPageObj(driver);

        } else {
            return new IOSMyListPageObj(driver);
        }
    }
}

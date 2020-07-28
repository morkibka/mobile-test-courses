package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidMyListPageObj;
import lib.ui.IOS.IOSMyListPageObj;
import lib.ui.MyLIsts;

public class MyListPageObjectFactory {
    public static MyLIsts get(AppiumDriver driver){
        if(Platform.getInstance().isAndroid()){
            return new AndroidMyListPageObj(driver);

        } else {
            return new IOSMyListPageObj(driver);
        }
    }
}

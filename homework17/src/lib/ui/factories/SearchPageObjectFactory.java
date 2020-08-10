package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidSearchPageObject;
import lib.ui.IOS.IOSSearchPageObject;
import lib.ui.SearchTestObject;

public class SearchPageObjectFactory {
    public static SearchTestObject get(AppiumDriver driver){
if(Platform.getInstance().isAndroid()){
    return new AndroidSearchPageObject(driver);
} else {
    return new IOSSearchPageObject(driver);
}
    }
}

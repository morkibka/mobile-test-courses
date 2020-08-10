package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidSearchPageObject;
import lib.ui.IOS.IOSSearchPageObject;
import lib.ui.SearchTestObject;
import lib.ui.mobileWeb.MWsearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory {
    public static SearchTestObject get(RemoteWebDriver driver){
if(Platform.getInstance().isAndroid()){
    return new AndroidSearchPageObject(driver);
} else  if(Platform.getInstance().osIOS()){
    return new IOSSearchPageObject(driver);
} else {
    return new MWsearchPageObject(driver);
}
    }
}

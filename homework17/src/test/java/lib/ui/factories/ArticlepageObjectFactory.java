package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidArticlePageObject;
import lib.ui.ArticlePagoObject;
import lib.ui.IOS.IOSArticlePageObject;
import lib.ui.mobileWeb.MWArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlepageObjectFactory {
    public static ArticlePagoObject get(RemoteWebDriver driver){
        if(Platform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        }else if (Platform.getInstance().osIOS()){
            return new IOSArticlePageObject(driver);
        } else {
            return new MWArticlePageObject(driver);
        }
    }
}

package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidArticlePageObject;
import lib.ui.ArticlePagoObject;
import lib.ui.IOS.IOSArticlePageObject;

public class ArticlepageObjectFactory {
    public static ArticlePagoObject get(AppiumDriver driver){
        if(Platform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        }else {
            return new IOSArticlePageObject(driver);
        }
    }
}

package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePagoObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePagoObject {
    static {
        Title = "id:Java (programming language)";
        Footer = "id:View article in browser";
        AddToRead = "id:Save to later";
        CloseArtBtn = "id:Back";
    }
    public IOSArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}

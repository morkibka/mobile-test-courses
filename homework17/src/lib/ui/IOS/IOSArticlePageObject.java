package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePagoObject;

public class IOSArticlePageObject extends ArticlePagoObject {
    static {
        Title = "id:Java (programming language)";
        Footer = "id:View article in browser";
        AddToRead = "id:Save to later";
        CloseArtBtn = "id:Back";
    }
    public IOSArticlePageObject(AppiumDriver driver){
        super(driver);
    }
}

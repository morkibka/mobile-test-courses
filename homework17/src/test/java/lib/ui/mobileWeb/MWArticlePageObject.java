package lib.ui.mobileWeb;

import lib.ui.ArticlePagoObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePagoObject {
    static {
        Title = "css:#content h1";
        Footer = "css:footer";
        AddToRead = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button";
        OptRemoveFromMyList = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watched watched button";
    }
    public MWArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}


package lib.ui.mobileWeb;

import lib.ui.MyLIsts;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyLIsts {
    static {
        ArticleByTitle = "xpath://url[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]";
RemoveFromSaveBtn = "xpath://url[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]/../../div[contains(@class,'watched')]";
        FirstArticleInMyList = "id:org.wikipedia:id/page_list_item_container";
        NoSearchResults = "id:No saved pages yet";


    }
    public MWMyListsPageObject (RemoteWebDriver driver){
        super(driver);
    }

}


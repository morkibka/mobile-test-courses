package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyLIsts;

public class IOSMyListPageObj extends MyLIsts {
        static {
            ArticleByTitle = "xpath://XCUIElementTypeLink[contains,(@name='{Title}')]";
            FirstArticleInMyList = "id:org.wikipedia:id/page_list_item_container";
            NoSearchResults = "id:No saved pages yet";

        }
        public IOSMyListPageObj(AppiumDriver driver){
            super(driver);
        }

    }


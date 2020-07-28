package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyLIsts;

public class AndroidMyListPageObj extends MyLIsts {
    static {
        FolderByName = "xpath://*[@text='{Folder_name}']";
                ArticleByTitle = "xpath://*[@text='{Title}']";
                FirstArticleInMyList = "id:org.wikipedia:id/page_list_item_container";

    }
    public AndroidMyListPageObj(AppiumDriver driver){
        super(driver);
    }

}

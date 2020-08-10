package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchTestObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchTestObject {
static {
    Serch_init_el = "xpath://*[contains(@text,'Search Wikipedia')]";
            Serch_input = "xpath://*[contains(@text,'Search...')]";
            Search_result_by_substring = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text='{SUBSTRING}')]";
            SearchResultElement = "xpath://*[resouce-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
            SearchEmpty = "xpath://*[@text='No results found']";
            CancelSearch = "id:org.wikipedia:id/search_close_btn";
}
    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

}

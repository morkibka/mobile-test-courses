package lib.ui.mobileWeb;

import lib.ui.SearchTestObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWsearchPageObject extends SearchTestObject {
    static {
        Serch_init_el = "css:button#searchIcon";
        Serch_input = "css:form>input[type='search']";
        Search_result_by_substring = "css:button.cancel";
        SearchResultElement = "xpath://div[contains(@class,'wikipedia-description')][contains(text(),'{SUBSTRING}')]";
        SearchEmpty = "css:ul.page-list>li.page-summary";
        CancelSearch = "css:p.without-results";
    }
    public MWsearchPageObject(RemoteWebDriver driver){
        super(driver);
    }

}

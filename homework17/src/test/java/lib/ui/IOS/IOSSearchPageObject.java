package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchTestObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchTestObject {
    static {
        Serch_init_el = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        Serch_input = "xpath://XCUIElementTypeSearchField[@value='Search Wikipedia']";
        Search_result_by_substring = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SearchResultElement = "xpath://XCUIElementTypeCell";
        SearchEmpty = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        CancelSearch = "id:Close";
    }

    public IOSSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }
}

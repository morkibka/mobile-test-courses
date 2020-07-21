package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTestObject extends MainClassObject {

    private static final String
    Serch_init_el = "xpath://*[contains(@text,'Search Wikipedia')]",
    Serch_input = "xpath://*[contains(@text,'Search…')]",
    Search_result_by_substring = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='(SUBSTRING)']",
            SearchResultElement = "xpath://*[resouce-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
            SearchEmpty = "xpath://*[@text='No results found']",
    CancelSearch = "id:org.wikipedia:id/search_close_btn";

    public SearchTestObject(AppiumDriver driver){

        super(driver);
    }
    private static String getResultSearchElement(String substring){
        return Search_result_by_substring.replace("(SUBSTRING)", substring);
    }

    public void clickForCancelSearch(){
        this.waitNClick(CancelSearch, "cant find X for cancel search", 10);

    }
    public boolean waitForEmptySearchResults() {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withMessage("search results tab are still here" + "\n");

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Search_result_by_substring)));

    }
    public void initSearchInput(){
        this.waitNClick(Serch_init_el, "cant find n click search", 5);
        this.waitForBy(Serch_init_el, "cant find n click search");
    }
    public void typeSearchLine(String search_line) {
        this.waitNSend(Serch_input,search_line, "cant find input", 5);
    }
public void waiForSearchRes(String substring){
        String searchResultXPath = getResultSearchElement(substring);
        this.waitForBy(searchResultXPath, "cant find search res " + substring);

}
    public void clickByArticleWithSubstring(String substring){
        String searchResultXPath = getResultSearchElement(substring);
        this.waitNClick(searchResultXPath, "cant find n click search res " + substring, 10);

    }
    public int getAmountOfArticles(){
       this. waitForBy(SearchResultElement, "cant find", 15);
       return this.getAmount(SearchResultElement);
    }
    public void waitForEmptyResults(){
        this.waitForBy(SearchEmpty, "cant find empty result",15);

    }
    public void assertThatNotResult(){
        this.assertElemNot(SearchResultElement, "we Supposed not find any results");
    }
}

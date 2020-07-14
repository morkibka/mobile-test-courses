package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePagoObject;
import lib.ui.MyLIsts;
import lib.ui.NavigationUI;
import lib.ui.SearchTestObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class SearchTests extends CoreTestCase {
    SearchTestObject searchTestObject = new SearchTestObject(driver);
    ArticlePagoObject articlePagoObject = new ArticlePagoObject(driver);
    NavigationUI navigationUI = new NavigationUI(driver);
    MyLIsts myLIsts = new MyLIsts(driver);

    @Test //Ex3
    public void testCancelSearchTest() {

        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.waiForSearchRes("Object-oriented programming language");
        searchTestObject.waiForSearchRes("Island of Indonesia");
searchTestObject.clickForCancelSearch();
searchTestObject.waitForEmptySearchResults();


    }
    @Test
    public void testAssertTitle() {

        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.waiForSearchRes("Object-oriented programming language");

    }
    @Test
    public void testAmount() {
        searchTestObject.initSearchInput();
        String searchLine = "Linkin park diskography";
        searchTestObject.typeSearchLine(searchLine);


        int amount = searchTestObject.getAmountOfArticles();
        assertTrue("we found smth", amount > 0);
    }
    @Test
    public void testAmountOf() {
        searchTestObject.initSearchInput();
        String searchLine = "afsdgfdg";
        searchTestObject.typeSearchLine(searchLine);
        searchTestObject.waitForEmptyResults();
        searchTestObject.assertThatNotResult();
    }

}

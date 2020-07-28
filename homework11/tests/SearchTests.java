package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePagoObject;
import lib.ui.MyLIsts;
import lib.ui.NavigationUI;
import lib.ui.SearchTestObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;

public class SearchTests extends CoreTestCase {


    @Test //Ex3
    public void testCancelSearchTest() {
        SearchTestObject searchTestObject = SearchPageObjectFactory.get(driver);


        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.waiForSearchRes("Object-oriented programming language");
        searchTestObject.waiForSearchRes("Island of Indonesia");
searchTestObject.clickForCancelSearch();
searchTestObject.waitForEmptySearchResults();


    }
    @Test
    public void testAssertTitle() {
        SearchTestObject searchTestObject = SearchPageObjectFactory.get(driver);


        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.waiForSearchRes("Object-oriented programming language");

    }
    @Test
    public void testAmount() {
        SearchTestObject searchTestObject = SearchPageObjectFactory.get(driver);

        searchTestObject.initSearchInput();
        String searchLine = "Linkin park diskography";
        searchTestObject.typeSearchLine(searchLine);


        int amount = searchTestObject.getAmountOfArticles();
        assertTrue("we found smth", amount > 0);
    }
    @Test
    public void testAmountOf() {
        SearchTestObject searchTestObject = SearchPageObjectFactory.get(driver);

        searchTestObject.initSearchInput();
        String searchLine = "afsdgfdg";
        searchTestObject.typeSearchLine(searchLine);
        searchTestObject.waitForEmptyResults();
        searchTestObject.assertThatNotResult();
    }

}

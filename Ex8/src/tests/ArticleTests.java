package tests;

import lib.CoreTestCase;
import lib.ui.MyLIsts;
import lib.ui.NavigationUI;
import org.junit.Test;
import lib.ui.ArticlePagoObject;
import lib.ui.SearchTestObject;


public class ArticleTests extends CoreTestCase {

    SearchTestObject searchTestObject = new SearchTestObject(driver);
    ArticlePagoObject articlePagoObject = new ArticlePagoObject(driver);
    NavigationUI navigationUI = new NavigationUI(driver);
    MyLIsts myLIsts = new MyLIsts(driver);

    @Test//Ex6
    public void testAssertTitle() {
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("Object-oriented programming language");
        articlePagoObject.assertThatHaveTitle();


    }

    @Test
    public void testCompare() {
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("Object-oriented programming language");
        articlePagoObject.waitForTitle();
        String article = articlePagoObject.getArticleTitle();
        assertEquals("we see unexpct title","Java (programming language)",article);

    }

    @Test
    public void testSwipe() {
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("Appium");
        searchTestObject.clickByArticleWithSubstring("Appium");
        articlePagoObject.waitForTitle();
        articlePagoObject.swipeToFooter();


    }

}

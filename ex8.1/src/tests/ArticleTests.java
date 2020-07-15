package tests;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;


public class ArticleTests extends CoreTestCase {






    @Test//Ex6
    public void testAssertTitle() {
        SearchTestObject searchTestObject = new SearchTestObject(driver);
        ArticlePagoObject articlePagoObject = new ArticlePagoObject(driver);
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("Object-oriented programming language");
        articlePagoObject.assertThatHaveTitle();


    }

    @Test
    public void testCompare() {
        SearchTestObject searchTestObject = new SearchTestObject(driver);
        ArticlePagoObject articlePagoObject = new ArticlePagoObject(driver);
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("Object-oriented programming language");
        articlePagoObject.waitForTitle();
        String article = articlePagoObject.getArticleTitle();
        assertEquals("we see unexpct title","Java (programming language)",article);

    }

    @Test
    public void testSwipe() {
        SearchTestObject searchTestObject = new SearchTestObject(driver);
        ArticlePagoObject articlePagoObject = new ArticlePagoObject(driver);
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("Appium");
        searchTestObject.clickByArticleWithSubstring("Appium");
        articlePagoObject.waitForTitle();
        articlePagoObject.swipeToFooter();


    }

}

package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlepageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


public class ArticleTests extends CoreTestCase {






    @Test//Ex6
    public void testAssertTitle() {
        SearchTestObject searchTestObject = SearchPageObjectFactory.get(driver);
        ArticlePagoObject articlePagoObject = ArticlepageObjectFactory.get(driver);
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("Object-oriented programming language");
        articlePagoObject.assertThatHaveTitle();


    }

    @Test
    public void testCompare() {
        SearchTestObject searchTestObject = SearchPageObjectFactory.get(driver);
        ArticlePagoObject articlePagoObject = ArticlepageObjectFactory.get(driver);
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("Object-oriented programming language");
        articlePagoObject.waitForTitle();
        String article = articlePagoObject.getArticleTitle();
        assertEquals("we see unexpct title","Java (programming language)",article);

    }

    @Test
    public void testSwipe() {
        SearchTestObject searchTestObject = SearchPageObjectFactory.get(driver);
        ArticlePagoObject articlePagoObject = ArticlepageObjectFactory.get(driver);
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("Java");
        searchTestObject.clickByArticleWithSubstring("Object-oriented programming language");
        articlePagoObject.waitForTitle();
        articlePagoObject.swipeToFooter();


    }

}

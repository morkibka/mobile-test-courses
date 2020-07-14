package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePagoObject;
import lib.ui.MyLIsts;
import lib.ui.NavigationUI;
import lib.ui.SearchTestObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyListsTests extends CoreTestCase {
    SearchTestObject searchTestObject = new SearchTestObject(driver);
    ArticlePagoObject articlePagoObject = new ArticlePagoObject(driver);
    NavigationUI navigationUI = new NavigationUI(driver);
    MyLIsts myLIsts = new MyLIsts(driver);

    @Test //Ex5
    public void testSaveTwoArticle() {

        String nameOfFolder = "Learning programming";
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("Object-oriented programming language");
        articlePagoObject.waitForTitle();
        articlePagoObject.addFirstArticleAndCreateMyList(nameOfFolder);
        articlePagoObject.closeArticle();
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("Island of Indonesia");
        articlePagoObject.waitForTitle();
        String article = articlePagoObject.getArticleTitle();
        articlePagoObject.addArticleInMyList();
        articlePagoObject.closeArticle();
        articlePagoObject.openMyListTab();
        articlePagoObject.openMyList();
        myLIsts.swipeByArticleToDelete(article);
        myLIsts.waitForArtAppear("island of Indonesia");
        String title = articlePagoObject.getArticleTitle();
        Assert.assertEquals("we see unexpected title","Java",title);

    }

    @Test
    public void testSavedArticle() {

        String nameOfFolder = "Learning programming";
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("Object-oriented programming language");
        articlePagoObject.waitForTitle();
        String article = articlePagoObject.getArticleTitle();
        articlePagoObject.addFirstArticleAndCreateMyList(nameOfFolder);
        articlePagoObject.closeArticle();
        navigationUI.clickMyList();
        myLIsts.openFlderByName(nameOfFolder);
        myLIsts.swipeByArticleToDelete(article);

    }

}

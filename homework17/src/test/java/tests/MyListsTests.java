package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlepageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MyListsTests extends CoreTestCase {
    private static final         String nameOfFolder = "Learning programming";
    private static final String login = "morkibka",
    password = "Qwerty123";



    @Test //Ex11
    public void testSaveTwoArticle() {
        SearchTestObject searchTestObject = SearchPageObjectFactory.get(driver);
        ArticlePagoObject articlePagoObject = ArticlepageObjectFactory.get(driver);
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        MyLIsts myLIsts = MyListPageObjectFactory.get(driver);
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("bject-oriented programming language");
        articlePagoObject.waitForTitle();
        String article = articlePagoObject.getArticleTitle();

        String firstArticle = articlePagoObject.getArticleTitle();
        if(Platform.getInstance().isAndroid()){
            articlePagoObject.addFirstArticleAndCreateMyList(nameOfFolder);
        } else {
            articlePagoObject.addArticleToMy();
        }
        if(Platform.getInstance().isMW()){
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthBtn();
            Auth.enterLogData(login, password);
            Auth.submitForm();
            articlePagoObject.waitForTitle();
            assertEquals("we are mot on the same page after login", firstArticle, articlePagoObject.getArticleTitle());
            articlePagoObject.addArticleToMy();
        }
        articlePagoObject.closeArticle();
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("Java");
        searchTestObject.clickByArticleWithSubstring("sland of Indonesia");
        articlePagoObject.waitForTitle();
        String secondArticle = articlePagoObject.getArticleTitle();
        if(Platform.getInstance().isAndroid()){
            articlePagoObject.addArticleInMyList();
        } else {
            articlePagoObject.addArticleToMy();
        }
        articlePagoObject.closeArticle();
        navigationUI.OpenNavigation();
        navigationUI.clickMyList();
        if (Platform.getInstance().isAndroid()){
            myLIsts.openFlderByName(nameOfFolder);
        }
        myLIsts.swipeByArticleToDelete(firstArticle);
        if(Platform.getInstance().isAndroid() || Platform.getInstance().osIOS()){
            myLIsts.isCellInMyListPresent();
        } else {
            myLIsts.isArticleAbsenceTextNotPresent();        }
    }



    @Test
    public void testSavedArticle() {
        SearchTestObject searchTestObject = SearchPageObjectFactory.get(driver);
        ArticlePagoObject articlePagoObject = ArticlepageObjectFactory.get(driver);
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        MyLIsts myLIsts = MyListPageObjectFactory.get(driver);

        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("bject-oriented programming language");
        articlePagoObject.waitForTitle();
        String article = articlePagoObject.getArticleTitle();
        if(Platform.getInstance().isAndroid()){
            articlePagoObject.addFirstArticleAndCreateMyList(nameOfFolder);
        } else {
            articlePagoObject.addArticleToMy();
        }
        if(Platform.getInstance().isMW()){
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthBtn();
            Auth.enterLogData(login, password);
            Auth.submitForm();
            articlePagoObject.waitForTitle();
            assertEquals("we are mot on the same page after login", article, articlePagoObject.getArticleTitle());
            articlePagoObject.addArticleToMy();
        }
        articlePagoObject.closeArticle();

        navigationUI.OpenNavigation();

        navigationUI.clickMyList();
        if (Platform.getInstance().isAndroid()){
            myLIsts.openFlderByName(nameOfFolder);

        }
        myLIsts.swipeByArticleToDelete(article);

    }

}

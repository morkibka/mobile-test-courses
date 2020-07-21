package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePagoObject;
import lib.ui.MyLIsts;
import lib.ui.NavigationUI;
import lib.ui.SearchTestObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

public class ChangeAppCondition extends CoreTestCase {






    @Test
    public void testChangeOrientation(){
        SearchTestObject searchTestObject = new SearchTestObject(driver);
        ArticlePagoObject articlePagoObject = new ArticlePagoObject(driver);
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.clickByArticleWithSubstring("Object-oriented programming language");
        String title_before = articlePagoObject.getArticleTitle();
        this.rotateScreenLand();
        String title_after = articlePagoObject.getArticleTitle();
        assertEquals(" ", title_before, title_after);
        this.rotateScreenPortrait();
        String title_after_sec = articlePagoObject.getArticleTitle();
        assertEquals(" ", title_before, title_after_sec);




    }


    @Test
    public void testBacktest(){
        SearchTestObject searchTestObject = new SearchTestObject(driver);
        ArticlePagoObject articlePagoObject = new ArticlePagoObject(driver);
        searchTestObject.initSearchInput();
        searchTestObject.typeSearchLine("java");
        searchTestObject.waiForSearchRes("Object-oriented programming language");
        this.back(2);
        searchTestObject.waiForSearchRes("Object-oriented programming language");
    }


}

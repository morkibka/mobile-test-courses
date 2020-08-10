package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class MyLIsts extends MainClassObject{
    protected static String
    FolderByName,
    ArticleByTitle,
    FirstArticleInMyList,
    NoSearchResults;

    private static String getFolderXpathByName(String nameOfFolder){
        return FolderByName.replace("{Folder_name}", nameOfFolder);

    }
    private static String getSavedArticleXpathByTitle(String article_title){
        return ArticleByTitle.replace("{Title }", article_title);

    }
    public MyLIsts(AppiumDriver driver) {
        super(driver);
    }
    public void openFlderByName(String nameOfFolder){
        String folderNameXpath = getFolderXpathByName(nameOfFolder);
        this.waitNClick(folderNameXpath, "cant find folder by name " + nameOfFolder, 5);


    }
    public void swipeByArticleToDelete(String article_title){
        this.waitForArtAppear(article_title);
        String articleXpath = getSavedArticleXpathByTitle(article_title);

        swipeElementToLeft(articleXpath,"cant swipe");
        if(Platform.getInstance().osIOS()){
this.clickElToRightCorn(articleXpath + "/..", "cant tap on corner");
        }
this.waitForArtDissapear(article_title);


    }
    public void waitForArtDissapear(String article_title){
        String articleXpath = getSavedArticleXpathByTitle(article_title);
this.waitForElemNot(articleXpath, "Saved art still pres", 15);

    }
    public void waitForArtAppear(String article_title){
        String articleXpath = getSavedArticleXpathByTitle(article_title);
        this.waitForBy(articleXpath, "cant find art by title", 15);

    }
    public void openFirstArt(){
        this.waitNClick(FirstArticleInMyList,"cant find  first article in my list", 5);
    }
    public boolean isArticleAbsenceTextNotPresent() {
        return this.waitForElemNot(NoSearchResults, "can find dome article", 5);
    }
    public boolean isCellInMyListPresent(){
        return this.isElementPresent(FirstArticleInMyList);
    }
}

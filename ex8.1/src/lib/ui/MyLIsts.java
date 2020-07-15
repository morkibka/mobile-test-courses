package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyLIsts extends MainClassObject{
    public static final String
    FolderByName = "//*[@text='{Folder_name}']",
    ArticleByTitle = "//*[@text='{Title}']",
    FirstArticleInMyList = "org.wikipedia:id/page_list_item_container";
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
        this.waitNClick(By.xpath(folderNameXpath), "cant find folder by name " + nameOfFolder, 5);


    }
    public void swipeByArticleToDelete(String article_title){
        this.waitForArtAppear(article_title);
        String articleXpath = getSavedArticleXpathByTitle(article_title);

        swipeElementToLeft(By.xpath(articleXpath),"cant swipe");
this.waitForArtDissapear(article_title);


    }
    public void waitForArtDissapear(String article_title){
        String articleXpath = getSavedArticleXpathByTitle(article_title);
this.waitForElemNot(By.xpath(articleXpath), "Saved art still pres", 15);

    }
    public void waitForArtAppear(String article_title){
        String articleXpath = getSavedArticleXpathByTitle(article_title);
        this.waitForBy(By.xpath(articleXpath), "cant find art by title", 15);

    }
    public void openFirstArt(){
        this.waitNClick(By.xpath(FirstArticleInMyList),"cant find  first article in my list", 5);
    }
}

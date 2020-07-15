package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePagoObject extends MainClassObject {
    private static final String
    Title = "org.wikipedia:id/view_page_title_text",
    Footer = "//*[@text='View page in browser1']",
    Options = "//android.widget.ImageView[@content-desc='More options']",
    AddToRead = "//*[@text='Add to reading list']",
    IdOverlay = "org.wikipedia:id/onboarding_button",
    TextInput = "org.wikipedia:id/text_input",
    OKButton = "//*[@text='OK']",
    CloseArtBtn = "//android.widget.ImageButton[@content-desc='Navigate up']",
    MyListContainer = "org.wikipedia:id/item_container",
    MylistTab = "//android.widget.FrameLayout[@content-desc='My lists']";


    public ArticlePagoObject(AppiumDriver driver){

        super(driver);
    }
    public WebElement waitForTitle(){
        return this.waitForBy(By.id(Title), "cant find article title", 15);
    }
    public String getArticleTitle(){
        WebElement title_element = waitForTitle();
        return title_element.getAttribute("text");

    }
public void swipeToFooter(){
        this.swipeUpToElement(By.xpath(Footer), "cant find footer", 20);
}

public void addFirstArticleAndCreateMyList(String name_of_folder){
    this.waitNClick(By.xpath(Options), "cant find btn for art opt", 5);
    this.waitNClick(By.xpath(AddToRead), "cant find opt to add article to readf list", 5);
    this.waitNClick(By.id(IdOverlay), "cant find got id overlay", 5);
    this.waitForElemNClear(By.id(TextInput), "cant find text input to clear", 5);
    this.waitNSend(By.id(TextInput),name_of_folder, "cant find text input to send keys", 5);
    this.waitNClick(By.xpath(OKButton), "cant press ok", 5);


}
public void addArticleInMyList(){
    this.waitNClick(By.xpath(Options), "cant find btn for art opt", 5);
    this.waitNClick(By.xpath(AddToRead), "cant find opt to add article to reading list", 5);
    this.waitNClick(By.id(MyListContainer), "cant find my list in article tab", 5);



}
public  void openMyListTab(){
    this.waitNClick(By.xpath(MylistTab), "cant find my list tab", 5);

}
    public  void openMyList(){
        this.waitNClick(By.xpath(MyListContainer), "cant find my list tab", 5);

    }
public void closeArticle(){
    this.waitNClick(By.xpath(CloseArtBtn), "cant close art", 5);

}
    public int getAmountOfTitles() {
        this.waitForBy(By.xpath(Title), "cant find titles", 15);
        return getAmount(By.xpath(Title));


    }
    public void assertThatHaveTitle(){
        int amount = getAmountOfTitles();
        Assert.assertTrue("cant see some articles",amount > 0);
    }
    public int getAmount(By by){
        List elements = driver.findElements(by);
        return elements.size();
    }
}

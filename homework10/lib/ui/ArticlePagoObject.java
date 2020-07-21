package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePagoObject extends MainClassObject {
    private static final String
    Title = "id:org.wikipedia:id/view_page_title_text",
    Footer = "xpath://*[@text='View page in browser1']",
    Options = "xpath://android.widget.ImageView[@content-desc='More options']",
    AddToRead = "xpath://*[@text='Add to reading list']",
    IdOverlay = "id:org.wikipedia:id/onboarding_button",
    TextInput = "id:org.wikipedia:id/text_input",
    OKButton = "xpath://*[@text='OK']",
    CloseArtBtn = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
    MyListContainer = "id:org.wikipedia:id/item_container",
    MylistTab = "xpath://android.widget.FrameLayout[@content-desc='My lists']";


    public ArticlePagoObject(AppiumDriver driver){

        super(driver);
    }
    public WebElement waitForTitle(){
        return this.waitForBy(Title, "cant find article title", 15);
    }
    public String getArticleTitle(){
        WebElement title_element = waitForTitle();
        return title_element.getAttribute("text");

    }
public void swipeToFooter(){
        this.swipeUpToElement(Footer, 20);
}

public void addFirstArticleAndCreateMyList(String name_of_folder){
    this.waitNClick(Options, "cant find btn for art opt", 5);
    this.waitNClick(AddToRead, "cant find opt to add article to readf list", 5);
    this.waitNClick(IdOverlay, "cant find got id overlay", 5);
    this.waitForElemNClear(TextInput, "cant find text input to clear", 5);
    this.waitNSend(TextInput,name_of_folder, "cant find text input to send keys", 5);
    this.waitNClick(OKButton, "cant press ok", 5);


}
public void addArticleInMyList(){
    this.waitNClick(Options, "cant find btn for art opt", 5);
    this.waitNClick(AddToRead, "cant find opt to add article to reading list", 5);
    this.waitNClick(MyListContainer, "cant find my list in article tab", 5);



}
public  void openMyListTab(){
    this.waitNClick(MylistTab, "cant find my list tab", 5);

}
    public  void openMyList(){
        this.waitNClick(MyListContainer, "cant find my list tab", 5);

    }
public void closeArticle(){
    this.waitNClick(CloseArtBtn, "cant close art", 5);

}
    public int getAmountOfTitles() {
        this.waitForBy(Title, "cant find titles", 15);
        return getAmount(Title);


    }
    public void assertThatHaveTitle(){
        int amount = getAmountOfTitles();
        Assert.assertTrue("cant see some articles",amount > 0);
    }

}

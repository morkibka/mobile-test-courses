package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class ArticlePagoObject extends MainClassObject {
    protected static String
        Title,
                Footer,
                Options,
                AddToRead,
                IdOverlay,
                TextInput,
                OKButton,
                CloseArtBtn,
                MyListContainer,
                MylistTab,
    OptRemoveFromMyList;



    public ArticlePagoObject(RemoteWebDriver driver){

        super(driver);
    }
    public WebElement waitForTitle(){
        return this.waitForBy(Title, "cant find article title", 15);
    }
    public String getArticleTitle(){
        WebElement title_element = waitForTitle();
        if(Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");

        }else if  (Platform.getInstance().osIOS()){
        return title_element.getAttribute("name");

    } else{
        return title_element.getText();}
    }
public void swipeToFooter(){
    if (Platform.getInstance().isAndroid()) {
        this.swipeUpToElement(Footer, 40);
    } else if (Platform.getInstance().osIOS()){
        this.swipeTillAppear(Footer, "cant find footer", 40);
    } else {
        this.scrollWebElTillNotVisible(Footer, "cant find footer", 40);
    }
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
        if (Platform.getInstance().osIOS() || Platform.getInstance().isAndroid()){
            this.waitNClick(CloseArtBtn, "cant close art", 5);

        } else {
            System.out.println("Meth closeArt do noth" + Platform.getInstance().getPlatformEnv());
        }

}
    public int getAmountOfTitles() {
        this.waitForBy(Title, "cant find titles", 15);
        return getAmount(Title);


    }
    public void assertThatHaveTitle(){
        int amount = getAmountOfTitles();
        Assert.assertTrue("cant see some articles",amount > 0);
    }
    public void addArticleToMy(){

        if(Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfItAdded();
        }this.waitNClick(AddToRead, "cant find opt to add article", 5);
        }

public void removeArticleFromSavedIfItAdded(){
        if(this.isElPres(OptRemoveFromMyList)){
            this.waitNClick(OptRemoveFromMyList, "cant find opt to click", 1);
            this.waitForBy(AddToRead,"cant find opt", 5);
        }
}
}


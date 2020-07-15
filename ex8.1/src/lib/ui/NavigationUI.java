package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainClassObject {
    private static final String
    MyListLink = "//android.widget.ImageView[@content-desc='My lists']";

    public NavigationUI(AppiumDriver driver){
        super(driver);
    }
public void clickMyList(){
    this.waitNClick(By.xpath(MyListLink), "cant find my lists", 5);

}

}

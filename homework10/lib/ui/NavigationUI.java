package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainClassObject {
    private static final String
    MyListLink = "xpath://android.widget.ImageView[@content-desc='My lists']";

    public NavigationUI(AppiumDriver driver){
        super(driver);
    }
public void clickMyList(){
    this.waitNClick(MyListLink, "cant find my lists", 5);

}

}

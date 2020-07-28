package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainClassObject {
     protected static String
    MyListLink;

    public NavigationUI(AppiumDriver driver){
        super(driver);
    }
public void clickMyList(){
    this.waitNClick(MyListLink, "cant find my lists", 5);

}

}

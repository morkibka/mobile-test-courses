package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainClassObject {
     protected static String
    MyListLink,
    OpenNavigation;

    public NavigationUI(RemoteWebDriver driver){
        super(driver);
    }
    public void OpenNavigation(){
        if (Platform.getInstance().isMW()) {
            this.waitNClick(OpenNavigation, "cant find open navig btn", 5);
        }else{
            System.out.println("meth OpenNavig do noth" + Platform.getInstance().getPlatformEnv());
        }
    }
public void clickMyList(){
        if(Platform.getInstance().isMW()){
            this.tryClickElFewAttemps(MyListLink,"cant find mylistlink", 5);
        }
    this.waitNClick(MyListLink, "cant find my lists", 5);

}

}

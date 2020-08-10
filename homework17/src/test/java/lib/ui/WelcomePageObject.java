package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainClassObject {
    private static final String
    Learn_more = "id:Learn more about Wikipedia",
    New_ways = "id:New ways to explore",
    Add_or_edit = "id:Add or edit preferred text",
    Collector_link = "id:Learn more about data collector",
    Next = "id:Next",
    Started = "id:Get started",
            Skip = "xpath://XCUIElementTypeStaticText[@name='Skip']";


    public WelcomePageObject(RemoteWebDriver driver){
        super(driver);
    }
    public void waitForLearnMoreLink(){
        this.waitForBy(Learn_more, "Cant find first screen", 10);
    }
    public void waitForNewWayToExplore(){
        this.waitForBy(New_ways, "Cant find second screen", 10);
    }
    public void waitForAddOrEdit(){
        this.waitForBy(Add_or_edit, "Cant find third screen", 10);
    }
    public void waitForDataCollectorLink(){
        this.waitForBy(Collector_link, "Cant find fourth screen", 10);
    }
    public void clickNext(){
        this.waitNClick(Next, "Cant find Next btn", 10);
    }
    public void clickGetStarted(){
        this.waitNClick(Started, "Cant find Next btn", 10);
    }
    public void clickSkip(){
        this.waitNClick(Skip, "Cant find Skip btn", 10);
    }



}

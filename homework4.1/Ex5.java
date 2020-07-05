import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class Ex5 {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "TestDevice");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "main.MainActivity");
        capabilities.setCapability("app", "/Users/maksimkacer/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("Http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void saveTwoArticle() {

        String nameOfFolder = "Learning programming";
        waitNClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "cannot search input", 5);
        waitNSend(By.xpath("//*[contains(@text,'Search…')]"), "Java", "Cannot find search input for send keys", 5);
        waitNClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),"cannot find first arcticle", 15);
        waitForBy(By.id("org.wikipedia:id/view_page_title_text"),"cant find title of arcticle", 15);
        waitNClick(By.xpath("//android.widget.ImageView[@content-desc='More options']"), "cant find btn 'more options'", 8);
        waitNClick(By.xpath("//*[@text='Add to reading list']"), "cant find btn'add to reading list'", 8);
        waitNClick(By.id("org.wikipedia:id/onboarding_button"), "cant find btn 'Got it", 5);
        waitForElemNClear(By.id("org.wikipedia:id/text_input"), "cant find text input to clear", 5);
        waitNSend(By.id("org.wikipedia:id/text_input"),nameOfFolder, "cant find folder name input", 5);
        waitNClick(By.id("android:id/button1"), "cant find OK btn", 5);
        waitNClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), "cant close of artcicle", 5);
        waitNClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "cannot search input", 5);
        waitNSend(By.xpath("//*[contains(@text,'Search…')]"), "Java", "Cannot find search input for send keys", 5);
        waitNClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Island of Indonesia']"),"cannot find first arcticle", 15);
        waitForBy(By.id("org.wikipedia:id/view_page_title_text"),"cant find title of arcticle", 15);
        waitNClick(By.xpath("//android.widget.ImageView[@content-desc='More options']"), "cant find btn 'more options'", 8);
        waitNClick(By.xpath("//*[@text='Add to reading list']"), "cant find btn'add to reading list'", 8);
        waitNClick(By.id("org.wikipedia:id/item_container"), "cant find my list in article tab", 5);
        waitNClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"), "cant find close of artcicle", 5);
        waitNClick(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"), "cant find my list tab", 5);
        waitNClick(By.id("org.wikipedia:id/item_container"), "cant find my list", 5);
        swipeElementToLeft(By.xpath("//*[@text='object-oriented programming language']"),"cant swipe to delete article");
        ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='island of Indonesia']"));
        waitNClick(By.id("org.wikipedia:id/page_list_item_container"), "cant find my list", 5);
        String title = waitNGetAttribute(By.id("org.wikipedia:id/view_page_title_text"), "text", "not title text", 5);
        Assert.assertEquals("we see unexpected title","Java",title);

    }

    private WebElement waitForBy(By by, String errorMessage, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));


    }

    private WebElement waitNClick(By by, String errorMessage, long timeout) {

        WebElement element = waitForBy(by, errorMessage, timeout);
        element.click();
        return element;

    }

    private WebElement waitNSend(By by, String value, String errorMessage, long timeout) {

        WebElement element = waitForBy(by, errorMessage, timeout);
        element.sendKeys(value);
        return element;

    }

    private WebElement waitForElemNClear(By by, String errorMessage, long timeout) {

        WebElement element = waitForBy(by, errorMessage, timeout);
        element.clear();
        return element;


    }

    protected void swipeElementToLeft(By by, String error){
        WebElement element = waitForBy(by, error, 10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
        TouchAction action = new TouchAction(driver);
        action.press(right_x, middle_y).waitAction(300).moveTo(left_x, middle_y).release().perform();

    }

    private String waitNGetAttribute (By by, String attribute, String error, long timeout){
        WebElement element = waitForBy(by,error, timeout);
        return  element.getAttribute(attribute);

    }

    private int getAmount(By by){
        List elements = driver.findElements(by);
        return elements.size();
    }

}

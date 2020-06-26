import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Ex3 {
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
    public void cancelSearchTest() {

       waitNClick(By.id("org.wikipedia:id/search_container"),"cannot find search field", 15);
        waitNSend(By.xpath("//*[contains(@text,'Search…')]"), "Java", "Cannot send keys to search field", 5);
        waitForBy(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),"cannot find 'Object-oriented programming language'", 15);
        waitForBy(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Island of Indonesia']"),"cannot find 'Island of Indonesia'", 15);
        waitNClick(By.id("org.wikipedia:id/search_close_btn"), "cannot find X", 5);
        waitForElemNot(By.id("[@resource-id='org.wikipedia:id/page_list_item_container']"), "search results tab are still here", 5);



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

    private boolean waitForElemNot(By by, String errorMessage, long timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }





}

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import javafx.concurrent.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.utilities.Assert;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Ex4 {
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
    public void findAllJava(){

        waitNClick(By.id("org.wikipedia:id/search_container"),"cannot find search field", 15);
        waitNSend(By.xpath("//*[contains(@text,'Search…')]"), "Java", "Cannot send keys to search field", 5);
        findAll(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"), "Java", "Search results not contains 'Java'", 15);

    }

    private void findAll(By by, String expectedWord, String errorMessage, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");

        ArrayList<WebElement> ListOfAllSearch = new ArrayList<WebElement>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));

        for (int i = 0; i < ListOfAllSearch.size(); i++) {
            Assert.that((ListOfAllSearch.get(i).getAttribute("text")).contains(expectedWord), "Search results not contains expected word");
        }


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




}

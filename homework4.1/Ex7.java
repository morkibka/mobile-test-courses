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

public class Ex6 {
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
        checkOrientation();
        driver.quit();

    }





    @Test
    public void assertTitle() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        waitNClick(By.xpath("//*[contains(@text,'failTest')]"), "we successfully failed test", 5);

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


    private void checkOrientation (){
        if (driver.getOrientation().toString() == "LANDSCAPE") {
            driver.rotate(ScreenOrientation.PORTRAIT);

        }
    }

}

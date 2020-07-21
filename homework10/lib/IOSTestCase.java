package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class IOSTestCase extends TestCase {
    protected  AppiumDriver driver;
    private static String appiumUrl = "Http://127.0.0.1:4723/wd/hub";
@Override
    protected void setUp() throws Exception {

    super.setUp();
    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("platformVersion", "13.6");
        capabilities.setCapability("app", "/Users/maksimkacer/Desktop/JavaAppiumAutomation/apks/wikipedia.app");

        driver = new IOSDriver(new URL(appiumUrl), capabilities);

    this.rotateScreenPortrait();

    }
    @Override

    protected void tearDown() throws Exception{
        driver.quit();
        super.tearDown();
    }
    protected void rotateScreenPortrait(){
    driver.rotate(ScreenOrientation.PORTRAIT);
    }
    protected void rotateScreenLand(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    protected void back(int sec){
        driver.runAppInBackground(sec);

    }
}

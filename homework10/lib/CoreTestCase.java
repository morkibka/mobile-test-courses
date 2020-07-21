package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
    private static final String PlatformIOS = "ios",
    PlatformAndr = "android";
    protected  AppiumDriver driver;
    private static String appiumUrl = "Http://127.0.0.1:4723/wd/hub";
@Override
    protected void setUp() throws Exception {

    super.setUp();
    driver = this.getDriver();
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
   private AppiumDriver getDriver() throws Exception{
       String platform = System.getenv("PLATFORM");
       DesiredCapabilities capabilities = this.getCapabilitiesByPlatform();
       if(platform.equals(PlatformAndr)){

           driver = new AndroidDriver(new URL(appiumUrl), capabilities);


       } else if(platform.equals(PlatformIOS)) {

           driver = new IOSDriver(new URL(appiumUrl), capabilities);

       } else {
           throw new Exception("Cannot run driver");
       }
       return driver;


   }
    private DesiredCapabilities getCapabilitiesByPlatform() throws Exception{
    String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(platform.equals(PlatformAndr)){

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "TestDevice");
            capabilities.setCapability("platformVersion", "8.0.0");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", "main.MainActivity");
            capabilities.setCapability("app", "/Users/maksimkacer/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        } else if(platform.equals(PlatformIOS)) {

            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone 8");
            capabilities.setCapability("platformVersion", "13.6");
            capabilities.setCapability("app", "/Users/maksimkacer/Desktop/wikipedia.app");
        } else {
            throw new Exception("Cannot run platform");
        }
return capabilities;
    }
}

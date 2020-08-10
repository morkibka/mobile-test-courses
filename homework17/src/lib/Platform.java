package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {
    private static final String PlatformIOS = "ios",
            PlatformAndr = "android",
            appiumUrl = "Http://127.0.0.1:4723/wd/hub";
    private static Platform instance;
    private Platform(){ }
    public static Platform getInstance(){
        if (instance == null){
            instance = new Platform();
        }
        return instance;
    }
    public AppiumDriver getDriver() throws Exception{
        URL URL = new URL(appiumUrl);
        if(this.isAndroid()){
            return new AndroidDriver(URL, this.getAndroidCap());
        } else if(this.osIOS()){
            return new IOSDriver(URL, this.getIOSCap());
        } else {
            throw new Exception("Cannot detect platform" + this.getPlatformEnv());
        }
    }
    public boolean isAndroid(){
        return isPlatform(PlatformAndr);
    }
    public boolean osIOS(){
        return isPlatform(PlatformIOS);
    }

    private DesiredCapabilities getAndroidCap() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "TestDevice");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "main.MainActivity");
        capabilities.setCapability("app", "/Users/maksimkacer/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");
        return capabilities;
    }
    private DesiredCapabilities getIOSCap() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("platformVersion", "13.6");
        capabilities.setCapability("app", "/Users/maksimkacer/Desktop/wikipedia.app");
        return capabilities;
    }
    private boolean isPlatform(String my_platform){
        String platform = this.getPlatformEnv();
        return my_platform.equals(platform);


    }
    private String getPlatformEnv(){
        return System.getenv("PLATFORM");
    }

    }

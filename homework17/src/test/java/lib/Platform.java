package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String PlatformIOS = "ios",
            PlatformAndr = "android",
    PlatformWeb = "mobile_web",
            appiumUrl = "Http://127.0.0.1:4723/wd/hub";
    private static Platform instance;
    private Platform(){ }
    public static Platform getInstance(){
        if (instance == null){
            instance = new Platform();
        }
        return instance;
    }
    public RemoteWebDriver  getDriver() throws Exception{
        URL URL = new URL(appiumUrl);
        if(this.isAndroid()){
            return new AndroidDriver(URL, this.getAndroidCap());
        } else if(this.osIOS()){
            return new IOSDriver(URL, this.getIOSCap());
        } else if(this.isMW()) {
            return new ChromeDriver(this.getMWChromeOpt());
        }else {
            throw new Exception("Cannot detect platform" + this.getPlatformEnv());
        }
    }
    public boolean isAndroid(){
        return isPlatform(PlatformAndr);
    }
    public boolean osIOS(){
        return isPlatform(PlatformIOS);
    }
    public boolean isMW(){ return isPlatform(PlatformWeb); }


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
    public String getPlatformEnv(){
        return System.getenv("PLATFORM");
    }
    private ChromeOptions getMWChromeOpt(){
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);
        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        deviceMetrics.put("deviceMetrics", deviceMetrics);
        deviceMetrics.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("windows-size=340,640");

        return chromeOptions;

    }

    }

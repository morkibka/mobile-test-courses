package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class CoreTestCase extends TestCase {

    protected RemoteWebDriver driver;
@Override
    protected void setUp() throws Exception {

    super.setUp();
  driver = Platform.getInstance().getDriver();
    this.rotateScreenPortrait();
    this.skipOnboarding();
    this.openWikiWeb();
}
    @Override

    protected void tearDown() throws Exception{
        driver.quit();
        super.tearDown();
    }
    protected void rotateScreenPortrait(){

    if (driver instanceof AppiumDriver) {
        AppiumDriver driver = (AppiumDriver) this.driver;
        driver.rotate(ScreenOrientation.PORTRAIT);

    } else {
        System.out.println("method rotate screen dont work" + Platform.getInstance());
    }
    }
    protected void rotateScreenLand() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("method rotate screen dont work" + Platform.getInstance());
        }

    }
    protected void back ( int sec){
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(Duration.ofSeconds(sec));
        } else {
            System.out.println("method back" + Platform.getInstance().getPlatformEnv());
        }
    }
    private void skipOnboarding () {
        if (Platform.getInstance().osIOS()) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }
protected void openWikiWeb(){
    if (Platform.getInstance().isMW()){
        driver.get("https://en.m.wikipedia.org");
    } else {
        System.out.println("Method openWikiWeb do nothing" + Platform.getInstance().getPlatformEnv());
    }
}
}

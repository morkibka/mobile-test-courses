package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;

public class CoreTestCase extends TestCase {

    protected  AppiumDriver driver;
@Override
    protected void setUp() throws Exception {

    super.setUp();
  driver = Platform.getInstance().getDriver();
    this.rotateScreenPortrait();
    this.skipOnboarding();
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
    private void skipOnboarding(){
    if(Platform.getInstance().osIOS()){
        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.clickSkip();
    }
    }
}

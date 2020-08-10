package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lib.CoreTestCase;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lib.Platform;


import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainClassObject extends CoreTestCase {
    protected RemoteWebDriver driver;

    public MainClassObject(RemoteWebDriver driver){
        this.driver = driver;

    }


    public WebElement waitForBy(String locator, String errorMessage, long timeout) {
        By by = this.getLocatorString(locator);

        WebDriverWait wait = new WebDriverWait(driver, timeout);

        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));


    }
    public WebElement waitForBy(String locator, String errorMessage) {

        return waitForBy(locator, errorMessage, 15);


    }

    public WebElement waitNClick(String locator, String errorMessage, long timeout) {

        WebElement element = waitForBy(locator, errorMessage, timeout);
        element.click();
        return element;

    }

    public WebElement waitNSend(String locator, String value, String errorMessage, long timeout) {

        WebElement element = waitForBy(locator, errorMessage, timeout);
        element.sendKeys(value);
        return element;

    }

    public boolean waitForElemNot(String locator, String errorMessage, long timeout) {
        By by = this.getLocatorString(locator);

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }
    public WebElement waitForElemNClear(String locator, String errorMessage, long timeout) {

        WebElement element = waitForBy(locator, errorMessage, timeout);
        element.clear();
        return element;


    }

    public boolean isElementPresent(String locator){
        int element_y = this.waitForBy(locator,  "cant find el y", 1).getLocation().getY();
        if (Platform.getInstance().isMW()){
            JavascriptExecutor JSExutor = (JavascriptExecutor)driver;
            Object js_res = JSExutor.executeScript("return window.pageYOffset");
            element_y -= Integer.parseInt(js_res.toString());
        }
        int screen_y = driver.manage().window().getSize().getHeight();
        return element_y < screen_y;
    }
    public void  swipeUp(int time) {
if(driver instanceof AppiumDriver){TouchAction action = new TouchAction((AppiumDriver)driver);
    Dimension size = driver.manage().window().getSize();
    int x = size.width / 2;
    int startY = (int) (size.height * 0.8);
    int finY = (int) (size.height * 0.2);


    action.press(PointOption.point(x,startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(time))).moveTo(PointOption.point(x,finY)).release().perform();


} else {
        System.out.println("method swipup dont work" + Platform.getInstance());} }
    public void swipeTillAppear(String locator, String error_message, int max_swipes){
        int alrSwipes = 0;
while(!this.isElementPresent(locator)){
    if(alrSwipes > max_swipes){
        Assert.assertTrue(error_message, this.isElementPresent(locator));
    }
    swipeUpQuick();
    ++alrSwipes;
}
    }
    public void  swipeUpQuick() {
        swipeUp(200);
    }
    public void  swipeUpToElement(String locator, int maxSwipes) {
        By by = this.getLocatorString(locator);
        int alrSwipes = 0;


        while (        driver.findElements(by).size() == 0) {
            if (alrSwipes > maxSwipes) {
                waitForBy(locator, "cant find locator for swipe", 0);
                return;

            }
            swipeUpQuick();
            ++alrSwipes;

        }
    }
    public void swipeElementToLeft(String locator, String error){

    if (driver instanceof AppiumDriver){
        WebElement element = waitForBy(locator, error, 10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
        TouchAction action = new TouchAction((AppiumDriver)driver);
        action.press(PointOption.point(right_x, middle_y));
        action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(300)));
        if (Platform.getInstance().isAndroid()){
            action.moveTo(PointOption.point(left_x, middle_y));

        } else {
            int offset_x =(-1 * element.getSize().getWidth());
            action.moveTo(PointOption.point(offset_x, 0));


        }
        action.release();
        action.perform();

    } else {
        System.out.println("Method left not work" + Platform.getInstance());
    }}
    public int getAmount(String locator){
        By by = this.getLocatorString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }
    public void assertElemNot(String locator, String error){
        int amount = getAmount(locator);
        if (amount > 0 ) {
            String default_message = "An element" + locator.toString() + "sup to not pres";
            throw new AssertionError(default_message + "" + error);
        }
    }
    public String waitNGetAttribute (String locator, String attribute, String error, long timeout){
        WebElement element = waitForBy(locator,error, timeout);
        return  element.getAttribute(attribute);

    }

    public void checkOrientation (){
        if ( Platform.getInstance().isAndroid()){
            AppiumDriver driver = (AppiumDriver) this.driver;
            if (driver.getOrientation().toString() == "LANDSCAPE") {
                driver.rotate(ScreenOrientation.PORTRAIT);

            }
        }
    }



    public void assertElementPresent(String locator, String error) {
        int amount = getAmount(locator);
        Assert.assertTrue(error,amount > 0);


    }
    private By getLocatorString(String locator_with_type){
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];
        if(by_type.equals("xpath")){
            return By.xpath(locator);
        } else if(by_type.equals("id")){
            return By.id(locator);
        } else if(by_type.equals("css")) {
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("cant get type of locator " + locator_with_type);
        }
    }
    public void clickElToRightCorn(String locator, String error){
   if (driver instanceof AppiumDriver){
        WebElement element = this.waitForBy(locator,error);
        int right_x = element.getLocation().getX();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
int width = element.getSize().getWidth();
int point_x = (right_x + width) - 3;
int point_y = middle_y;
TouchAction action = new TouchAction((AppiumDriver)driver);
action.tap(PointOption.point(point_x, point_y)).perform();

    } else {
        System.out.println("method dont work" + Platform.getInstance());
    }


     /*
    private WebElement waitForId(String id, String errorMessage, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");
        By by = By.id(id);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));


    }
    private WebElement waitNClickId(String id, String errorMessage, long timeout) {

        WebElement element = waitForId(id, errorMessage, timeout);
        element.click();
        return element;

    }

     */
}
    public void scrollWebUp(){
        if (Platform.getInstance().isMW()){
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            JSExecutor.executeScript("window.scrollBy(0, 250)");
        } else {
            System.out.println("method scrollWebUp not work" + Platform.getInstance().getPlatformEnv());
        }
    }
    public void scrollWebElTillNotVisible(String locator, String error, int max_swipes){
        int already_swiped = 0;
        WebElement element = this.waitForBy(locator, error);
        while (!this.isElementPresent(locator)){
            scrollWebUp();
            ++already_swiped;
            if (already_swiped > max_swipes) {
                Assert.assertTrue(error, element.isDisplayed());
            }

        }
    }
    public boolean isElPres(String locator){
        return getAmount(locator)> 0;
    }
public void tryClickElFewAttemps(String locator,String error, int amount){
        int current_at = 0;
        boolean need_more = true;
        while(need_more){
            try {
                this.waitNClick(locator, error,1);
                need_more = false;
            } catch (Exception e){
                if(current_at>amount){
                    this.waitNClick(locator, error,1);
                }
            }
            ++current_at;
        }

}
}

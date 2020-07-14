package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import lib.CoreTestCase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class MainClassObject extends CoreTestCase {
    protected static AppiumDriver driver;
    public MainClassObject(AppiumDriver driver){
        this.driver = driver;
    }

    public WebElement waitForBy(By by, String errorMessage, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));


    }
    public WebElement waitForBy(By by, String errorMessage) {

        return waitForBy(by, errorMessage, 15);


    }

    public WebElement waitNClick(By by, String errorMessage, long timeout) {

        WebElement element = waitForBy(by, errorMessage, timeout);
        element.click();
        return element;

    }

    public WebElement waitNSend(By by, String value, String errorMessage, long timeout) {

        WebElement element = waitForBy(by, errorMessage, timeout);
        element.sendKeys(value);
        return element;

    }

    public boolean waitForElemNot(By by, String errorMessage, long timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }
    public WebElement waitForElemNClear(By by, String errorMessage, long timeout) {

        WebElement element = waitForBy(by, errorMessage, timeout);
        element.clear();
        return element;


    }
    public void  swipeUp(int time) {

        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int finY = (int) (size.height * 0.2);

        action.press(x, startY).waitAction(time).moveTo(x, finY).release().perform();


    }
    public void  swipeUpQuick() {
        swipeUp(200);
    }
    public void  swipeUpToElement(By by, String error, int maxSwipes) {
        int alrSwipes = 0;


        while (        driver.findElements(by).size() == 0) {
            if (alrSwipes > maxSwipes) {
                waitForBy(by, "loh2", 0);
                return;

            }
            swipeUpQuick();
            ++alrSwipes;

        }
    }
    public void swipeElementToLeft(By by, String error){
        WebElement element = waitForBy(by, error, 10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
        TouchAction action = new TouchAction(driver);
        action.press(right_x, middle_y).waitAction(300).moveTo(left_x, middle_y).release().perform();

    }
    public int getAmount(By by){
        List elements = driver.findElements(by);
        return elements.size();
    }
    public void assertElemNot(By by, String error){
        int amount = getAmount(by);
        if (amount > 0 ) {
            String default_message = "An element" + by.toString() + "sup to not pres";
            throw new AssertionError(default_message + "" + error);
        }
    }
    public String waitNGetAttribute (By by, String attribute, String error, long timeout){
        WebElement element = waitForBy(by,error, timeout);
        return  element.getAttribute(attribute);

    }

    public void checkOrientation (){
        if (driver.getOrientation().toString() == "LANDSCAPE") {
            driver.rotate(ScreenOrientation.PORTRAIT);

        }
    }

    public void assertElementPresent(By by, String error) {
        int amount = getAmount(by);
        Assert.assertTrue(error,amount > 0);


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

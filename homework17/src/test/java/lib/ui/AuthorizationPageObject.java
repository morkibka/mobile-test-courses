package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainClassObject {
    private static final String
    Login_btn = "xpath://body/div/a[text()='Log in']",
    Login_input = "css:input[name='wpName']",
    Pass_input = "css:input[name='wpPassword']",
    Submit_btn = "css:button#wpLoginAttempt";
    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    public void clickAuthBtn(){
        this.waitForBy(Login_btn, "cant find  log btn", 5);
        this.waitNClick(Login_btn, "cant find n click log btn", 5);
    }
    public void enterLogData(String log, String pass){
        this.waitNSend(Login_input, log, "cant find log inp", 5);
        this.waitNSend(Pass_input, pass, "cant find pass inp", 5);
    }
    public void submitForm(){
        this.waitNClick(Submit_btn, "cant find n click submit btn", 5);
    }
}

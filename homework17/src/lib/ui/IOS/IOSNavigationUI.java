package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class IOSNavigationUI extends NavigationUI {
        static {
            MyListLink = "id:Saved";
        }
        public IOSNavigationUI(AppiumDriver driver){
            super(driver);
        }
    }


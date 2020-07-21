package tests.IOS;

import lib.CoreTestCase;
import lib.IOSTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class StartedTest extends CoreTestCase {

    @Test
    public void testPassOnboarding(){
        WelcomePageObject welcome = new WelcomePageObject(driver);
        welcome.waitForLearnMoreLink();
        welcome.clickNext();
        welcome.waitForNewWayToExplore();
        welcome.clickNext();
        welcome.waitForAddOrEdit();
        welcome.clickNext();
        welcome.waitForDataCollectorLink();
        welcome.clickGetStarted();

    }

}

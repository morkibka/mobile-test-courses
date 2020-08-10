package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class StartedTest extends CoreTestCase {

    @Test
    public void testPassOnboarding(){
        if ((Platform.getInstance().isAndroid()) || Platform.getInstance().isMW()) {
            return;
        }
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

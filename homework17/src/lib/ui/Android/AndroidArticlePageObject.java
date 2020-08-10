package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePagoObject;

public class AndroidArticlePageObject extends ArticlePagoObject {
     static {
         Title = "id:org.wikipedia:id/view_page_title_text";
         Footer = "xpath://*[@text='View page in browser1']";
         Options = "xpath://android.widget.ImageView[@content-desc='More options']";
         AddToRead = "xpath://*[@text='Add to reading list']";
         IdOverlay = "id:org.wikipedia:id/onboarding_button";
         TextInput = "id:org.wikipedia:id/text_input";
         OKButton = "xpath://*[@text='OK']";
         CloseArtBtn = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
         MyListContainer = "id:org.wikipedia:id/item_container";
         MylistTab = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
     }
     public AndroidArticlePageObject(AppiumDriver driver){
         super(driver);
     }
}

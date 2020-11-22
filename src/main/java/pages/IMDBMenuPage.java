package pages;

import common.CommonElements;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IMDBMenuPage extends CommonElements {

    private Logger log = LoggerFactory.getLogger(IMDBMenuPage.class);

    @FindBy(xpath = "//span[text()='Top Rated Shows']")
    private WebElementFacade linkTopRelatedShows;

    @FindBy(xpath = "//h1[text()='Top Rated TV Shows']")
    protected WebElementFacade headerTopRatedShows;

    public void openTopRatedShows(){
        log.info("Navigate to Top related shows");
        linkTopRelatedShows.waitUntilVisible();
        hoverAndClickElemnt(linkTopRelatedShows,headerTopRatedShows);
    }

    public void navigateToSignInPage(){
        log.info("Navigate to sign in page");
        linkSignIn.click();
    }
}

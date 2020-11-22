package pages;

import common.CommonElements;
import common.ElementHandler;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IMDBHomePage extends CommonElements {

private Logger log = LoggerFactory.getLogger(IMDBHomePage.class);

  @FindBy(xpath = "a[href^='/title']")
  private WebElementFacade temporarySearchResult;

    public void navigateToSideMenu(){
        log.info("Navigate to side Menu");
            clickOnOneElementAndAssertNewElement(buttonSideMenu, buttonCloseMenu);

    }

    public void searchVideo(String videoName){
        searchBar.type(videoName);
        waitForMax10Seconds(find(By.xpath("//div[text()='"+videoName+"']")));
        WebElement element = getDriver().findElement(By.xpath("//div[text()='"+videoName+"']"));
        if(element.isDisplayed()){
            clickOn(element);
            WebElement elementDisplayed = getDriver().findElement(By.xpath("//h1[contains(text(),'"+videoName+"')]"));
            Assert.assertTrue(elementDisplayed.isDisplayed());
        }
    }

    public void navigateToSignInPage(){
        linkSignIn.click();
    }



}

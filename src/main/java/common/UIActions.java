package common;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Set;

public class UIActions extends PageObject {


    Logger log = LoggerFactory.getLogger(UIActions.class);
    public void switchToTab(int tabNumber){
        if(getAllWindows().size()>1){
            getDriver().switchTo().window(getAllWindows().get(tabNumber));
        }
    }

    public void switchToPreviousTab(){
        getDriver().switchTo().window(getAllWindows().get(0));
    }

    public ArrayList<String> getAllWindows(){
        Set<String> allWindows = getDriver().getWindowHandles();
        ArrayList<String> list = new ArrayList<>(allWindows);
        return  list;
    }

    public Actions getActions(){
        log.info("GET Actions from Browser");
        org.openqa.selenium.interactions.Actions actions = new Actions(getDriver());
        return actions;
    }

    public void scrollToElement(WebElement element){
        log.info("Scroll to element using javascript executor");
        ((JavascriptExecutor)getDriver())
                .executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToPageEnd(){

        ((JavascriptExecutor)getDriver())
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public void waitForPageLoad(){
        new WebDriverWait(getDriver(), 15).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void openURLInNewTab(String URL){
        log.info("Open URL in new tab");
        ((JavascriptExecutor)getDriver()).executeScript("window.open()");
        waitForPageLoad();
        int noOfTabs = getDriver().getWindowHandles().size();
        switchToTab(noOfTabs-1);
        getDriver().get(URL);
        waitForPageLoad();

    }

    public void waitForMax10Seconds(WebElementFacade facade){
        facade.withTimeoutOf(10, ChronoUnit.SECONDS).waitUntilVisible();
    }

    public String generateRandomString(int lengthOfString) {
        String randomString = RandomStringUtils.randomAlphanumeric(lengthOfString);
        log.info("Randomly string generated of length " + lengthOfString + "and the string generated is " + randomString);
        return randomString;

    }

}

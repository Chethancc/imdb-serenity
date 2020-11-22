package common;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ElementHandler extends UIActions{


    Select select;
    private Logger log = LoggerFactory.getLogger(ElementHandler.class);


    public void doubleClickElement(WebElement element){

        log.info("Moving to element and clicking");
        getActions().moveToElement(element).doubleClick();
    }

    public void hoverOverElement(WebElement element){

        getActions().moveToElement(element).click().build().perform();

    }

    public void hoverAndEnterData(WebElement element,String text){
        getActions().moveToElement(element).click().sendKeys(text).build().perform();
    }

    public void waitForElement(WebElement element,int timeOut){
        log.info("Waiting for element " + timeOut);
        WebDriverWait wait;
        WebDriver driver = getDriver();
        wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void explicitlyWaitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public void selectElementFromVisibleText(WebElement element,String text){
        select = new Select(element);
        select.selectByVisibleText(text);

    }

    public void selectElementFromIndex(WebElement element,int index){
        select = new Select(element);
        select.selectByIndex(index);
    }



    public void clickOnOneElementAndAssertNewElement(WebElement elementToClick,WebElement elementToAppear){
               if(elementToClick.isDisplayed()){
                   clickOn(elementToClick);
                   Assert.assertTrue("Expected Element not dispalyed",elementToAppear.isDisplayed());
               }else{
                    log.warn("Element is not dispalyed");
               }
    }

    public void verifyServiceTitle(String title){
        String expectedTitle = getDriver().getTitle();
        Assert.assertEquals("Service title does not match please check the page",expectedTitle,title);
    }

    public void hoverAndClickElemnt(WebElement elementToClick,WebElement elementToAppear){
        log.info("Hover and click on element");
        if(elementToClick.isDisplayed()){
            getActions().moveToElement(elementToClick).click().build().perform();
            Assert.assertTrue("Expected Element not dispalyed",elementToAppear.isDisplayed());
        }
    }
}

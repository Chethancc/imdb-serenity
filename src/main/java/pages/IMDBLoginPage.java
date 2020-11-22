package pages;

import common.CommonElements;
import common.ElementHandler;
import fileReaders.CsvReader;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConstantUtils;

import java.util.HashMap;
import java.util.Map;

public class IMDBLoginPage extends CommonElements {
    private Logger log = LoggerFactory.getLogger(IMDBLoginPage.class);

    @FindBy(css="#ap_email")
    private WebElementFacade inputEmail;

    @FindBy(css="#ap_password")
    private WebElementFacade inputPassword;

    @FindBy(css="#signInSubmit")
    private WebElementFacade buttonSubmit;

    @FindBy(xpath = "(//div[@class='ipc-button__text'])[5]/span")
    private WebElementFacade elementUserName;

    String expectedUserName;
    @Step
    public void loginToIMBD(String loginProfile){
        Map<String,String> loginTestData =  new HashMap<>();
        loginTestData = CsvReader.getData(ConstantUtils.signUpfilePath,loginProfile);
        inputEmail.type(loginTestData.get("Email"));
        inputPassword.type(loginTestData.get("Password"));
        buttonSubmit.click();
        expectedUserName = loginTestData.get("Name");

    }

    @Step
    public void verifyUserLoggedIn(){
        Assert.assertEquals(expectedUserName,elementUserName.getText());
    }
}

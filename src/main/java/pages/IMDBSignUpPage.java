package pages;

import au.com.bytecode.opencsv.CSVReader;
import common.CommonElements;
import common.ElementHandler;
import fileReaders.CsvReader;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConstantUtils;

import java.util.HashMap;
import java.util.Map;

public class IMDBSignUpPage extends CommonElements {

    private Logger log = LoggerFactory.getLogger(IMDBSignUpPage.class);

    @FindBy(css = "a.list-group-item.create-account ")
    private WebElementFacade buttonCreateNewAccount;

    @FindBy(css = "#ap_customer_name")
    private WebElementFacade inputFirstName;

    @FindBy(css = "#ap_email")
    private WebElementFacade inputEmail;

    @FindBy(css = "#ap_password")
    private WebElementFacade inputPassword;

    @FindBy(css = "#ap_password_check")
    private WebElementFacade inputConfirmPassword;

    @FindBy(css = "#continue")
    private WebElementFacade buttonCreateAccount;

    @FindBy(xpath = "//span[text()='Sign in with IMDb']")
    private WebElementFacade buttonSignInWithImdb;


    @Step
    public void navigateToCreateNewAccountPage(){
        buttonCreateNewAccount.click();
    }


    @Step
    public void enterSignUpInfo(String signUpProfile){
        Map<String,String> signUpTestData =  new HashMap<>();
        signUpTestData = CsvReader.getData(ConstantUtils.signUpfilePath,signUpProfile);
        inputFirstName.type(signUpTestData.get("Name"));
        inputEmail.type("abcd"+generateRandomString(4)+"@gmail.com");
        inputPassword.type(signUpTestData.get("Password"));
        inputConfirmPassword.type(signUpTestData.get("ConfirmPassword"));
        buttonCreateAccount.click();
    }

    @Step
    public void navigateToSignInWithImdb(){
        buttonSignInWithImdb.click();
    }
}

package stepDefinations;

import fileReaders.PropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.DefaultUrl;

import pages.IMDBHomePage;
import utils.ConstantUtils;

@DefaultUrl("https://www.imdb.com/")
public class BaseSteps extends IMDBHomePage {

    @Before()
    public void initialStepUp(){
        OnStage.setTheStage(new Cast());
        PropertiesReader reader = new PropertiesReader();
        getDriver().get(System.getProperty("baseUrl"));
        System.out.println("entered before method");
    }

    @Given("User is on IMDB webpage")
    public void user_is_on_imdb_webpage() {
        verifyServiceTitle(ConstantUtils.serviceTitle);
    }

    @When("User navigates to SideMenu")
    public void user_navigates_to_side_menu() {
        navigateToSideMenu();
    }

    @When("User searches for {string}")
    public void user_searches_for(String string) {
            searchVideo(string);
    }

    @Given("user Clicks on Signin Link")
    public void user_clicks_on_signin_link() {
      navigateToSignInPage();
    }

//    @After
//    public void tearDown(){
//        getDriver().quit();
//    }



}

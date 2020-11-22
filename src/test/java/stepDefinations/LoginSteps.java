package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.IMDBLoginPage;

public class LoginSteps extends IMDBLoginPage {


    @Given("enters username and password as per {string}")
    public void enters_username_and_password_as_per(String string) {
        loginToIMBD(string);
    }

    @Then("user must be succesfully logged in")
    public void user_must_be_succesfully_logged_in() {
        verifyUserLoggedIn();
    }

}

package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.IMDBSignUpPage;

public class SignUpSteps extends IMDBSignUpPage {


    @Given("navigate to Create New Account Page")
    public void navigate_to_create_new_account_page() {
        navigateToCreateNewAccountPage();
    }

    @Given("enters the user accountDetails with {string}")
    public void enters_the_user_account_details_with(String string) {
        enterSignUpInfo(string);
    }

    @Then("Account must be created Successfully")
    public void account_must_be_created_successfully() {
    }

    @Given("clicks Sign in with IMDb")
    public void clicks_sign_in_with_im_db() {
        navigateToSignInWithImdb();
    }


}

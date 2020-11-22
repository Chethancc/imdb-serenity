package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.IMDBMenuPage;

public class MenuPageSteps extends IMDBMenuPage {

    @When("Selects {string}")
    public void selects(String string) {
        openTopRatedShows();
    }

    @Then("assert that top rated show details are present")
    public void assert_that_top_rated_show_details_are_present() {
        Assert.assertTrue("Top Related shows link is missing",headerTopRatedShows.isDisplayed());
    }

}

package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.IMDBVideoDetailPage;

public class VideoDetailSteps extends IMDBVideoDetailPage {

    @When("clicks the lastest episode link")
    public void clicks_the_lastest_episode_link() {
        openTopRatedEpisode();
    }

    @Then("verify title rating and number of reveiws")
    public void verify_title_rating_and_number_of_reveiws() {
        verifyContents();
    }
}

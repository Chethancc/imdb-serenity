package pages;

import common.CommonElements;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class IMDBVideoDetailPage extends CommonElements {

    Logger log = LoggerFactory.getLogger(IMDBVideoDetailPage.class);

    @FindBy(xpath = "//div[@class='episode-container']")
    private List<WebElementFacade> topRatedEpisodes;

    @FindBy(xpath ="//div[@class='title_wrapper']/h1")
    private WebElementFacade episodeTitle;

    @FindBy(css = "span[itemprop='ratingValue']")
    private WebElementFacade episodeRating;

    @FindBy(css = "span[itemprop='ratingCount']")
    private WebElementFacade episodeRatingCount;

    String topRatedEpisodeName;
    String topRatedepisodeRating;
    public void openTopRatedEpisode(){
        log.info("Opening top rated episode");
        explicitlyWaitFor(5);
        topRatedEpisodeName = topRatedEpisodes.get(0).findElement(By.cssSelector("a[href^='/title']")).getText();
        topRatedepisodeRating = topRatedEpisodes.get(0).findElement(By.cssSelector("span.ipl-rating-star__rating")).getText().trim();
        waitForMax10Seconds(topRatedEpisodes.get(0).find(By.cssSelector("a[href^='/title']")));
        clickOnOneElementAndAssertNewElement(topRatedEpisodes.get(0).findElement(By.cssSelector("a[href^='/title']")),episodeTitle);


    }

    public void verifyContents(){
        String openedEpisodeName = episodeTitle.getText();
        String openedEpisodeRating = episodeRating.getText().trim();
        log.info("Episode Rating Count is " + episodeRatingCount.getText());
        Assert.assertEquals("Mismatch between displayed and opened episode",topRatedEpisodeName.trim(),openedEpisodeName.trim());
        Assert.assertEquals("Mismatch is rating", topRatedepisodeRating,openedEpisodeRating);
    }

}
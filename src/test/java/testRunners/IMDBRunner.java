package testRunners;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/" , glue = "stepDefinations",dryRun = false)
public class IMDBRunner {
}

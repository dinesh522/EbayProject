package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

 @RunWith(Cucumber.class)
 @CucumberOptions(
		features= "C:\\Users\\acer\\eclipse-workspace\\EbayBDDFrameWork\\src\\main\\java\\Features\\AddToCart.feature",
		glue= {"stepDefinition"},
		monochrome=true,
				strict=true,
				dryRun=false
		)

public class TestRunner {

}

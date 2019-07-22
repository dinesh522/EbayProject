package Runner;

import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\acer\\eclipse-workspace\\EbayBDDFrameWork\\src\\main\\java\\Features\\AddToCart.feature", glue = {
		"stepDefinition" }, plugin = { "pretty", "html:target/cucumber-html-report",
				"com.cucumber.listener.ExtentCucumberFormatter:C:\\Users\\acer\\git\\EbayProject\\EbayBDDFrameWork\\Report\\report.html" }, monochrome = true, strict = true, dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void ReportSetup() {
		Reporter.loadXMLConfig(new File(
				"src\\main\\Resources\\extent-report.xml"));
	}

}
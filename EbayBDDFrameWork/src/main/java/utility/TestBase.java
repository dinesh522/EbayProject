package utility;
import java.io.File;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;

//Method to initialize the browser
public static void initialization(){
	 log = Logger.getLogger("TestCase");
	log.info("Logger Initiated....");
	System.setProperty("webdriver.chrome.driver", Constant.ChromeDriver);
    driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(Constant.BrowserURL);
	log.info("Launching browser");
}

//Method to take screenshot
public void takeScreenshot() throws Exception {
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile, new File(Constant.ScreenshotURL));
}

public static void closeBrowser()
{
	driver.quit();
}


}
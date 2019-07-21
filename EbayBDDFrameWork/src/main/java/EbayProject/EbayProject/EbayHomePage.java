package EbayProject.EbayProject;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.TestBase;

public class EbayHomePage extends TestBase
{
   
	
	
	public EbayHomePage() {
		
		PageFactory.initElements(driver,this);
		

	}
	
	@FindBy(xpath="//*[@id='gh-ac']")
	WebElement searchtext;
	
	@FindBy(xpath="//*[@id='gh-btn']")
	WebElement searchbutton;
	
	
	@FindBy(xpath="(//*[@class='s-item__wrapper clearfix']/div[2]/a)[1]")
	WebElement clickitem;
	
	
	
	public WebElement searchText()
	{
		return searchtext;
	}
	
	public WebElement clicksearch()
	{
		return searchbutton;
	}
	
	
	
	
	//method to search an item
	public  void searchItem(String Book) throws Exception
	{
		
		searchtext.sendKeys(Book);
		log.info("Searching for available books");
		searchbutton.click();
		log.info("Clicking on Search button");
		
	}	

	
	
	
	//Method to click the first available item from the list
	public EbayAddToCartPage selectItem() throws Exception
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Clicking on the first available item");
		clickitem.click();
		}
		catch (Exception e)
		{
			Assert.fail("Element not found to click on the Element");
			//takeScreenshot();
		}
		return new EbayAddToCartPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

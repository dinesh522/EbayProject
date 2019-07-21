package EbayProject.Pages;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestBase;





public class EbayAddToCartPage extends TestBase

{
	
	
	public EbayAddToCartPage() 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//*[@class='c-std vi-ds3cont-box-marpad ']/div[1]//following::span[1]/a[1])[1]")
	WebElement addtocart;

	@FindBy(xpath="//*[@class='app-atc-layer__actionRow']/a[2]")
	WebElement gotocart;
	
	@FindBy(xpath="//*[@class='it-ttl']")
	WebElement getItemName;
	
	String itemName;
	
	public WebElement addToCart()
	{
		return addtocart;
	}
	
	public WebElement goToCart()
	{
		return gotocart;
	}
	

	public void addItemToCart()
	{
			addtocart.click();
	}
	
	public WebElement getItemName()
	
	{
		return getItemName;
	}
		
		
		//Method to click the first available item from the list
		public EbayShoppingCart navigateToShoppingCart() throws Exception
		{     
		
		  try {;
		  new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(gotocart));
		  gotocart.click(); log.info("Click on Go to Cart"); } 
		  catch(Exception e)
		  {
			  TestBase.takeScreenshot();
		  Assert.fail("Element not found to click on the Element"); 
		  
		  }
		 
			
			return new EbayShoppingCart();
			
		}
		//Method to get the name of the item added to cart
		public String getitemName() throws Exception
		{ new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(getItemName));
			itemName= getItemName.getText();
		
		 try
		 { itemName= getItemName.getText(); 
		 log.info("item added to cart is"
		  +itemName); 
		 }
		 catch(Exception e)
		 {
			 TestBase.takeScreenshot();
		  Assert.fail("Element not found to click on the Element"); //takeScreenshot();
		  }
		 
			return itemName;
		}
		
		
}

package EbayProject.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestBase;

public class EbayHomePage extends TestBase {

	public EbayHomePage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id='gh-ac']")
	WebElement searchtext;

	@FindBy(xpath = "//*[@id='gh-btn']")
	WebElement searchbutton;

	@FindBy(xpath = "(//*[@class='s-item__wrapper clearfix']/div[2]/a)[1]")
	WebElement clickitem;

	public WebElement searchText() {
		return searchtext;
	}

	public WebElement clicksearch() {
		return searchbutton;
	}

	// method to search an item
	public void searchItem(String Book) throws Exception {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(searchtext));
			searchtext.sendKeys(Book);
			log.info("Searching for available books");
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(searchbutton));
			searchbutton.click();
			log.info("Clicking on Search button");
		}

		catch (Exception e) {
			TestBase.takeScreenshot();
			Assert.fail("Element not found to click on the Element");

		}
	}

	// Method to click the first available item from the list
	public EbayAddToCartPage selectItem() throws Exception {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(clickitem));
			log.info("Clicking on the first available item");
			clickitem.click();
		} catch (Exception e) {
			TestBase.takeScreenshot();
			Assert.fail("Element not found to click on the Element");

		}
		return new EbayAddToCartPage();
	}

}

package EbayProject.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestBase;

public class EbayShoppingCart extends TestBase {

	public EbayShoppingCart() {

		PageFactory.initElements(driver, this);
	}

	String itemName;
	@FindBy(xpath = "(//*[@type='button'])[2]")
	WebElement removebutton;

	@FindBy(xpath = "//*[@class='listsummary-content-itemdetails']/h3/span/a/span")
	WebElement getItemName;

	@FindBy(xpath = "//*[@id='gh-cart']/a")
	WebElement clickcart;

	@FindBy(xpath = "//*[@class='empty-cart']/div")
	WebElement emptycarttext;

	public WebElement removeButton() {
		return removebutton;
	}

	public WebElement getItemName()

	{
		return getItemName;
	}

	public WebElement clickCart()

	{
		return clickcart;
	}

	public WebElement emptyCartText()

	{
		return emptycarttext;
	}

	// *method to remove the item from the cart
	public void removerItemFromCart() throws Exception {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(removebutton));
			log.info("Clicking Remove button in the Shopping cart screen");
			removebutton.click();
		} catch (Exception e) {
			TestBase.takeScreenshot();
			Assert.fail("Element not found to click on the Element");

		}
	}

	// method to get the name of the item added in the cart
	public String getitemNameCart() throws Exception {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(getItemName));
		String itemName = getItemName.getText();

		try {
			log.info("item added to cart is" + itemName);
		}

		catch (Exception e) {
			TestBase.takeScreenshot();
			Assert.fail("Element not found to click on the Element"); // takeScreenshot();
		}

		return itemName;
	}

	// method to verify the item selected and available in the cart
	public void verifyItemAddedTOCart(String itemselected, String itemInCart) {
		if (itemselected.equalsIgnoreCase(itemInCart)) {

			System.out.println("Item " + itemselected + " is available in the cart");
		} else {
			System.out.println("Item " + itemselected + " is not available in the cart");
		}
	}

	// Method to Click on Cart icon
	public void cartlist() throws Exception {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(clickcart));
			log.info("Click on Cart button");
			clickcart.click();
		} catch (Exception e) {
			TestBase.takeScreenshot();
			Assert.fail("Element not found to click on the Element");

		}
	}

	// method to verify the whether any item is available in the cart
	public void verifyItemInCart() {
		String carttext = emptycarttext.getText();

		if (carttext.equalsIgnoreCase("You don't have any items in your cart.")) {
			System.out.println("No item available in the cart");
		} else {
			System.out.println("An item is available in the cart");
		}

	}

}

package stepDefinition;
import EbayProject.Pages.EbayAddToCartPage;
import EbayProject.Pages.EbayHomePage;
import EbayProject.Pages.EbayShoppingCart;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import utility.TestBase;

public class AddToCartStepDefinition extends TestBase {
	
	
	String itemselected;
	String iteminCart;
	EbayHomePage homepage;
	EbayAddToCartPage AddToCartPage;
	EbayShoppingCart shopingcart;
	
	
	@Given("^User launch Ebay website$")
	public void user_launch_Ebay_website() throws Throwable {
		TestBase.initialization();
		
	}

	@And("^Search for book$")
	public void search_for_book() throws Throwable {
		homepage=new EbayHomePage();
		homepage.searchItem("Book");
	}

	@And("^Click first available book$")
	public void click_first_available_book() throws Exception  {
		AddToCartPage=homepage.selectItem();
	}

	@And("^Add the book to the Cart$")
	public String add_the_book_to_the_Cart() throws Exception {
		itemselected=AddToCartPage.getitemName();
		AddToCartPage.addItemToCart(); 
		return itemselected;
	}

	@And("^User navigates to Shopping cart page$")
	public void user_navigates_to_Shopping_cart_page() throws Exception  {
		shopingcart=AddToCartPage.navigateToShoppingCart();
	    
	}

	@And("^verify whether the book is added to the cart$")
	public void verify_whether_the_book_is_added_to_the_cart() throws Exception  {
		String iteminCart=shopingcart.getitemNameCart();
		boolean value=shopingcart.verifyItemAddedTOCart(itemselected, iteminCart);
		if(value==true)
		{
			System.out.println("Item "+itemselected+ " is available in the cart");
		}
		else
		{
			System.out.println("Item "+itemselected+" is not available in the cart");
		}
	}

	@And("^Remove the book from the car$")
	public void remove_the_book_from_the_car() throws Exception  {
		shopingcart.removerItemFromCart();
	}

	@And("^Go to Cart page$")
	public void go_to_Cart_page() throws Exception  {
		shopingcart.cartlist();
	}

	@And("^veriy the cart is empty$")
	public void veriy_the_cart_is_empty() {
		boolean cartlist=shopingcart.verifyItemInCart();
		if(cartlist==false)
		{
			System.out.println("No item available in the cart");
		}
		else
		{
			System.out.println("Item "+itemselected+ "is avaible in the cart");
		}

	}
	
	@And("^Close the browser$")
	public void Close_the_browser()
	{
		log.info("Closing the browser");
		TestBase.closeBrowser();
	}
}

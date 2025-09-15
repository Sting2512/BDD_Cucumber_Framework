package stepDefinition;

import org.testng.Assert;
import io.cucumber.java.en.*;
import utilis.testContextSetup;

public class GreenKartStepDefinition 
{
	testContextSetup context;
	//public WebDriver driver;
	//public GreenKartObjectfile GKO;
	public String offerproductname;
	public String productname;
	
	public GreenKartStepDefinition(testContextSetup context) {
		this.context=context;
	}
	
	@Given("User on GreenCart Landing page")
	public void user_on_green_cart_landing_page() {
	}
	@When("user searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
		context.GKO.search(shortname);
		Thread.sleep(2000);
		String productname=context.GKO.product();
		System.out.println("ActualProduct name is: "+productname);
		
	}
	@Then("user searched for {string} in offers page to check if product exist with same name")
	public void user_searched_for_in_offers_page_to_check_if_product_exist_with_same_name(String samename) throws InterruptedException {
		context.GKO.clickdeals();
		//context.GKO.handle_multiple_window();
		context.GUT.handle_multiple_window();
		context.GKO.search(samename);
		Thread.sleep(2000);
		String offerproductname=context.GKO.offerproduct();
		System.out.println("OfferProduct name is: "+offerproductname);
	}
	@And("validate both the name")
	public void validate_both_the_name() {
		Assert.assertEquals(productname,offerproductname);
	}
}

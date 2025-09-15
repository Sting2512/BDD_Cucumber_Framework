package stepDefinition;

import org.testng.Assert;
import io.cucumber.java.en.*;
import utilis.testContextSetup;

public class GreenKartMutipleProduct 
{
	testContextSetup context;
	public String offerproductname;
	public String productname;
	
	public GreenKartMutipleProduct(testContextSetup context) {
		this.context=context;
	}
	
	@When("^user searched with Shortname (.+) and extracted actual name of product's$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
		context.GKO.search(shortname);
		Thread.sleep(2000);
		String productname=context.GKO.product();
		System.out.println("ActualProduct name is: "+productname);
		
	}
	@Then("^user searched for (.+) in offers page to check if product exist with same name's$")
	public void user_searched_for_in_offers_page_to_check_if_product_exist_with_same_name(String samename) throws InterruptedException {
		context.GKO.clickdeals();
		//context.GKO.handle_multiple_window();
		context.GUT.handle_multiple_window();
		context.GKO.search(samename);
		Thread.sleep(2000);
		String offerproductname=context.GKO.offerproduct();
		System.out.println("OfferProduct name is: "+offerproductname);
	}
}

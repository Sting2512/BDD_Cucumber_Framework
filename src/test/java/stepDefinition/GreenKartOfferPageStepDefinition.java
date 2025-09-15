package stepDefinition;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageObject.GreenKartObjectfile;
import utilis.testContextSetup;

public class GreenKartOfferPageStepDefinition 
{
	testContextSetup context;
	public WebDriver driver;
	public GreenKartObjectfile GKO;
	//public genericUtilis GU; 
	
	public GreenKartOfferPageStepDefinition(testContextSetup tc) {
		this.context=tc;

	}

	@When("user click on offer deals link")
	public void user_click_on_offer_deals_link() {
		context.GKO.clickdeals();
	}

	@Then("user lands on offer page")
	public void user_lands_on_offer_page() {
		context.GUT.handle_multiple_window();
		//context.GUT.handle_multiple_window();
	}

	@Then("user searched for {string} in offers page")
	public void user_searched_for_in_offers_page(String samename) throws InterruptedException {
		context.GKO.search(samename);
		Thread.sleep(2000);
	}

	@And("extract the name")
	public void extract_the_name() {
		String offerproductname=context.GKO.offerproduct();
		System.out.println("OfferProduct name is: "+offerproductname);
	}

}

package stepDefinition;

import io.cucumber.java.en.*;
import pageObject.GreenKartObjectfile;
import utilis.testContextSetup;

public class GreenKartProductOrder 
{
	testContextSetup TC;
	
	public GreenKartProductOrder(testContextSetup Testsetup) {
		this.TC= Testsetup;
	}
	
	@Then("user add the quantity")
	public void user_add_the_quantity() {
		TC.GKO.adding();
	}

	@Then("user click on add to cart button")
	public void user_click_on_add_to_cart_button() {
		TC.GKO.cart();
	}
	
	@Then("click on cart icon")
	public void click_on_cart_icon() {
	    TC.GKO.cartIcon();
	}

	@Then("user click on proceed to checkout")
	public void user_click_on_proceed_to_checkout() throws InterruptedException {
		TC.GKO.checkOut();
		Thread.sleep(4000);
		System.out.println("checkout");
		
	}

	@Then("click on the place order")
	public void click_on_the_place_order() {
		System.out.println("placeorder");
		TC.GKO.placeOrder();
	}

	@Then("select the country as {string}")
	public void select_the_country_as(String name) {
	    TC.GKO.Country(name);
	}

	@Then("check the checkbox on Terms and Conditions")
	public void check_the_checkbox_on_terms_and_conditions() {
		TC.GKO.chkbx();
	}

	@Then("click on proceed")
	public void click_on_proceed() {
	    TC.GKO.btn();
	}
}

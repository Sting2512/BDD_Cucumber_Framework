package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GreenKartObjectfile 
{

	private WebDriver ldriver;
	public GreenKartObjectfile(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	} 
	
	@FindBy(xpath = "//input[@type='search']")                WebElement srch;
	@FindBy(css = "h4.product-name")                      	  WebElement prod;
	@FindBy(linkText = "Top Deals")                           WebElement clickDeals;
	@FindBy(css = "tr td:nth-child(1)")                       WebElement offerprod;
	@FindBy(linkText = "+")                                   WebElement add;
	@FindBy(xpath = "//button[text()='ADD TO CART']")         WebElement addtocart;
	@FindBy(xpath = "//img[@alt='Cart']")                     WebElement carticon;
	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']") WebElement checkout;
	@FindBy(xpath = "//button[text()='Place Order']")         WebElement placeorder;
	@FindBy(xpath = "//select[@style='width: 200px;']")       WebElement ctry;
	@FindBy(xpath = "//input[@type='checkbox']")              WebElement chkbx;
	@FindBy(xpath = "//button[text()='Proceed']")             WebElement btn;
	
	public void search(String search) 
	{
		srch.sendKeys(search);
	}
	public String product() 
	{
		String productText= prod.getText().split("-")[0].trim();
		return productText;
	}
	public void clickdeals() {
		clickDeals.click();
	}
	public String offerproduct() 
	{
		String offerproductText= offerprod.getText();
		return offerproductText;
	}
	public void adding() {
		add.click();
	}
	public void cart() {
		addtocart.click();
	}
	public void checkOut() {
		checkout.click();
	}
	public void cartIcon() {
		carticon.click();
	}
	public void placeOrder() {
		placeorder.click();
	}
	public void Country(String country) {
		Select Country = new Select(ctry);
		Country.selectByVisibleText(country);
	}
	public void chkbx() {
		chkbx.click();
	}
	public void btn() {
		btn.click();
	}
}
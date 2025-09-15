package utilis;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import pageObject.GreenKartObjectfile;

public class testContextSetup {
	public WebDriver driver;
	public GreenKartObjectfile GKO;
	public testBase TestBase;
	public genericUtilis GUT;
	
	public testContextSetup() throws IOException {
		
	
		TestBase = new testBase();
		GKO = new GreenKartObjectfile(TestBase.WebDriverManager());
		GUT = new genericUtilis(TestBase.WebDriverManager());
		
	}

}

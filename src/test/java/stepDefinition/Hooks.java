package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import utilis.testContextSetup;

public class Hooks 
{
	testContextSetup tc;
	
	public Hooks(testContextSetup tc) 
	{
		this.tc= tc;
	}

	@After
	public void close_all_the_browser() throws IOException {
		tc.TestBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void screenshot(io.cucumber.java.Scenario scenario) throws IOException {
		WebDriver driver = tc.TestBase.WebDriverManager();
		if(scenario.isFailed()) 
		{
			File sourcepath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent= FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(filecontent, "image/jpeg", "image");
		}
	}
}

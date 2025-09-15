package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",
glue = "stepDefinition",
monochrome = true,
dryRun = false,
plugin = {"pretty",
		"html:target/cucumber-reports.html",
		"json:target/cucumber-reports.json",
		"junit:target/cucumber-reports.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failedrerun.txt"},
tags = "@search"

)
public class TestNGTestRunner extends AbstractTestNGCucumberTests
{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}

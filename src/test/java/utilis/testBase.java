package utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase 
{
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException 
	{
		
		FileInputStream files= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(files);
		String URL= prop.getProperty("url");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		String browser = browser_maven!= null ? browser_maven : browser_properties;

		if (driver == null) 
		{
			switch (browser.toLowerCase())
			{
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
//				case "opera":
//					WebDriverManager.operadriver().setup();
//					driver = new OperaDriver();
//					break;
				default : 
					throw new RuntimeException("unsupposted browseer: "+ browser);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(URL);
			
		}
		return driver;
	}

}

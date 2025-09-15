package utilis;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class genericUtilis {
	
	public WebDriver driver;
	
	public genericUtilis(WebDriver driver) {
		this.driver= driver;
	}
	
	public void handle_multiple_window() {
		Set<String> WinAll= driver.getWindowHandles();
		Iterator<String> win= WinAll.iterator();
		String Parentwindow=win.next();
		String ChildWindow=win.next();
		driver.switchTo().window(ChildWindow);
	}

}

package util;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods
{

	public static WebDriver openBrowser(String url)
	{
				
		WebDriver driver=null;
		try {
			System.setProperty("webdriver.chrome.driver","R:\\SeleniumDownloads\\chromedriver.exe");
		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		
			driver.get(url);  
			return driver;
		}
		catch (SessionNotCreatedException e)
		{
			System.out.println(e.getMessage());
			return driver;
		}
		catch(IllegalStateException e)
		{
			System.out.println(e.getMessage());
			return driver;
		}
	}
	
}

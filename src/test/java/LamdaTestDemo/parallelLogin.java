package LamdaTestDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parallelLogin 
{
	
	
	/*public void Login(@Optional("Chrome") String browserName, 
                      @Optional("125") String browserVersion, 
                      @Optional("Windows 11") String osVersion) throws MalformedURLException*/
	
	@Test
	@Parameters({"browserName", "browserVersion", "osVersion"})	
	public void Login(String browserName, String browserVersion, String osVersion) throws MalformedURLException
	{
		WebDriver driver=null;
		
		System.out.println("Starting test with browser: " + browserName + ", version: " + browserVersion + ", OS: " + osVersion);

		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "soorajkarkala99");
		ltOptions.put("accessKey", "zFIu4BsyNhae86CqBemODKxknNp9OMo4oQDnc4wUpP0OxN5iqJ");
		ltOptions.put("video", true);
		ltOptions.put("build", "chrome browser");
		ltOptions.put("project", "Untitled");
		ltOptions.put("w3c", true);
		
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName(osVersion);
			browserOptions.setBrowserVersion(browserVersion);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver=new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"),browserOptions);
			
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			EdgeOptions browserOptions = new EdgeOptions();
			browserOptions.setPlatformName(osVersion);
			browserOptions.setBrowserVersion(browserVersion);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver=new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"),browserOptions);
			
		}
		else
		{
			System.out.println("Browser not found");
		}
		
        driver.get("https://freelance-learn-automation.vercel.app/login");
		
		Assert.assertTrue(driver.getTitle().contains("Learn Automation Courses")); 
		
		driver.findElement(By.id("email1")).sendKeys("soorajkarkala99@gmail.com");
		driver.findElement(By.cssSelector("#password1")).sendKeys("abcdefg");
		driver.findElement(By.xpath("//*[@class='submit-btn']")).click();
		
		//Assert.assertTrue(driver.getTitle().contains("Learn Automation Courses"));
		
		driver.quit();
	}

}

package LamdaTestDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void logintest() throws MalformedURLException
	{
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("125");
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "soorajkarkala99");
		ltOptions.put("accessKey", "zFIu4BsyNhae86CqBemODKxknNp9OMo4oQDnc4wUpP0OxN5iqJ");
		ltOptions.put("geoLocation", "IN");
		ltOptions.put("video", true);
		ltOptions.put("timezone", "Kolkata");
		ltOptions.put("build", "SeleniumLamdaTest");
		ltOptions.put("project", "SeleniumLamdaTest");
		ltOptions.put("w3c", true);
		browserOptions.setCapability("LT:Options", ltOptions);
		
		// Use Selenium grid to create the session in Lamda test
		//For selenium grid we are using dedicated class called RemoteWebDriver(URl, Capabilities)
		
		WebDriver driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);  
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		Assert.assertTrue(driver.getTitle().contains("Learn Automation Courses")); 
		
		driver.findElement(By.id("email1")).sendKeys("soorajkarkala99@gmail.com");
		driver.findElement(By.cssSelector("#password1")).sendKeys("abcdefg");
		driver.findElement(By.xpath("//*[@class='submit-btn']")).click();
		
		//Assert.assertTrue(driver.getTitle().contains("Learn Automation Courses"));
		
		driver.quit();
	}
}

package testScripts;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class RemoteDriverTest {
		WebDriver driver;
		@Test
		public void test() throws MalformedURLException{
			ChromeOptions options= new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			String strHub="http://172.31.19.192:4444";
			driver= new RemoteWebDriver(new URL(strHub),options);
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.google.com/");
		WebElement schBox= driver.findElement(By.name("q"));
		schBox.sendKeys("Java Tutorial");
		schBox.submit();
		System.out.println("Page Title is.."+ driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
			
	
		



	}

}

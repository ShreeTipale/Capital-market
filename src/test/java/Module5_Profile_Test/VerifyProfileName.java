package Module5_Profile_Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class VerifyProfileName 
{
	@Test
	public void verifyPN() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://kite.zerodha.com/");
		
		driver.findElement(By.id("userid")).sendKeys("KEW321");
		driver.findElement(By.id("password")).sendKeys("Shree@17");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//pin
		Thread.sleep(2000);
		driver.findElement(By.id("pin")).sendKeys("141528");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Continue ']")).click();
		
		//verify profile name
		String expName = "KEW321";
		String actName = driver.findElement(By.xpath("//span[@class='user-id']")).getText();
		Assert.assertEquals(expName, actName);
	}

}

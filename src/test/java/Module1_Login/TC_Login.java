package Module1_Login;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TC_Login
{
	@Test
	public void login() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp-pc\\Downloads\\Selenium\\chromedriver.exe");
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
		System.out.println(driver.getTitle());
		//Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform" , driver.getTitle());
		
	
	}

}

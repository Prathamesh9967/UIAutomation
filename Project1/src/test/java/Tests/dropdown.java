package Tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.GoogleSearchPage;

public class dropdown {
	
	WebDriver driver = null;
	
    ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest test;
	
	@BeforeTest
	public void Setup() {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chromedr", projectpath+"Drivers/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReport.html");
        extent.attachReporter(spark);
	}
	
	@Test
	public void dropdownHover() {		
				
		test = extent.createTest("Test has launched");
		
		driver.get("https://www.flipkart.com/");
		
		test.pass("Navigated to Flipkart");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement dropdown = driver.findElement(By.xpath("//text()[.='Fashion']/ancestor::div[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(dropdown).perform();
		
		WebElement element = driver.findElement(By.xpath("//text()[.='Kids']/ancestor::a[1]"));
		action.moveToElement(element).click().perform();
		
		WebElement electronics = driver.findElement(By.xpath("//span[text()=\"Electronics\"]"));
		action.moveToElement(electronics).perform();
		test.pass("Clicked on dropdown elements");
		
		WebElement Mi = driver.findElement(By.xpath("//a[text()='Mi']"));
		action.moveToElement(Mi).click().perform();
		
		WebElement miMob = driver.findElement(By.xpath("//h1[@class=\"_10Ermr\"]"));
	
		Assert.assertEquals(false, miMob.isDisplayed());
		
		test.info("Test completed");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		extent.flush();
	}

}

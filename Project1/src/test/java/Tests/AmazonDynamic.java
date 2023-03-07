package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AmazonDynamic {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void Setup() {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chromedr", projectpath+"Drivers/ChromeDriver/chromedriver.exe");
		
		driver = new ChromeDriver();
	}
	
	@Test
	public void amazonDynamicTest() {		
				
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
				
		List<WebElement> list =  driver.findElements(By.xpath("//div[@class=\"autocomplete-results-container\"]//div/descendant::div[@role=\"button\"]"));
		
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().contains("iphone 12")) {
				list.get(i).click();
				break;
			}
		}
		//Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"SPZz6b\"]")).isDisplayed());
	}
	
	@AfterTest
	public void tearDown() {
		//driver.close();
	}

}

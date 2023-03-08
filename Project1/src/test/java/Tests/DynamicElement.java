package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DynamicElement {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void Setup() {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chromedr", projectpath+"Drivers/ChromeDriver/chromedriver.exe");
		
		driver = new ChromeDriver();
	}
	
	@Test
	public void dynamicTest() {		
				
		driver.get("https://www.google.co.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.name("q")).sendKeys("car");
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li/descendant::div[@class=\"wM6W7d\"]"));
		
		System.out.println("no of suggestions are :" + list.size());
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().contains("cardekho")) {
				list.get(i).click();
				break;
			}
		}
		
		Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"SPZz6b\"]")).isDisplayed());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}

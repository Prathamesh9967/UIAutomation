package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.GoogleSearchPage;

public class TestNGDemo {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void Setup() {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chromedr", projectpath+"Drivers/ChromeDriver/chromedriver.exe");
		
		driver = new ChromeDriver();
	}
	
	@Test
	public void googleserachTest() {		
		
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		
		driver.get("http://testphp.vulnweb.com/login.php");
		
		searchPage.setUname("test");
		searchPage.setPass("test");
		
		searchPage.clickButton();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}

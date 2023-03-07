package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleserachTest();
	}
	
	public static void googleserachTest() {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chromedr", projectpath+"Drivers/ChromeDriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		
		driver.get("http://testphp.vulnweb.com/login.php");
		
		searchPage.setUname("test");
		searchPage.setPass("test");
		
		searchPage.clickButton();
		
//		driver.close();
	}
}

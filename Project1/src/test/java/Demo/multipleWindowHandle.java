package Demo;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleWindowHandle {
	public static void main(String[] args) {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chromedr", projectpath+"Drivers/ChromeDriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		//Navigating to amazon.com
		driver.get("https://www.amazon.in//");
		String currentTab= driver.getWindowHandle();
		// Searching for Headphones
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones", Keys.ENTER);
		
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);

		String childTab = newTab.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		
		System.out.println("total tabs opened are " + tabs.size());
		
		newWindow.get("https://www.google.co.in/");
		
		newTab.get("https://www.flipkart.com/");
		
//		newTab.findElement(By.name("q")).sendKeys("selenium multiple tabs", Keys.ENTER);
//		
//		driver.switchTo().window(currentTab);
//		driver.findElement(By.id("nav-logo-sprites")).click();
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.quit();
	}
}

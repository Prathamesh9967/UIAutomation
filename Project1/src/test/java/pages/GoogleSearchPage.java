package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
		
	WebDriver driver = null;

	By username = By.name("uname");
	By password = By.name("pass");
	By button = By.xpath("//input[@value=\"login\"]");
		
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUname(String uname) {
		driver.findElement(username).sendKeys(uname);
	}
	
	public void setPass(String uname) {
		driver.findElement(password).sendKeys(uname);
	}
	
	public void clickButton() {
		driver.findElement(button).sendKeys(Keys.RETURN);;
	}
}

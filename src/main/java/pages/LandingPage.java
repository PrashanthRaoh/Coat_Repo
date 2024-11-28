package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.UtilityClass;

public class LandingPage extends UtilityClass {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	Page Factory
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement Submitbutton;
	
	public ProductCatalog login(String username,String Password) {
		userEmail.sendKeys(username);
		userPassword.sendKeys(Password);
		Submitbutton.click();
		ProductCatalog prodcat = new ProductCatalog(driver);
		return prodcat;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}

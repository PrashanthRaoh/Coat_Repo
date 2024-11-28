package Utility;

import java.time.Duration;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.CartPage;

public class UtilityClass {
	WebDriver driver;
	
	public UtilityClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement CartLink;
	
	
	public void waitforelementtoAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitforElementToDisapper(WebElement elementtobeWaited) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//		wait.until(ExpectedConditions.invisibilityOf(elementtobeWaited));
		Thread.sleep(3000);
	}
	
	public CartPage gotoCartpage() {
		CartLink.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public String PasswordEncoderdecoder() {
		return new String(Base64.decodeBase64("UmFvYWRAMTk3OQ=="));		
	}
}

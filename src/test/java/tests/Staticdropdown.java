package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Staticdropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement ddele = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
		Select dropdowns = new Select(ddele);
		dropdowns.selectByIndex(0);
		Thread.sleep(2000);
		dropdowns.selectByValue("INR");
		Thread.sleep(2000);
		dropdowns.selectByVisibleText("AED");
		Thread.sleep(2000);
	}

}

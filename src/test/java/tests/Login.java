package tests;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Utility.UtilityClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartPage;
import pages.LandingPage;
import pages.ProductCatalog;


public class Login {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String ProductName = "ZARA COAT 3";
		
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		UtilityClass util = new UtilityClass(driver);
		ProductCatalog prodcat = lp.login("iprashanth.raoh@gmail.com", util.PasswordEncoderdecoder());
		List<WebElement> allproducts = prodcat.getProductsList();
		prodcat.addProdcutTo_Cart(ProductName);
		CartPage cartpage = prodcat.gotoCartpage();
		
		cartpage.verifyProductsDisplay(ProductName);
		cartpage.Checkout();
		Thread.sleep(2000);
	}
}


/////End of file

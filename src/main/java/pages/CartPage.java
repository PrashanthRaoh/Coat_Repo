package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.UtilityClass;

public class CartPage extends UtilityClass {
WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy (css = ".cartSection h3")
	private List<WebElement> AllcartProducts;
	
	@FindBy(css=".totalRow button")
	private WebElement Checkout;
	
	public boolean verifyProductsDisplay(String productname) {
		boolean match = AllcartProducts.stream().anyMatch(prod-> prod.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	public CheckOutPage Checkout() {
		Checkout.click();
		return new CheckOutPage(driver);
		
	}
}

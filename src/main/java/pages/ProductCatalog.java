package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utility.UtilityClass;

public class ProductCatalog extends UtilityClass {
	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCartProduct = By.cssSelector(".card-body button:last-of-type");
	By ToastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductsList() {
		waitforelementtoAppear(productsBy);
		return products;
	}

//	
	public WebElement getProductbyName(String productName) {
		WebElement prod = getProductsList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProdcutTo_Cart(String productName) throws InterruptedException {
		getProductbyName(productName).findElement(addToCartProduct).click();
		waitforElementToDisapper(spinner);
	}
}

package page_elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.BasePage;

public class HomePageElements extends BasePage {

	WebDriver driver;

	@FindBy(css = "input[placeholder = 'Search for Vegetables and Fruits']")
	public WebElement searchbarInput;
	@FindBy(css = "a[href *= 'offers']")
	public WebElement topDealsLink;
	@FindBy(css = "img[alt = 'Cart']")
	public WebElement cartButton;
	@FindBy(css = "div.products .product")
	public List<WebElement> products;
	@FindBy(css = ".cart-preview .cart-items .cart-item")
	public List<WebElement> itemsInCart;

	public HomePageElements(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

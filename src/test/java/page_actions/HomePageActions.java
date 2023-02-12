package page_actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page_elements.HomePageElements;
import steps.CommonSteps;
import util.StringUtil;

public class HomePageActions {

	private WebDriver driver;
	HomePageElements homePageElements;
	CommonActions commonActions;

	public HomePageActions(CommonSteps commonSteps) {
		driver = commonSteps.getDriver();
		homePageElements = new HomePageElements(driver);
		commonActions = new CommonActions(commonSteps);
	}

	public void search(String query) {
		homePageElements.searchbarInput.sendKeys(query);
	}

	public void goToTopDeals() {
		homePageElements.topDealsLink.click();
	}

	public void showCart() {
		homePageElements.cartButton.click();
	}

	public List<String> getProductNames() {
		commonActions.hardwaitFor(3);
		List<String> names = homePageElements.products.stream().map(product -> {
			return StringUtil.remove(" - (\\d{1,}|\\d{1,}/\\d{1,}) Kg",
					commonActions.getText(product.findElement(By.cssSelector("h4.product-name"))));
		}).toList();

		return names;
	}

	public boolean productsMatchWithName(List<String> products, String name) {
		return products.stream().allMatch(product -> product.toLowerCase().contains(name));
	}

	public void addProductToCart(String productName, String quantity) {
		WebElement targetProduct = homePageElements.products.stream()
				.filter(product -> commonActions.getText(product).contains(productName)).findFirst().get();
		selectQuantity(targetProduct, quantity);
		targetProduct.findElement(By.xpath("//h4/following-sibling::div[@class='product-action']")).click();
	}

	public void selectQuantity(WebElement targetProduct, String qty) {
		int quantity = Integer.parseInt(qty);
		while (quantity > 1) {
			targetProduct
					.findElement(By.xpath("//h4/following-sibling::div[@class='stepper-input']/a[@class='increment']"))
					.click();
			quantity--;
		}
	}
	
	public void productNameAndQuantityMatches(String productName, String qty) {
		
	}
}

package page_actions;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page_elements.HomePageElements;
import steps.CommonSteps;
import util.LoggerUtil;
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
					commonActions.getText(commonActions.scopedFindElementByCss(product, "h4.product-name")));
		}).toList();

		return names;
	}

	public boolean productsMatchWithName(List<String> products, String name) {
		return products.stream().allMatch(product -> product.toLowerCase().contains(name));
	}

	public void addProductToCart(String productName, String quantity) {
		commonActions.hardwaitFor(3);
		WebElement targetProduct = homePageElements.products.stream()
				.filter(product -> {
					LoggerUtil.logInfo("SELECTED PRODUCT = " + commonActions.getText(commonActions.scopedFindElementByCss(product, "h4.product-name")));
					return commonActions.getText(commonActions.scopedFindElementByCss(product, "h4.product-name")).contains(productName);
				})
				.findFirst()
				.get();
		selectQuantity(targetProduct, quantity);
		commonActions.scrollToElement(targetProduct);
		commonActions.waitForElementToBeClickable(targetProduct);
		commonActions.click(commonActions.scopedFindElementByCss(targetProduct, ".product-action button"));
	}

	public void selectQuantity(WebElement targetProduct, String qty) {
		int quantity = Integer.parseInt(qty);
		while (quantity > 1) {
			commonActions.scopedFindElementByXpath(targetProduct,
					"//h4/following-sibling::div[@class='stepper-input']/a[@class='increment']").click();
			quantity--;
		}
	}

	public boolean productNameAndQuantityMatches(String productName, String qty) {
		return homePageElements.itemsInCart.stream()
				.allMatch(item -> {
					return commonActions
					.getText(commonActions.scopedFindElementByCss(item, ".product-info .product-name")).contains(productName) && 				commonActions.getText(commonActions.scopedFindElementByCss(item, ".product-total .quantity")).contains(qty);
				});
	}
}

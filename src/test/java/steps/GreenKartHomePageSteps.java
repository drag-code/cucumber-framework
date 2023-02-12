package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_actions.CommonActions;
import page_actions.HomePageActions;
import util.Constants;
import util.StringUtil;

public class GreenKartHomePageSteps {
	CommonActions commonActions;
	HomePageActions homePageActions;

	public GreenKartHomePageSteps(CommonActions commonActions, HomePageActions homePageActions) {
		this.commonActions = commonActions;
		this.homePageActions = homePageActions;
	}

	@Given("User is on homepage")
	public void user_is_on_homepage() {
		commonActions.goToURL(Constants.HOME_PAGE_URL);
	}

	@When("User enters {string} into searchbar")
	public void user_enters_into_searchbar(String product) {
		homePageActions.search(product);
	}

	@Then("User should see only {string} results")
	public void user_should_see_only_results(String product) {
		List<String> productNames = homePageActions.getProductNames();
		assertTrue(homePageActions.productsMatchWithName(productNames, product));
	}

	@Then("User should be able to see a list of products")
	public void user_should_be_able_to_see_a_list_of_products() {
		List<String> productNames = homePageActions.getProductNames();
		assertNotNull(productNames);
	}
	
	@When("User clicks {string}")
	public void user_clicks(String link) {
		commonActions.clickOnLinkByText(link);
	}
	
	@Then("User should navigate to {string} of the page")
	public void user_should_navigate_to_of_the_page(String url) {
		String replacedUrl = StringUtil.replace("&hash", url, "#");
		commonActions.switchToTab(replacedUrl);
		String currentUrl = commonActions.getCurrentUrl();
		assertTrue(currentUrl.contains(replacedUrl));
	}
	
	@When("User selects {string} and {string} and clicks add to cart button")
	public void user_selects_and_and_clicks_add_to_cart_button(String productName, String quantity) {
	    homePageActions.addProductToCart(productName, quantity);
	}
	@When("Clicks on cart section")
	public void clicks_on_cart_section() {
		homePageActions.showCart();
	}
	@Then("The quantity and productName displayed should match with {string} and {string} selected")
	public void the_quantity_and_product_name_displayed_should_match_with_and_selected(String productName, String quantity) {
	    
	}
	
	@Then("{string} status code should be {int}")
	public void status_code_should_be(String url, Integer expectedStatusCode) {
		int actualStatusCode = commonActions.getStatusCodeFromUrl(StringUtil.replace("&hash", url, "#"));
		assertEquals(actualStatusCode, expectedStatusCode);
	}
}

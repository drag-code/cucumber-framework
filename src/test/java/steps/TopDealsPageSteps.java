package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_actions.CommonActions;
import page_actions.TopDealsPageActions;

public class TopDealsPageSteps {
	CommonActions commonActions;
	TopDealsPageActions topDealsPageActions;

	public TopDealsPageSteps(CommonActions commonActions, TopDealsPageActions topDealsPageActions) {
		this.commonActions = commonActions;
		this.topDealsPageActions = topDealsPageActions;
	}

	@Given("User is on Top Deals Page")
	public void user_is_on_top_deals_page() {
	    commonActions.goToURL("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	}
	@When("User changes page size to {string}")
	public void user_changes_page_size_to(String pageSize) {
	    topDealsPageActions.setPageSize(pageSize);
	}
	@Then("Each page should contain the same {string}")
	public void each_page_should_contain_the_same(String pageSize) {
	    topDealsPageActions.pageSizeOfEachPageMatchesWithExpectedSize(pageSize);
	}

}

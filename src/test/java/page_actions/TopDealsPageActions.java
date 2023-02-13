package page_actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import page_elements.TopDealsPageElements;
import steps.CommonSteps;
import util.StringUtil;

public class TopDealsPageActions {

	private WebDriver driver;
	TopDealsPageElements topDealsPageElements;
	CommonActions commonActions;

	public TopDealsPageActions(CommonSteps commonSteps) {
		driver = commonSteps.getDriver();
		topDealsPageElements = new TopDealsPageElements(driver);
		commonActions = new CommonActions(commonSteps);
	}

	public void setPageSize(String size) {
		Select pageSize = new Select(topDealsPageElements.pageSizeDropdown);
		pageSize.selectByValue(size);
	}

	public int getResultRowsCount() {
		return topDealsPageElements.resultRows.size();
	}

	public boolean pageSizeOfEachPageMatchesWithExpectedSize(String size) {
		int expectedSize = StringUtil.parseInt(size);
		return topDealsPageElements.pages.stream().allMatch(page -> {
			commonActions.click(page);
			int actualSize = getResultRowsCount();
			commonActions.hardwaitFor(2);
			return actualSize <= expectedSize;
		});
	}
}

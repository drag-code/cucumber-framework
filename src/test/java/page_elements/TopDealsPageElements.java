package page_elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopDealsPageElements {

	WebDriver driver;

	@FindBy(id = "page-menu")
	public WebElement pageSizeDropdown;
	@FindBy(css = "a[aria-label='Previous']")
	public WebElement previousButton;
	@FindBy(css = "a[aria-label='First']")
	public WebElement firstButton;
	@FindBy(css = "a[aria-label='Next']")
	public WebElement nextButton;
	@FindBy(css = "a[aria-label='Last']")
	public WebElement lastButton;
	@FindBy(xpath = "//li/a[@aria-label='Next']/preceding::li[preceding::a[@aria-label='Previous']]")
	public List<WebElement> pages;
	@FindBy(css = "tbody>tr")
	public List<WebElement> resultRows;

	public TopDealsPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

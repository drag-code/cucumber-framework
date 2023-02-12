package page_actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import steps.CommonSteps;
import util.LoggerUtil;

public class CommonActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor jsExecutor;

	public CommonActions(CommonSteps commonSteps) {
		driver = commonSteps.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		jsExecutor = (JavascriptExecutor) driver;
	}
	
	public void scrollToElement(WebElement element) {
		jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void waitForElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement scopedFindElementByCss(WebElement element, String cssSelector) {
		return element.findElement(By.cssSelector(cssSelector));
	}
	
	public WebElement scopedFindElementByXpath(WebElement element, String xpath) {
		return element.findElement(By.xpath(xpath));
	}

	public void waitForElementsToBePresent(By locator) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)));
	}

	public void waitForElementsToAppear(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForElementToAppear(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void hardwaitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

		}
	}

	public void clickOnLinkByText(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}

	public void goToURL(String URL) {
		driver.get(URL);
	}

	public void switchToTab(String URL) {
		Iterator<String> tabsIterator = driver.getWindowHandles().iterator();
		while (tabsIterator.hasNext()) {
			String currentTab = tabsIterator.next();
			driver.switchTo().window(currentTab);
			if (getCurrentUrl().equals(URL)) {
				break;
			}
		}
	}

	public void quitDriver() {
		driver.quit();
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public int getStatusCodeFromUrl(String url) {
		int statusCode = 400;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			statusCode = connection.getResponseCode();
		} catch (IOException e) {
			LoggerUtil.logError(e.getMessage());
		}

		return statusCode;
	}
}

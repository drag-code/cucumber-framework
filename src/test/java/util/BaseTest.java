package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import page_elements.HomePageElements;

public class BaseTest {
	public static WebDriver driver;
	public static Properties properties = new Properties();
	public HomePageElements homePage;
	
	private void initializeDriver() {
		try {
			FileInputStream fis = new FileInputStream(Constants.PROJECT_ROOT_PATH + "\\config.properties");
			properties.load(fis);
			String browser = properties.getProperty("browser", "chrome");
			
			switch (browser) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} catch (IOException e) {
			LoggerUtil.logError("An exception ocurred \n" + e.getMessage());
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	@BeforeMethod
	public void openApp() {
		initializeDriver();
		driver.get(Constants.HOME_PAGE_URL);
		homePage = new HomePageElements(driver);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

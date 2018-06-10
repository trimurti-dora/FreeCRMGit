package automationTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class MyWebDriver {
	public static WebDriver driver(String browser){
		WebDriver driver = null;
		if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ASUS\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
		
	}
}

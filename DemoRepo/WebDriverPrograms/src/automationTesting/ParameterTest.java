package automationTesting;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParameterTest {
	WebDriver driver;
	
	@BeforeMethod(groups= {"smoke","system"})
	@Parameters({"browser"})
	public void launchBrowser(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ASUS\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@Test(groups= {"system"})
	@Parameters({"username", "password"})
	public void login(String username, String password) {
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@value='Log In']")).click();
	}
	
	@Test(groups= {"system", "smoke"})
	public void getPageTitle() 
	{
		System.out.println(driver);
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod(groups= {"smoke","system"})
	public void closeBrowser() {
		driver.close();
	}
	
}

package automationTesting;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DataProviderTestNG {
	WebDriver driver;
	@BeforeMethod
	public void lunchChrome() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/ASUS/webdrivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
	
	@Test(priority=1)
	@Parameters({"username", "password"})
	public void useFacebook(String username, String password) {
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(username);;
		driver.findElement(By.xpath("//*[@name='pass']")).sendKeys(password);
		
	}
	@Test(priority=0)
	@Parameters({"username", "password"})
	public void getPageTitle() {
		System.out.println(driver.getTitle());
		
	}

}

package automationTesting;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MouseHover {

	public static WebDriver driver;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		System.out.println("Enter Browser Type : ");
		String browserType = br.readLine();
		if(browserType.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}else if(browserType.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\ASUS\\Downloads\\drivers\\IEDriverServer.exe");
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://newtours.demoaut.com");
			driver = new InternetExplorerDriver(capability);
		}else if(browserType.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ASUS\\Downloads\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Launch Flight Reservation Application
		driver.get("https://www.flipkart.com/");
		// Maximize The Browser
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
		Actions action = new Actions(driver);
		String Text = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]")).getText();
		//WebElement Text = driver.findElement(By.linkText("Men"));
		Thread.sleep(3000);
		System.out.println(Text);
		action.moveToElement(driver.findElement(By.linkText("(//*[@class='_3ZgIXy'][@title ='T-Shirts']//span[contains(text(),'T-Shirts')])"))).click().build().perform();
		//action.moveToElement(Text).build.perform();
		
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//span[text()='T-Shirts']")).click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("Men's T-Shirts")){
			System.out.println("Status -- Pass");
		}else{
			System.out.println("Status -- Fail");
		}
		
		driver.quit();
}
	
	
}
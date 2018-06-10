package automationTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class switchFrame {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriverWait myWaitVar = new WebDriverWait(driver, 13);
		driver.navigate().to("https://aetnacca.webex.com");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.switchTo().frame("mainFrame").switchTo().frame("main");
		WebElement e = driver.findElement(By.name("meetingNum"));
		e.sendKeys("7894564156");
		driver.switchTo().defaultContent().switchTo().frame("header");
		driver.findElement(By.id("wcc-lnk-MW")).click();
		System.out.println("Program ended");
	}

}

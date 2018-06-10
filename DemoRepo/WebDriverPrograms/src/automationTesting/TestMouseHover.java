package automationTesting;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
public class TestMouseHover {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.spicejet.com/");
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='ctl00_HyperLinkLogin']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(), 'SpiceCash/SpiceClub Members')]"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(), 'SpiceCash/SpiceClub Members')]//following::a"))).click().build().perform();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> links = new LinkedList<WebElement>();
		links= driver.findElements(By.tagName("a"));
		for(WebElement link: links){
			System.out.println(link.getText());
		}
		}

}

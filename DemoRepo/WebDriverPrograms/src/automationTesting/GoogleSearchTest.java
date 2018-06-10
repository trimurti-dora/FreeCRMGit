package automationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class GoogleSearchTest {

	public static void main(String[] args) throws Exception {
		WebDriver driver = MyWebDriver.driver("chrome");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("testing");
		Thread.sleep(2000);
		List<WebElement> searchlist = new LinkedList<WebElement>();
		searchlist = driver.findElements(By.xpath("//*[@role='listbox']//*[@class='sbqs_c']"));
		for(WebElement result:searchlist){
			System.out.println(result.getText());
			if(result.getText().equals("testing of hypothesis")){
				result.click();
			}
		}
	}

}

package automationTesting;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
public class fbCreateAccount {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:/Users/ASUS/webdrivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String url="https://facebook.com";
		driver.get(url);
		driver.findElement(By.name("firstname")).sendKeys("Trimurti");
		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("Dora");
		driver.findElement(By.cssSelector("#u_0_p")).sendKeys("1234567894");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Ptd#1234");
		Select bDay = new Select(driver.findElement(By.name("birthday_day")));
		bDay.selectByValue("1");
		Select bMonth = new Select(driver.findElement(By.name("birthday_month")));
		bMonth.selectByVisibleText("Jul");
		Select bYear = new Select(driver.findElement(By.name("birthday_year")));
		bYear.selectByVisibleText("1992");
		List<WebElement> gender = driver.findElements(By.tagName("label"));

		for(WebElement sex: gender){
			if(sex.getText().equals("Male")){
				System.out.println(sex.getText());
				sex.click();
			}
		}
		
		//driver.findElement(By.name("websubmit")).click();
		Actions keyAction = new Actions(driver); keyAction.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
		System.out.println("Program ended");
	}

}

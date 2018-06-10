package automationTesting;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class alertBox {
	public static void main(String[] args){
	try{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://output.jsbin.com/usidix/1");
		//driver.findElement(By.xpath("//*[@value='Go!']")).click();
		driver.findElement(By.cssSelector("input[value='Go!']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
}
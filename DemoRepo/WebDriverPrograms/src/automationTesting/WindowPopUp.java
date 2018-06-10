package automationTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
public class WindowPopUp {
	public static void main(String[] args) throws IOException{
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/ASUS/eclipse-workspace/WebDriverPrograms/src/config.properties");
		prop.load(ip);
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));

		WebDriver driver = new HtmlUnitDriver(); //Ghost driver or Headless browser
		//WebDriver driver= new ChromeDriver();
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//a[contains(text(), 'Good PopUp #1')]")).click();
		driver.findElement(By.xpath(prop.getProperty("popupxPath"))).click();
		Set<String> handler= driver.getWindowHandles();
		Iterator<String> it= handler.iterator();
		String Parentwin = it.next();
		System.out.println(Parentwin);
		
		String childWin= it.next();
		System.out.println(childWin);
		driver.switchTo().window(childWin);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(Parentwin);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(), 'Good PopUp #2')]")).click();
		System.out.println();
	}

}

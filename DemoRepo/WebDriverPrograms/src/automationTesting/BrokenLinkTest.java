package automationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import java.util.List;
import org.openqa.selenium.WebElement;
public class BrokenLinkTest {

	public static void main(String[] args) {
		HttpsURLConnection conn = null;
		try{
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("C:/Users/ASUS/workspace/WebDriverPrograms/src/config.properties");
			prop.load(fis);
			WebDriver driver = MyWebDriver.driver("chrome");
			driver.get(prop.getProperty("freecrmurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.switchTo().frame("mainpanel");			
			List<WebElement> linkslist = driver.findElements(By.tagName("a"));
			linkslist.addAll(driver.findElements(By.tagName("img")));
			System.out.println(linkslist.size());
			for(WebElement link: linkslist){
				if(link.getAttribute("href")!= null && !(link.getAttribute("href").contains("javascript"))){
					//String response= BrokenLinkTest.checkConnection(link.getAttribute("href"));
					conn = (HttpsURLConnection)new URL(link.getAttribute("href")).openConnection();
					conn.connect();
					String response = conn.getResponseMessage();
					conn.disconnect();
					System.out.println(link.getAttribute("href")+ " :"+response);
				}
			}
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			conn.disconnect();
		}
	}
/*	public static String checkConnection(String link) throws Exception{
		HttpURLConnection conn = (HttpsURLConnection)new URL(link).openConnection();
		conn.connect();
		String httpsResponse = conn.getResponseMessage();
		conn.disconnect();
		return httpsResponse;
	}*/

}

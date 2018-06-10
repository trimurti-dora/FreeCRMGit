package automationTesting;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
public class automateToolsQA {

	public static void main(String[] args) {
		try{
			//System.setProperty("webdriver.gecko.driver","C:/Users/ASUS/webdrivers/geckodriver.exe");
			System.setProperty("webdriver.chrome.driver","C:/Users/ASUS/webdrivers/chromedriver.exe");
			//WebDriver driver = new FirefoxDriver();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			WebDriverWait myWaitVar = new WebDriverWait(driver, 20);
			myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']")));
			
			//driver.findElement(By.xpath("//*[@id='email']")).sendKeys("trimurti1992@gmail.com");
			//driver.findElement(By.className("inputtext")).sendKeys("trimurti1992@gmail.com");
			List<WebElement> userName = driver.findElements(By.tagName("input"));

			for(WebElement email: userName){
				if(email.getAttribute("id").equals("email")){
					email.sendKeys("trimurti1992@gmail.com");
				}
			}
			List<WebElement> gender = driver.findElements(By.tagName("label"));

			for(WebElement sex: gender){
				if(sex.getText().equals("Male")){
					sex.click();
				}
			}
/*			WebElement pwd = driver.findElement(By.cssSelector("input#pass.inputtext"));
			Actions builder = new Actions(driver);
			Action mousehover = builder.moveToElement(pwd).sendKeys(pwd, "Ptd@2014").doubleClick(pwd).contextClick().contextClick().build();
			mousehover.perform();*/
			//driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Ptd@2014");
			//driver.findElement(By.cssSelector("input#pass.inputtext")).sendKeys("Ptd@2014");
			
			WebElement Oriya = driver.findElement(By.partialLinkText("ଓଡ଼ି"));
			System.out.println(Oriya.getText());
			if(Oriya.getText().equals("ଓଡ଼ିଆ")){
				System.out.println("Test Passed");
			}
			
			//Oriya.click();
			//driver.navigate().back();
			//driver.get(driver.getCurrentUrl());
			
			//WebElement login= driver.findElement(By.xpath("//*[@id='loginbutton']"));
/*			WebElement gender = driver.findElement(By.)
			if(!driver.)*/
			if(driver.getTitle().equals("Facebook – log in or sign up")){
				System.out.println("Test Passed");
				
			}
			else{
				System.out.println("Test Failed");
			}
			//login.submit();
			//driver.findElement(By.xpath("//*[@id='loginbutton']")).click();
			
			//Actions keyAction = new Actions(driver); keyAction.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
			  //String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");  
			  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
			  driver.get("https://www.google.com");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

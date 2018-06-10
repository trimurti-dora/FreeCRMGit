package automationTesting;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class newTab {
	public static void main(String[] args) {
		try{
		System.setProperty("webdriver.gecko.driver","C:/Users/ASUS/webdrivers/chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

/*		String a = "window.open('about:blank','_blank');";
		((JavascriptExecutor) driver).executeScript(a);*/
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		//robot.createScreenCapture(Rectangle.OUT_TOP);
		driver.get("https://facebook.com");
		TakesScreenshot take= (TakesScreenshot)driver;
		File source =take.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshots/google.png"));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

}
}
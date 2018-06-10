package automationTesting;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolQATest {
	public WebDriver driver;
	@FindBy(xpath="//span[text()='Tutorial']")
	WebElement tutorial;
	
	@FindBy(xpath="//span[text()='Web Automation Tools']")
	WebElement webAutomation;
	
	@FindBy(xpath="//span[text()='Selenium in Java']")
	WebElement selenium;
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
		driver = MyWebDriver.driver("chrome");
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.toolsqa.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
	}
	
	@Test
	public void openSeleniumTutorial() throws InterruptedException {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		Actions action = new Actions(driver);
		action.moveToElement(tutorial).build().perform();;
		Thread.sleep(2000);
		action.moveToElement(webAutomation).build().perform();
		Thread.sleep(2000);
		action.moveToElement(selenium).click().build().perform();
		//wait.until(ExpectedConditions.visibilityOf(
	}
}

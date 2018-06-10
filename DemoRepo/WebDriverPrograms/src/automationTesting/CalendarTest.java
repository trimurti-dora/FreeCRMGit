package automationTesting;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalendarTest {

	public static void main(String[] args) {
		String Date= "18-October-2019";
		try{
			WebDriver driver= MyWebDriver.driver("chrome");
			driver.get("https://www.freecrm.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("naveenk");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@123");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.switchTo().frame("mainpanel");
			Actions menu = new Actions(driver);
			menu.moveToElement(driver.findElement(By.xpath("//*[contains(@title, 'Calendar')]"))).click().build().perform();
/*			Thread.sleep(1000);
			menu.moveToElement(driver.findElement(By.xpath("//*[contains(@title, 'Today')]"))).click().build().perform();*/
			String date1[]= Date.split("-");
			//System.out.println(date1[0]+" "+date1[1]+" "+date1[2]);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
/*			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainpanel");*/
			Thread.sleep(3000);
			Select month = new Select(driver.findElement(By.name("slctMonth")));
			month.selectByVisibleText(date1[1]);
			Thread.sleep(3000);
			Select year = new Select(driver.findElement(By.xpath("//*[contains(@name, 'Year')]")));
			year.selectByVisibleText(date1[2]);
			Thread.sleep(3000);
			////*[contains(@name, 'Year')]//following::table//tr[2]/td[3]
			String xpathBefore = "//*[contains(@name, 'Year')]//following::table//tr[";
			String xpathAfter = "]/td[";
			boolean flag=false;
			for(int row=1; row<=7; row++){
				for(int col=1; col<=6;col++){
					WebElement day=driver.findElement(By.xpath(xpathBefore+row+xpathAfter+col+"]"));
					if(date1[0].equals(day.getText())){
						day.click();
						flag=true;
						break;
					}
				}
				if(flag){
					break;
				}
			}
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}

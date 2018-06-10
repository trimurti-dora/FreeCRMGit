package automationTesting;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstWebDriverProgram {

	public static void main(String[] args) {
		
	try{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\workspace\\WebDriverPrograms\\drivers\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Downloads\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ASUS\\Downloads\\drivers\\geckodriver.exe");
		//Create a new Instance of a ChromeDriver
		WebDriver driver = new FirefoxDriver();
		//Launch Facebook
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		//Display a message for successful opening
		System.out.println("Facbook is launched successfully");
		//Wait for 3 Sec
		//Thread.sleep(3000);
		//close the Driver.
		driver.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}

	}

}

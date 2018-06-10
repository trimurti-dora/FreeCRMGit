package apachePOITest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.TestUtil.ExcelUtil;
import automationTesting.MyWebDriver;

public class FacebookLogin {
	public static WebDriver driver;
	public static void main(String[] args) {
		try {
			String excelPath= "C:\\Users\\ASUS\\eclipse-workspace\\WebDriverPrograms\\src\\\\FacebookLoginData.xlsx";
			String sheetName= "Login";
			ExcelUtil excel = new ExcelUtil();
			Object[][] obj= excel.getExcelData(excelPath, sheetName);
			System.out.println(obj.length);
			for(int i=1; i<obj.length ; i++) {
				driver= MyWebDriver.driver("chrome");
				driver.get("https://www.facebook.com/");
				//for(int j=1; j<=obj.length; j++) {
					driver.findElement(By.xpath("//*[@name='email']")).sendKeys(obj[i][1].toString());
					driver.findElement(By.xpath("//*[@name='pass']")).sendKeys(obj[i][2].toString());
				//}
				Thread.sleep(2000);
				driver.close();
			}		
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			try {
				//fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

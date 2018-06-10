package apachePOITest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadExcelTest {

	public static void main(String[] args) throws IOException {
		//File file = new File("C:\\Users\\ASUS\\eclipse-workspace\\WebDriverPrograms\\src\\TestData.xlsx");
		FileInputStream fis = new FileInputStream("C:\\Users\\ASUS\\eclipse-workspace\\WebDriverPrograms\\src\\TestData.xlsx");
		Workbook myExcel = new XSSFWorkbook(fis);
		Sheet mySheet = myExcel.getSheet("Login");
		int rowCount= mySheet.getLastRowNum();
		Row row = mySheet.getRow(0);
		for(int i=0; i<=rowCount; i++) {
			row = mySheet.getRow(i);
			int colCount = row.getLastCellNum();
			for (int j=0; j< colCount ; j++) {
				System.out.print(row.getCell(j).getStringCellValue()+"|| ");
			}
	        System.out.println();
		}
		row = mySheet.getRow(1);
		Row newRow = mySheet.createRow(rowCount+1);
		for (int j=0; j<row.getLastCellNum(); j++) {
			newRow.createCell(j).setCellValue(row.getCell(j).getStringCellValue());
		}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\ASUS\\eclipse-workspace\\WebDriverPrograms\\src\\TestData.xlsx");
		myExcel.write(fos);
		fis.close();
		fos.close();
	}

}

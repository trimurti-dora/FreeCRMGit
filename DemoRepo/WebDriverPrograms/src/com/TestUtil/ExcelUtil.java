package com.TestUtil;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static FileInputStream fis;
	public static XSSFWorkbook myExcel;
	public static XSSFSheet mySheet;

	
	public static Object[][] getExcelData(String path, String sheetName) throws Exception{
		FileInputStream fis = new FileInputStream(path);
		Workbook myExcel = new XSSFWorkbook(fis);
		Sheet mySheet = myExcel.getSheet(sheetName);
		int rowCount= mySheet.getLastRowNum()+1;
		Row row = mySheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object[][] obj= new Object[rowCount][colCount];
		for(int i=1; i<rowCount; i++) {
			row = mySheet.getRow(i);
			for (int j=0; j< colCount ; j++) {
				obj[i][j]=row.getCell(j).getStringCellValue();
				System.out.print(obj[i][j]+"|| ");

			}
		}
		return obj; 
	}

}

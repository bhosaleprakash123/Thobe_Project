package Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sh1;
	
	//Utility.ExcelDataConfig excel=new Utility.ExcelDataConfig("path");
	public ExcelDataConfig(String excelPath)
	{
		try {
			File excel = new File(excelPath);
			FileInputStream fis = new FileInputStream(excel);
			 wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
	public String getData(String sheetname,int row,int column)
	{
		sh1 = wb.getSheet(sheetname);
		String data= sh1.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	
}

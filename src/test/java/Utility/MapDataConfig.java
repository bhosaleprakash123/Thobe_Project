package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MapDataConfig {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh1;
	public static Map<Object, Object> mapData;
	public Object[][] arr;
	public static Map<Object, Object> getMapData(){
		try {
			 mapData=new LinkedHashMap<Object, Object>();
			String excelPath="E://Ezzar_Login.xlsx";
			File excel = new File(excelPath);
			FileInputStream fis = new FileInputStream(excel);
			 wb = new XSSFWorkbook(fis);
			 sh1 = wb.getSheet("Sheet1");
			 int lastRowNum = sh1.getLastRowNum() ;
			 int lastCellNum = sh1.getRow(0).getLastCellNum();
			
			 for(int i=0;i<=lastRowNum;i++) {
				
				 Row row=sh1.getRow(i);
				Cell keyCell= row.getCell(0);
				String key=keyCell.getStringCellValue().trim();
				Cell valCell=row.getCell(1);
				String value=valCell.getStringCellValue().trim();
				mapData.put(key, value);
				
			 }
			 
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return mapData;
		
	}
	@Test()
	public void integrationTest() {
		System.out.println("-------------Test case started ----------------");
		Map<Object,Object> testdata=getMapData();
		//Map<Object,Object> testDataInMap=ExcelUtility.getMapData();
		
		
		Object[][] arr = new Object[mapData.size()][2];
		arr[0][0] = mapData;
		// get an array of keys of the `HashMap`
		String[] key = testdata.keySet().toArray(new String[2]);
		System.out.println(Arrays.toString(key));
		// get an array of values of the `HashMap`
        String[] value = testdata.values().toArray(new String[2]);
        System.out.println(Arrays.toString(value));
       
        System.out.println(testdata.get(0));
		System.out.println(testdata.get(0));
		System.out.println(testdata.get(0));
		 System.out.println("-------------Test case Ended ----------------");
	}
	


}

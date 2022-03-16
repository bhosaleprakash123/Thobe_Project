package TestCase;

import java.util.List;

import javax.xml.crypto.Data;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import Rest_Utitls.ExcelDataConfig;
import com.relevantcodes.extentreports.LogStatus;

import Pages.CreateApp_POM;
import Pages.Sign_POM;
import Utility.CustomListener;

public class CreateAPP extends SignIn {
	@Test(priority=1)
	public void create_page() throws Exception{
			String exReport = "D:/Extent/Thobe_Report/Report1.html";
			// extentReports=new ExtentReports(exReport,true);
			extentTest = extentReports.startTest("Dealertrack Create Application Page");
			extentTest.log(LogStatus.INFO, "CreateApplication_Page is Running");
			extentTest.log(LogStatus.PASS, "DealerTrack Application Create_Page Lunch");
			Thread.sleep(3000);
			Actions actions=new Actions(driver);
			actions.moveToElement(CreateApp_POM.createLink(driver)).build().perform();
			Actions actions2=new Actions(driver);
			actions2.moveToElement(CreateApp_POM.Click_createBtn(driver)).click().build().perform();
	}
	@Test(priority=2)
	public void search_Cust()
	{
		CreateApp_POM.first_Name(driver).sendKeys("TestAPP");
		CreateApp_POM.last_Name(driver).sendKeys("TestDemoAPP");
		CreateApp_POM.dateOfBirth(driver).sendKeys("04/07/2019");
		Select select=new Select(CreateApp_POM.phone_type(driver));
		select.selectByVisibleText("Home");
		CreateApp_POM.phoneNumber(driver).sendKeys("7125462244");
		CreateApp_POM.socialNumber(driver).sendKeys("7123");
		CreateApp_POM.findCust(driver).click();
		CustomListener.waitForPageLoaded();
	}
	@Test(priority=3)
	public void credit_Application()
	{
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("window.scrollBy(0,100)");
	// Find the checkbox or radio button element by its name.
	List<WebElement> list=CreateApp_POM.selectVeh(driver);
	// Get the number of checkboxes available.
	int count=list.size();
	System.out.println(count);
       
	// Create a boolean variable which will hold the value (True/False)
	 boolean bValue = false;
	 
	 // This statement will return True, in case of first Radio button is selected
	 bValue = list.get(0).isSelected();
	 
	 // This will check that if the bValue is True means if the first radio button is selected
	 if(bValue == true){
	 // This will select Second radio button, if the first radio button is selected by default
	 list.get(1).click();
	 }else{
	 // If the first radio button is not selected by default, the first will be selected
	 list.get(0).click();
	 }
	 List<WebElement> list1=CreateApp_POM.select_Suffix(driver);
	 int iSize=list1.size();
	 for(int i=0; i<iSize;i++){
		 String sVal=list1.get(i).getAttribute("value");
		 if(sVal.equalsIgnoreCase("JR")){
			 list1.get(i).click();
		 }
	 }
	Utility.ExcelDataConfig excel = new Utility.ExcelDataConfig("D:\\Project\\Ezzar_Login.xlsx");
	CreateApp_POM.address1(driver).sendKeys(excel.getData("Sheet1", 2, 1));
	CreateApp_POM.zip(driver).sendKeys(excel.getNumData("Sheet1", 3, 1));
	Select select=new Select(CreateApp_POM.city_State(driver));
	select.selectByVisibleText(excel.getData("Sheet1", 4, 1));
	//CreateApp_POM.ssn(driver).sendKeys(excel.getData("Sheet1", 4, 1));
	
	 
	}
}

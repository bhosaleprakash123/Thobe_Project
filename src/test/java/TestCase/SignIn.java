package TestCase;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BasePackage.BaseClass;
import Pages.Sign_POM;
import Utility.CustomListener;

public class SignIn extends BaseClass{
	

	

	@Test(priority = 0)
	public void login_Page() throws Exception {
		
		extentTest = extentReports.startTest("Orange HRM Login Page  Application");
		extentTest.log(LogStatus.INFO, "Login_Page is Running");
		extentTest.log(LogStatus.PASS, "Orange HRM Application Login_Page Lunch");
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,100)");
		
		Sign_POM.userName(driver).sendKeys(excel.getData("Sheet1", 0, 1));
		Sign_POM.Password(driver).sendKeys(excel.getData("Sheet1", 1, 1));
		Sign_POM.click_Login(driver).click();
		CustomListener.waitForPageLoaded();
		
		extentTest = extentReports.startTest("Orange HRM Home Page  Application");
		extentTest.log(LogStatus.INFO, "Home Page is Running");
		extentTest.log(LogStatus.PASS, "Orange HRM Application Home Page Lunch");
		String Exp_Title="OrangeHRM";
		String Act_Title=driver.getTitle();
		if(Act_Title.equals(Exp_Title)) {
			extentTest.log(LogStatus.PASS, "Orange HRM Application Home Page Title");
		}
		else {
			extentTest.log(LogStatus.FAIL, "Orange HRM Application Home Page Not Title Matched");
		}
		
		
	}
	
	

	
}

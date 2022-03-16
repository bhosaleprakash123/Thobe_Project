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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BasePackage.BaseClass;
import Pages.Sign_POM;
import Rest_Utitls.ExcelDataConfig;
import Utility.CustomListener;

public class SignIn {
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentHtmlReporter reporter;
	public static WebDriver driver;
	public ExcelDataConfig excel;

	@BeforeTest
	public void openBrowser() throws Exception {
		String exReport = "D:/Extent/Thobe_Report/Report1.html";
		extentReports = new ExtentReports(exReport, true);
		extentTest = extentReports.startTest("Landing Page for DealerTrack Application");
		//extentTest=extentReports.startTest("captureScreenShot");
		
		extentTest.log(LogStatus.INFO, "Chrome Browser is Statrted");
		System.out.println("Browser is Open");
		System.out.println("Chrome Browser is Open");
		driver = BaseClass.set_browser();
		driver.get(BaseClass.url);
		driver.manage().window().maximize();
		extentTest.log(LogStatus.INFO, "DealerTrack Application is Running");
		extentTest.log(LogStatus.PASS, "DealerTrack Application Lunch");
		System.out.println("Launched URL");
		CustomListener.waitForPageLoaded();
	}

	@Test(priority = 0)
	public void login_Page() throws Exception {
		String exReport = "D:/Extent/Thobe_Report/Report1.html";
		// extentReports=new ExtentReports(exReport,true);
		extentTest = extentReports.startTest("Dealertrack Login Page for DealerTrack Application");
		extentTest.log(LogStatus.INFO, "Login_Page is Running");
		extentTest.log(LogStatus.PASS, "DealerTrack Application Login_Page Lunch");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,100)");
		Utility.ExcelDataConfig excel = new Utility.ExcelDataConfig("D:\\Project\\Ezzar_Login.xlsx");
		Sign_POM.userName(driver).sendKeys(excel.getData("Sheet1", 0, 1));
		Sign_POM.Password(driver).sendKeys(excel.getData("Sheet1", 1, 1));
		// Sign_POM.userName(driver).sendKeys("ravineosoftqa@gmail.com");
		// Sign_POM.Password(driver).sendKeys("admin@123");
		Sign_POM.click_Login(driver).click();
		CustomListener.waitForPageLoaded();
		Sign_POM.click_SwitchClassic(driver).click();
		Thread.sleep(3000);
		driver.switchTo().frame("iFrm");
		driver.switchTo().frame("nav");
		Sign_POM.click_Switch(driver).click();
		driver.switchTo().defaultContent();
        driver.switchTo().frame("iFrm");      //This the Second Frame
        driver.switchTo().frame("main");
		Sign_POM.enter_Switch(driver).sendKeys("100100");
		Sign_POM.click_SwitchButtons(driver).click();
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotpath = CustomListener.captureScreenShot(driver, "FailScreenshotForExtentReport");
			extentTest.log(LogStatus.FAIL, result.getThrowable().getMessage());
			extentTest.log(LogStatus.FAIL, "ScreenShot Below: " + extentTest.addScreenCapture(screenshotpath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String screenshotpath1 = CustomListener.captureScreenShot(driver, "PassScreenshotForExtentReport");
			// extentTest.log(LogStatus.PASS, result.getThrowable());
			extentTest.log(LogStatus.PASS, "ScreenShotForSuccuse: " + extentTest.addScreenCapture(screenshotpath1));

		}
		extentReports.endTest(extentTest);
	}

	@AfterSuite
	public static void afterSuit() {
		extentTest.log(LogStatus.PASS, "Browser Closed Succusfully");
		extentReports.flush();
		//driver.close();
		// extentreport.close();
	}

}

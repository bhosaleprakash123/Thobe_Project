package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.CustomListener;

public class BaseClass {
	public static WebDriver driver;
	public static String url="";
	public static String browser="";
	public static String wait="";
	public static String Path="";
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentHtmlReporter reporter;
	
	public Utility.ExcelDataConfig excel;
	
	@BeforeTest 
	public void Pre_Report() {
		String exReport = System.getProperty("user.dir") + "/Report/"+"Reports.html";
		extentReports = new ExtentReports(exReport, true);
		excel = new Utility.ExcelDataConfig("D:\\Extent\\Ezzar_Login.xlsx");
		
	}
	@BeforeMethod
	public static void openBrowser() throws Exception {
		
		//extentTest=extentReports.startTest("captureScreenShot");
		extentTest = extentReports.startTest("Landing Page for Orange HRM");
		extentTest.log(LogStatus.INFO, "Chrome Browser is Statrted");
		
		driver = BaseClass.set_browser();
		driver.get(BaseClass.url);
		driver.manage().window().maximize();
		extentTest.log(LogStatus.INFO, "HRM Application is Running");
		extentTest.log(LogStatus.PASS, "HRM Application Lunch");
		System.out.println("Launched URL");
		CustomListener.waitForPageLoaded();
	}
	public static WebDriver set_browser()
	{
		read_Constant();
		System.setProperty("webdriver.chrome.driver",Path);
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	public static void read_Constant()
	{
		
		try {
			FileInputStream fis=new FileInputStream("D:\\Extent\\Thobe1.properties");
			Properties pro=new Properties();
			pro.load(fis);
			url=pro.getProperty("testSiteName");
			browser=pro.getProperty("browserName");
			wait=pro.getProperty("default_implicitWait");
			Path=pro.getProperty("driver_Path");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		extentReports.flush();
	}
	@AfterSuite
	public static void afterSuit() {
		extentTest.log(LogStatus.PASS, "Browser Closed Succusfully");
		driver.close();
		// extentreport.close();
	}


}

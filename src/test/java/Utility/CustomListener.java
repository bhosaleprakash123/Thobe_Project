package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import TestCase.SignIn;

public class CustomListener extends TestListenerAdapter {
	public static WebDriver driver;
	public  void onTestFailure(ITestResult tr)
	{
		File scrFile = ((TakesScreenshot)SignIn.driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("D:\\Extent\\Fail_TCScreenShot"+tr.getName()+".png"));
			System.out.println("Succesfully Captured screenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String  captureScreenShot(WebDriver driver,String screenshotname) throws IOException
 	{
 		/*File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		FileUtils.copyFile(src,new File("D:\\Extent\\Pass_TCScreenShot\\"+System.currentTimeMillis()+".png" ));
 		return screenshotname;*/
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshot/"+screenshotname+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}
	@Test(priority=0)
	 public static void waitForPageLoaded() {
      ExpectedCondition<Boolean> expectation = new
              ExpectedCondition<Boolean>() {
                  public Boolean apply(WebDriver driver) {
                      return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                  }
              };
      try {
          Thread.sleep(3000);
          WebDriverWait wait = new WebDriverWait(driver, 30);
          wait.until(expectation);
      } catch (Throwable error) {
         // Assert.fail("Timeout waiting for Page Load Request to complete.");
      }
	}	
}
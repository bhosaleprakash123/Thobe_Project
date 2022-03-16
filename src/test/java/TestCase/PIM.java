package TestCase;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utility.MapDataConfig;

public class PIM extends SignIn{
  @Test
  public void pim_Test() throws InterruptedException {
	  extentTest = extentReports.startTest("Orange HRM PIM Page  Application");
		extentTest.log(LogStatus.INFO, "PIM Page is Running");
		extentTest.log(LogStatus.PASS, "Orange HRM Application PIM Page Lunch");
	  Thread.sleep(3000);
	  WebElement element=driver.findElement(By.xpath("//*/li/a/b[text()='PIM']"));
	  Actions action=new Actions(driver);
	  action.moveToElement(element).build().perform();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*/li[2]/ul/li/a[text()='Employee List']")).click();
	  Select select=new Select(driver.findElement(By.xpath("//*[@id=\"empsearch_employee_status\"]")));
	  List<WebElement> list=select.getOptions();
	  List original_list=new ArrayList();
	  for(WebElement el:list) {
		  original_list.add(el.getText());
	  }
	  List templist = new ArrayList(original_list);
	  System.out.println("Temp List: " + templist);
	  Collections.sort(original_list);
	  System.out.println("Sorted List:" + original_list );
	  if(original_list.equals(templist)) {
          
          System.out.println("List is Sorted");
          
      }else {
          
          System.out.println("List is unsorted");
      }
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).sendKeys(MapDataConfig.key[3]);
  }
}

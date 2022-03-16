package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateApp_POM {
	public static WebDriver driver;
	public static WebElement element;
	public static List list;
	public static WebElement createLink(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[7]/a"));
		return element;
	}
	public static WebElement Click_createBtn(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[7]/ul/li[1]/a"));
		return element;
	}
	public static WebElement first_Name(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='id_first_name']"));
		return element;
	}
	public static WebElement last_Name(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='id_last_name']"));
		return element;
	}
	public static WebElement dateOfBirth(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='id_birth_date']"));
		return element;
	}
	public static WebElement phone_type(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='id_primary_phone_type']"));
		return element;
	}
	public static WebElement phoneNumber(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='id_primary_phone_number']"));
		return element;
	}
	public static WebElement socialNumber(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='id_tax_id']"));
		return element;
	}
	public static WebElement findCust(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='search-customer']/div/div/div/form/div[2]/input"));
		return element;
	}
	public static List selectVeh(WebDriver driver)
	{
		list=driver.findElements(By.xpath("//*[@id='div_id_asset_type']/div/label"));
		return list;
	}
	public static List select_Suffix(WebDriver driver)
	{
		list=driver.findElements(By.xpath("//*[@id='id_suffix_code']/option"));
		return list;
	}
	public static WebElement address1(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='id_line_1_address']"));
		return element;
	}
	public static WebElement zip(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='id_zip_code']"));
		return element;
	}
	public static WebElement ssn(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id='id_tax_id']"));
		return element;
	}
	
}

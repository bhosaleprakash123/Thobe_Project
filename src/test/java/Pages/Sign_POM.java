package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sign_POM {
	public static WebDriver driver;
	public static WebElement element;
	public static WebElement userName(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
		return element;
	}
	public static WebElement Password(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
		return element;
	}
	public static WebElement click_Login(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
		return element;
	}
	public static WebElement click_SwitchClassic(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//div[@id='branding-menu']/a"));
		return element;
	}
	public static WebElement click_Switch(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//a[@href='DTAdminCommon/Dealer/DlrSwitch/DealerSearch.aspx']"));
		return element;
	}
	public static WebElement enter_Switch(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@id='TxtSwitchDealer']"));
		return element;
	}
	public static WebElement click_SwitchButtons(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@name='BtnSwitch']"));
		return element;
	}
	
	
	
}

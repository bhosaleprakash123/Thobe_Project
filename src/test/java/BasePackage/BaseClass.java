package BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	public static String url="";
	public static String browser="";
	public static String wait="";
	public static String Path="";
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
			FileInputStream fis=new FileInputStream("D:\\Project\\Thobe1.properties");
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


}

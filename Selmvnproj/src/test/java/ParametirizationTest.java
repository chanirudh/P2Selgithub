

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ParametirizationTest {
	//changed some script not really 1
	WebDriver driver;
	@Test
	public void exforparam() throws MalformedURLException{
		ExcelRead oExcel=new ExcelRead("C:\\Users\\Srinu\\Documents\\ebaysrchvalues.xls","Searchvalues");
		//System.setProperty("webdriver.gecko.driver", "D://geckodriver.exe");
		//driver=new FirefoxDriver();
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("Chrome");
		cap.setVersion("58.0");
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.158:4444/wd/hub"),cap);
		
		for(int i=1;i<oExcel.rowCount();i++)
		{
			driver.get("http://www.ebay.com");
			driver.findElement(By.id("gh-ac")).clear();
			driver.findElement(By.id("gh-ac")).sendKeys(oExcel.getCellData("Searchfor", i));
			driver.findElement(By.id("gh-btn")).click();
			driver.findElement(By.linkText("Advanced")).click();

		}
		driver.quit();		
	}

}

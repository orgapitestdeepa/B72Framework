package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base{
	
	public static final String default_url="https://demo.actitime.com/login.do";
	public static final String default_browser="chrome";
	public static final String default_grid="no";
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Parameters({"browser","url","grid"})
	@BeforeMethod
	public void setPreconditions(@Optional(default_url) String browser, @Optional(default_url)String url,@Optional(default_grid) String grid) throws MalformedURLException
	{
		if(grid.equalsIgnoreCase("no"))
		{
			Reporter.log("on local",true);
			if(browser.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
				Reporter.log("Opening chrome browser",true);
				}
		else
		{
			driver=new FirefoxDriver();
			Reporter.log("Opening firefox browser",true);
		}
			}
		
		else
		{
		  if(browser.equalsIgnoreCase("chrome"))
				  {
			       driver = new RemoteWebDriver(new URL(grid),new ChromeOptions());
				  }
		  else {
	       driver = new RemoteWebDriver(new URL(grid),new FirefoxOptions());
		  }
		}
		
		driver.get(default_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void setPostConditions()
	{
		driver.quit();
	}

}

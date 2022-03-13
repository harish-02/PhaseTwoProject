package com.swiggy.stepdefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.swiggy.reports.ExtentTestImp;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
public static WebDriver driver;
public static ExtentTest extenObj;

	@Before
	public void intilazeVarExtent(Scenario secnario) {
		String secnarioName= secnario.getName();
		extenObj = ExtentTestImp.getReporter().startTest(secnarioName);
	}
	
	@Before
	public WebDriver intilaizeDriver() throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("/home/appusharishgmai/eclipse-workspace/Swiggy/src/main/resources/Config.properties");
		properties.load(fis);
		String browserName =properties.getProperty("browser");
		System.out.println("test case is running on "+browserName+ "browser");
		
		if(browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver","/home/appusharishgmai/eclipse-workspace/Swiggy/Driver/chromedriver.exe" );
			 driver = new ChromeDriver(); 
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			
		}
		else if(browserName.equals("internetexplore")) {
//			System.setProperty("webdriver.ie.driver", "/home/appusharishgmai/eclipse-workspace/Swiggy/Driver/IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			
		}
		else if(browserName.equals("firefox")){
//			System.setProperty("webdriver.gecko.driver", "/home/appusharishgmai/eclipse-workspace/Swiggy/Driver/geckodriver.exe");
			 driver = new FirefoxDriver();
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			
		}
		
		else if (browserName.equals("RcBrowser")) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("http://192.168.0.115:4444/wd/hub"),dc);
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;		
		
		}
		@After
		public WebDriver quitDriver() {
			
			driver.quit();
			return driver;
	}
		
		@After
		public void endExtentRep(Scenario secnario) {
			
			if(secnario.isFailed()) {
				Hooks.extenObj.log(LogStatus.FAIL, "Test Case Failed");
			}
			ExtentTestImp.getReporter().endTest(extenObj);
		}


}

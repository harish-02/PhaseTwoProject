package com.swiggy.runnerfiles;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.swiggy.reports.ExtentTestImp;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "/home/appusharishgmai/eclipse-workspace/Swiggy/src/test/resources/Features",
        glue = "com.swiggy.stepdefination",
       // tags = "@SanityTest",
        plugin = {"pretty","html:target/cucumber-report.html",
        				 "json:target/cucumber-reports/Cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	@BeforeSuite
	public void extentreportStart() {
		//String pathofProj = System.getProperty("user.dir");
		ExtentTestImp.setReporter("/home/appusharishgmai/eclipse-workspace/Swiggy/extenReport.html");
	}
	
	
	@AfterSuite
	public void extentreportflush() {
		ExtentTestImp.getReporter().flush();
		
	}
	
	@DataProvider
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
        
        	
        
    }
}

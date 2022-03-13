package com.swiggy.reports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentTestImp {
	
	static ExtentReports extReoObj = null;
	
	public static ExtentReports setReporter(String path) {
		if(extReoObj==null) {
			extReoObj= new ExtentReports(path);
		}
		return extReoObj;
	}
	public static ExtentReports getReporter() {
		
		return extReoObj;
	}

}

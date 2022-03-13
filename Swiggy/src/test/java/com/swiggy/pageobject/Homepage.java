package com.swiggy.pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swiggy.excelutilies.ExcelOperation;

public class Homepage {
	public Homepage(String path) {
		super();
		this.path = path;
	}

	WebDriver driverHp;
	public String path = "/home/appusharishgmai/eclipse-workspace/Swiggy/src/test/resources/Excelsheet/SwiggyData.xlsx";

	ExcelOperation excelOpration = new ExcelOperation(path);

	public Homepage(WebDriver driver) {
		this.driverHp = driver;
		PageFactory.initElements(driver, this);
	}

	public String getUrl() throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(
				"/home/appusharishgmai/eclipse-workspace/Swiggy/src/main/resources/Config.properties");
		properties.load(fis);
		String url = properties.getProperty("url");
		driverHp.get(url);
		return url;
	}

	@FindBy(xpath = "//div/a[contains(text(),'Sign up')]")
	WebElement signinButton;

	@FindBy(xpath = "//input[@id='mobile']")
	WebElement phoneNumber;

	@FindBy(xpath = "//div/a[contains(text(),'Login')]")
	WebElement logintitle;

	@FindBy(xpath = "//*[@id=\"mobile\"]")
	WebElement loginButton;
	
	@FindBy(xpath = "//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/form/div[2]/a")
	WebElement continueBtn;

	@FindBy(xpath = "//*[@id=\"otp\"]")
	WebElement enterOTP;
	
	@FindBy(xpath = "//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/div[1]/div[1]")
	WebElement signup_popup_title_text;

	public void signInButon() {
		signinButton.click();
	}
	
	public void loginBtn() {
		logintitle.click();
	}

	public void phoneNumber_reg() throws Throwable {
		String phNumber = excelOpration.getCellData("phoneNumber", 1, 0);
		phoneNumber.sendKeys(phNumber);
		Thread.sleep(1000);
	}

	public void phoneNumber_unreg() throws Throwable {
		String phNumber = excelOpration.getCellData("phoneNumber", 2, 0);
		phoneNumber.sendKeys(phNumber);
		Thread.sleep(1000);
	}

	public String logintitle() {
		String title = logintitle.getText();
		return title;
	}

	public String enterOPTmessage() {
		String title = enterOTP.getText();
		return title;
	}
	
	public String signup_popup_title() {
		String title = signup_popup_title_text.getText();
		return title;
	}

	public void loginButton() {
		WebElement ele = driverHp.findElement(By.xpath("//*[@id=\"mobile\"]"));
		JavascriptExecutor executor = (JavascriptExecutor) driverHp;
		executor.executeScript("arguments[0].click();", ele);
		
		continueBtn.click();
	}

	public String pagetitle() {
		String title = driverHp.getTitle();
		return title;
	}

}

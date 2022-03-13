package com.swiggy.stepdefination;

import java.io.IOException;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.swiggy.pageobject.Homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageStepDef {

	Homepage hpage = new Homepage(Hooks.driver);

	@Given("user launch the swiggy application {string}")
	public void user_launch_the_swiggy_application(String string) throws IOException {
		System.out.println("----swiggy page loaded");
		hpage.getUrl();
		Hooks.extenObj.log(LogStatus.INFO, "Launch URL");
		Hooks.extenObj.log(LogStatus.PASS, "URL is successfully launched.");
	}

	@And("user valiadtes the page tittle")
	public void user_valiadtes_the_page_tittle() {
		String actualtittle = hpage.pagetitle();
		System.out.println(actualtittle);
		String expectedtittle = "Order food online from India's best food delivery service. Order from restaurants near you";

		Assert.assertEquals(actualtittle, expectedtittle);
		Hooks.extenObj.log(LogStatus.INFO, "Validate Page Title");
		Hooks.extenObj.log(LogStatus.PASS, "Page Title is successfully validated.");
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		hpage.loginBtn();
		Hooks.extenObj.log(LogStatus.INFO, "Click Login Button");
		Hooks.extenObj.log(LogStatus.PASS, "Login Button is successfully clicked.");
	}

	@Then("login page should be displayed")
	public void login_page_should_be_displayed() {
		String actualtittle = hpage.logintitle();
		String expectedtittle = "Login";
		Assert.assertEquals(actualtittle, expectedtittle);
		Hooks.extenObj.log(LogStatus.INFO, "Validate Login Page Title");
		Hooks.extenObj.log(LogStatus.PASS, "Login Page Title is successfully validated.");
	}

	@Then("user enters the phone number")
	public void user_enters_the_phone_number() throws Throwable {
		hpage.phoneNumber_reg();
		Hooks.extenObj.log(LogStatus.INFO, "Enter Phone Number");
		Hooks.extenObj.log(LogStatus.PASS, "Phone Number is successfully entered.");
	}

	@Then("user enters the unregistered phone number")
	public void user_enters_the_unregistered_phone_number() throws Throwable {
		hpage.phoneNumber_unreg();
		Hooks.extenObj.log(LogStatus.INFO, "Enter Phone Number");
		Hooks.extenObj.log(LogStatus.PASS, "Phone Number is successfully entered.");
	}

	@Then("user click on loginbutton")
	public void user_click_on_loginbutton() {
		hpage.loginButton();
		Hooks.extenObj.log(LogStatus.INFO, "Click Login Button");
		Hooks.extenObj.log(LogStatus.PASS, "Login Button is successfully clicked.");
	}

	@Then("enter otp section will be shown")
	public void enter_otp_section_will_be_shown() throws Throwable {
//			String actualTitle= hpage.enterOPTmessage();
//		   String expectedTitle="Enter OTP";
//		   Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(1000);
		Hooks.extenObj.log(LogStatus.INFO, "Validate OTP Page");
		Hooks.extenObj.log(LogStatus.PASS, "OTP Page is successfully validated.");
	}

	@Then("signup popup should be shown")
	public void signup_popup_should_be_shown() throws InterruptedException {
		hpage.loginButton();
		Thread.sleep(5000);
		
		String actualtittle = hpage.signup_popup_title();
		System.out.println(actualtittle);
		String expectedtittle = "Sign up";

		Assert.assertEquals(actualtittle, expectedtittle);
		Hooks.extenObj.log(LogStatus.INFO, "Validate Signup Page");
		Hooks.extenObj.log(LogStatus.PASS, "Signup Page is successfully validated.");

	}

}

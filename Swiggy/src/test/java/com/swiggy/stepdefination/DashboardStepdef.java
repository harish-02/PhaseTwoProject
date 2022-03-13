package com.swiggy.stepdefination;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.swiggy.pageobject.DashBoard;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class DashboardStepdef {
	
	DashBoard sDashboard = new DashBoard(Hooks.driver);
	public static Logger log= LogManager.getLogger(DashboardStepdef.class.getName());
	
	@Then("user click on login button")
	public void user_click_on_login_button() {
		sDashboard.click_login_Button();
		Hooks.extenObj.log(LogStatus.INFO, "clicked on login button");
		Hooks.extenObj.log(LogStatus.PASS, "Sucessfully clicked on login button");
	}
	
	@Then("user click on signUp button")
	public void user_click_on_sign_up_button() {
		
	    sDashboard.click_singUp_button();
	    Hooks.extenObj.log(LogStatus.INFO, "clicked on signup button");
		Hooks.extenObj.log(LogStatus.PASS, "Sucessfully clicked on signup button");
	}

	@And("signup should be displayed")
	public void signup_should_be_displayed() {
		String actualtittle =   sDashboard.signUp_tittle();
		System.out.println(actualtittle);
		 String expectedtittle = "Sign up";
		 
		 Assert.assertEquals(actualtittle, expectedtittle);
		 Hooks.extenObj.log(LogStatus.INFO, "validate page tittle");
		 Hooks.extenObj.log(LogStatus.PASS, "page tittle validated Sucessfully");
	   
	}
	
	@Then("user click on findFood button")
	public void user_click_on_find_food_button() {
	    sDashboard.click_findFood_button();
	    Hooks.extenObj.log(LogStatus.INFO, "clicked on findfood button");
		Hooks.extenObj.log(LogStatus.PASS, "Sucessfully clicked on findfood button");
	}

	@Then("and user validate the meassage for deleviery location")
	public void and_user_validate_the_meassage_for_deleviery_location() {
	    String ActualText = sDashboard.bodytext();
	    System.out.println(ActualText);
	    Assert.assertEquals(ActualText.contains("Enter your delivery location"),true);
	    Hooks.extenObj.log(LogStatus.INFO, "validate deleviery message");
		Hooks.extenObj.log(LogStatus.PASS, "Sucessfully validated delevery message");
	}
	
	@When("user click on locateMe button")
	public void user_click_on_locate_me_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    sDashboard.click_locateMe_button();
	    Thread.sleep(5000);
	    Hooks.extenObj.log(LogStatus.INFO, "clicked on locateMe button");
		Hooks.extenObj.log(LogStatus.PASS, "Sucessfully clicked on locateMe button");
	}	


}

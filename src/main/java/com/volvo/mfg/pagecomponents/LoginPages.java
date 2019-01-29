package com.volvo.mfg.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.volvo.mfg.commonutilis.CommonWrapperMethods;

public class LoginPages extends CommonWrapperMethods {
	private WebDriver driver;

	
	public LoginPages(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Login into MUMSWeb System-Login_Reg_TC1
	 */
	public void LogintoMUMSWEB(String uName,String pWord,String eValue) throws InterruptedException {
		
		
		//anyClick("Go to MUMSWEB Home Page", By.xpath(prop.getProperty("Loginpage.User.MUMSWEB.Home.Page.Link")));
		sendKeys("UserName", By.xpath(prop.getProperty("LoginPage.User.Name")), uName);
		sendKeysPassword("Password", By.xpath(prop.getProperty("LoginPage.User.Password")), pWord);
		anyClick("Submit", By.xpath(prop.getProperty("LoginPage.Login.Button")));
		reportStep("#B Verified the functionality of logging into MUMSWeb application #C", "pass", false);
		
			// Verify Page displayed
			verifyPageTitle(eValue);
	}
}
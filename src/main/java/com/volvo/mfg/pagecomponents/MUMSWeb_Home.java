package com.volvo.mfg.pagecomponents;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.volvo.mfg.commonutilis.CommonWrapperMethods;
import com.volvo.mfg.commonutilis.DB_Connectivity;
import com.volvo.mfg.commonutilis.ExcelUtils;
import com.volvo.mfg.commonutilis.QueryInput;

public class MUMSWeb_Home extends CommonWrapperMethods{
	
	private WebDriver driver;
	ExcelUtils excelUtils = new ExcelUtils();
	
	public MUMSWeb_Home(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 *Validate whether 'Home' menu displays the respective screen to User - Home_Reg_TC1 
	 */
	public void Navigate_Home_Tab() {
		
		//Clicking on home button
		anyClick("Home Button click", By.xpath(prop.getProperty("MUMSWeb.Home.Tab")));
		
	}
	
	/*
	 * Validate whether User able to view the Display details for 'TC' pant - Home_Reg_TC2
	 * Validate whether User able to view the Display details for 'TB1' pant - Home_Reg_TC3
	 * Validate whether User able to view the Display details for 'TV' pant - Home_Reg_TC4
	 */
	public void MUMSWebHome() throws InterruptedException {
		
		String winHandleBefore;
		
		//Verifying MUMSWeb home page display
		verifyElementExist("MUMSWeb home page verified", By.xpath(prop.getProperty("MUMSWeb.HomePage.verify")));
		
		//Clicking on home tab
		Navigate_Home_Tab();
		reportStep("#B 'Home' menu displayed with the respective screen to User - Home_Reg_TC1 #C", "pass", false);
		
		//Verifying Map displayed after clicking on Home button
		verifyElementExist("MUMSWeb Map page displayed after clicking on Home button", By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.Verify")));
		
		//Clicking on TC Plant in Map 
		String areaTCUrl =driver.findElement(By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.TC"))).getAttribute("href");
		driver.get(areaTCUrl);
		Thread.sleep(2000);
		//store instance of main window first using below code
		winHandleBefore = driver.getWindowHandle();
		
		//Once TC map opens, need to click on the image
		anyClick("TC Plant Map image click", By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.TC.Display.Image")));
		
		//Verifying pop-up window opens after clicking on the image button
		verifyElementExist("TC Plant Pop-up Window", By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.TC.Popup.Window")));
		
		//Clicking on the open button in the pop-up window
		anyClick("Open button click", By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.Popup.Window.Open.Button")));
		
		//Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		driver.close(); //this will close new opened window

		//switch back to main window using this code
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
		reportStep("#B Validated whether User able to view the Display details for 'TC' pant - Home_Reg_TC2 #C", "pass", false);
		
		//Clicking on home tab
		Navigate_Home_Tab();
				
		//Clicking on TB1 Plant in Map 
		String areaTB1Url =driver.findElement(By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.TB1"))).getAttribute("href");
		driver.get(areaTB1Url);
		Thread.sleep(2000);
		
		//store instance of main window first using below code
		winHandleBefore = driver.getWindowHandle();
		
		//Once TB1 map opens, need to click on the image
		anyClick("TB1 Plant Map image click", By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.TB1.Display.Image")));
				
		//Verifying pop-up window opens after clicking on the image button
		verifyElementExist("TB1 Plant Pop-up Window", By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.TB1.Popup.Window")));
				
		//Clicking on the open button in the pop-up window
		anyClick("Open button click", By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.Popup.Window.Open.Button")));
				
		//Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
				  driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		driver.close(); //this will close new opened window
		reportStep("#B Validated whether User able to view the Display details for 'TB1' pant - Home_Reg_TC3 #C", "pass", false);
		//switch back to main window using this code
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
		
		///////////////////////////////////////////////////////////////////
		/*//Clicking on home tab
		Navigate_Home_Tab();
		
		//Clicking on TV Plant in Map 
		String areaTVUrl =driver.findElement(By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.TV"))).getAttribute("href");
		driver.get(areaTVUrl);
		Thread.sleep(2000);
		
		/
		//store instance of main window first using below code
		winHandleBefore = driver.getWindowHandle();
				
		//Once TV map opens, need to click on the image
		anyClick("TV Plant Map image click", By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.TV.Display.Image")));
						
		//Verifying pop-up window opens after clicking on the image button
		verifyElementExist("TV Plant Pop-up Window", By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.TV.Popup.Window")));
						
		//Clicking on the open button in the pop-up window
		anyClick("Open button click", By.xpath(prop.getProperty("MUMSWeb.Home.Palnt.Map.Popup.Window.Open.Button")));
						
		//Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		driver.close(); //this will close new opened window

		//switch back to main window using this code
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
		reportStep("#B Validated whether User able to view the Display details for 'TV' pant - Home_Reg_TC4 #C", "pass", false);
		*/
	}
	
}

package com.volvo.mfg.pagecomponents;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.volvo.mfg.commonutilis.CommonWrapperMethods;
import com.volvo.mfg.commonutilis.ExcelUtils;

public class MUMSWEB_Display extends CommonWrapperMethods{
	
	private WebDriver driver;
	ExcelUtils excelUtils = new ExcelUtils();
	
	public MUMSWEB_Display(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 *Validate whether 'Display' menu displays the respective screen to User - Display_Reg_TC1 
	 */
	public void Navigate_Display_Tab() {
		
		//Clicking on Display button
		anyClick("Display Button click", By.xpath(prop.getProperty("MUMSWEB_Display.Tab")));
		reportStep("#B Validated whether 'Display' menu displays the respective screen to User - Display_Reg_TC1 #C", "pass", false);
	}

	/*
	 * Validate whether User able to 'Search' on specific input value - Display_Reg_TC2
	 * Validate whether User able to 'Edit' on specific entry from Search results - Display_Reg_TC4
	 */
	public void Display(String strDisplayName) {
		
		//Clicking on display tab
		Navigate_Display_Tab();
		
		//Entering value in display name textbox
		sendKeys("Display Name", By.xpath(prop.getProperty("MUMSWEB_Display.DisplayName.Textbox")), strDisplayName);
		
		//Clicking on Search button
		anyClick("Search Button click", By.xpath(prop.getProperty("MUMSWEB.Station.Search.Button")));
		reportStep("#B Validated whether User able to 'Search' on specific input value - Display_Reg_TC2 #C", "pass", false);
		
		//Selecting a row to edit
		anyClick("Selecting a row to edit", By.xpath(prop.getProperty("MUMSWEB_Display.Edit.Select.Row")));
		
		//Clicking on Edit button
		anyClick("Edit button click", By.xpath(prop.getProperty("MUMSWEB.Station.Edit.Button")));
		reportStep("#B Validated whether User able to 'Edit' on specific entry from Search results - Display_Reg_TC4 #C", "pass", false);
		
	}
	
	
	/////////////////////////////////////////////can't add due to application issue//////////////////////////////////
	/*
	* Validate whether User able to 'Add' New values to system - Display_Reg_TC3
	*/
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
}

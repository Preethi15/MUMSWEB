package com.volvo.mfg.pagecomponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.volvo.mfg.commonutilis.CommonWrapperMethods;
import com.volvo.mfg.commonutilis.ExcelUtils;

public class MUMSWEB_Station extends CommonWrapperMethods{

	
	private WebDriver driver;
	ExcelUtils excelUtils = new ExcelUtils();
	
	public MUMSWEB_Station(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Validate whether 'Station' menu displays the respective screen to User - Station_Reg_TC1
	 */
	public void Navigate_Station_Tab() {
		
		//Verifying MUMSWeb home page display
		verifyElementExist("MUMSWeb home page verified", By.xpath(prop.getProperty("MUMSWeb.HomePage.verify")));
						
		//Clicking on Station button
		anyClick("Station Button click", By.xpath(prop.getProperty("MUMSWEB.Station.Tab")));
		reportStep("#B Validated whether 'Station' menu displays the respective screen to User - Station_Reg_TC1 #C", "pass", false);
		
	}
	
	/*
	 * Validate whether User able to 'Search' on specific input value - Station_Reg_TC2
	 * Validate whether User able to 'Add' New values to system - Station_Reg_TC3
	 * Validate whether User able to 'Search into Selection' for specific input value - Station_Reg_TC6
	 * Validate the Total records to be displayed on Search results using 'Show' option - Station_Reg_TC7
	 */
	public void Station(String strStationNo,String strFactory,String strBanstation,String strSerials,String strBalance,String strPicktime,String strRedtime,String strGreentime,String strShow) throws InterruptedException {
		
		Navigate_Station_Tab();
		
		//Clicking on show drop down
		selectDropDownValue("show drop down", By.xpath(prop.getProperty("MUMSWEB.Station.Show.Dropdown")), strShow);
		reportStep("#B Validated the Total records to be displayed on Search results using 'Show' option - Station_Reg_TC7 #C", "pass", false);
		
		//Selecting Station no drop down
		selectDropDownValue("Station No Dropdown:", By.xpath(prop.getProperty("MUMSWEB.Station.StationNo.Dropdown")), strStationNo);
		
		//Selecting Factory drop down
		selectDropDownValue("Factory Dropdown:", By.xpath(prop.getProperty("MUMSWEB.Station.Factory.Dropdown")), strFactory);
		
		//Clicking on search button
		anyClick("Search button click", By.xpath(prop.getProperty("MUMSWEB.Station.Search.Button")));
		
		Thread.sleep(2000);
		reportStep("#B Validated whether User able to 'Search' on specific input value - Station_Reg_TC2 #C", "pass", false);
		
		//Clicking on add button
		anyClick("Add button click", By.xpath(prop.getProperty("MUMSWEB.Station.Add.Button")));
		
		//Selecting Station no drop down
		selectDropDownValue("Station No Dropdown:", By.xpath(prop.getProperty("MUMSWEB.Station.StationNo.Dropdown")), strStationNo);
		
		//Entering Banstation no
		sendKeys("Banstation No", By.xpath(prop.getProperty("MUMSWEB.Station.Add.BanstationNo.Textbox")), strBanstation);
		
		//Entering No of Serials 
		sendKeys("No of Serials", By.xpath(prop.getProperty("MUMSWEB.Station.Add.No.of.Serials.Textbox")), strSerials);
		
		//Entering Balance 
		sendKeys("Balance", By.xpath(prop.getProperty("MUMSWEB.Station.Add.Balance.Textbox")), strBalance);
		
		//Selecting Factory drop down
		selectDropDownValue("Factory Dropdown:", By.xpath(prop.getProperty("MUMSWEB.Station.Factory.Dropdown")), strFactory);
		
		//Entering Pick Time 
		sendKeys("Pick Time", By.xpath(prop.getProperty("MUMSWEB.Station.Add.PickTime.Textbox")), strPicktime);
		
		//Entering Red Time 
		sendKeys("Red Time", By.xpath(prop.getProperty("MUMSWEB.Station.Add.RedTime.Textbox")), strRedtime);
		
		//Entering Green Time 
		sendKeys("Green Time", By.xpath(prop.getProperty("MUMSWEB.Station.Add.GreenTime.Textbox")), strGreentime);
		Thread.sleep(2000);
		reportStep("#B Validated whether User able to 'Add' New values to system - Station_Reg_TC3 #C", "pass", false);
		
		//Entering value in Search into selection textbox
		sendKeys("Search into selection", By.xpath(prop.getProperty("MUMSWEB.Station.Search.into.Selection.Textbox")), strStationNo);
		Thread.sleep(2000);
		reportStep("#B Validated whether User able to 'Search into Selection' for specific input value - Station_Reg_TC6 #C", "pass", false);
	}
	
	/*
	 * Validate whether User able to 'Edit' on specific entry from Search results - Station_Reg_TC4
	 */
	public void Edit_Station(String strStationNo,String strFactory) {
		
		Navigate_Station_Tab();
		
		//Selecting Station no drop down
		selectDropDownValue("Station No Dropdown:", By.xpath(prop.getProperty("MUMSWEB.Station.StationNo.Dropdown")), strStationNo);
				
		//Selecting Factory drop down
		selectDropDownValue("Factory Dropdown:", By.xpath(prop.getProperty("MUMSWEB.Station.Factory.Dropdown")), strFactory);
		
		//Clicking on search button
		anyClick("Search button click", By.xpath(prop.getProperty("MUMSWEB.Station.Search.Button")));
		
		//Selecting a row to edit
		anyClick("Selecting a row to edit", By.xpath(prop.getProperty("MUMSWEB.Station.Edit.Select.Row")));
		
		//Clicking on Edit button
		anyClick("Edit button click", By.xpath(prop.getProperty("MUMSWEB.Station.Edit.Button")));
		reportStep("#B Validated whether User able to 'Edit' on specific entry from Search results - Station_Reg_TC4 #C", "pass", false);
		
	}
	
	/*
	 * Validate whether User able to 'Delete' on specific entry from Search results - Station_Reg_TC5
	 */
	public void Delete_Station(String strStationNo,String strFactory) throws InterruptedException {
		
		Navigate_Station_Tab();
		
		//Selecting Station no drop down
		selectDropDownValue("Station No Dropdown:", By.xpath(prop.getProperty("MUMSWEB.Station.StationNo.Dropdown")), strStationNo);
				
		//Selecting Factory drop down
		selectDropDownValue("Factory Dropdown:", By.xpath(prop.getProperty("MUMSWEB.Station.Factory.Dropdown")), strFactory);
		
		//Clicking on search button
		anyClick("Search button click", By.xpath(prop.getProperty("MUMSWEB.Station.Search.Button")));
		
		//Selecting a row to edit
		anyClick("Selecting a row to edit", By.xpath(prop.getProperty("MUMSWEB.Station.Edit.Select.Row")));
		
		//Clicking on Delete button
		anyClick("Delete button click", By.xpath(prop.getProperty("MUMSWEB.Station.Delete.Button")));
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		reportStep("#B Validated whether User able to 'Delete' on specific entry from Search results - Station_Reg_TC5 #C", "pass", false);
		
	}
}

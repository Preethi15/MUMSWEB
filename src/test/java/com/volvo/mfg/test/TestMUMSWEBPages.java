package com.volvo.mfg.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.volvo.mfg.commonutilis.CommonWrapperMethods;
import com.volvo.mfg.pagecomponents.LoginPages;
import com.volvo.mfg.pagecomponents.MUMSWEB_Display;
import com.volvo.mfg.pagecomponents.MUMSWEB_Station;
import com.volvo.mfg.pagecomponents.MUMSWeb_Home;
	

public class TestMUMSWEBPages extends TestBase {
	
	LoginPages loginPages;
	MUMSWeb_Home MUMSWebCases;
	MUMSWEB_Station MUMSWEBStationCases;
	MUMSWEB_Display MUMSWEBDisplayCases;

	CommonWrapperMethods commonWrapperMethods;

	
	 @Test(dataProvider="TestDataProvider")
	 
	 public void MUMSWEBHome(LinkedHashMap<String,String>testData) throws IOException, InterruptedException, SQLException
	 {	 
		   loginPages=new LoginPages(driver);
		   MUMSWebCases=new MUMSWeb_Home(driver);
		   MUMSWEBStationCases=new MUMSWEB_Station(driver);
		   MUMSWEBDisplayCases=new MUMSWEB_Display(driver);
		 
		 loginPages.LogintoMUMSWEB(testData.get("UserName"),testData.get("Password"),testData.get("Expected"));
		 //MUMSWebCases.MUMSWebHome();
		 //MUMSWEBStationCases.Station(testData.get("StationNo"),testData.get("Factory"),testData.get("BanstationNo"),testData.get("NoofSerials"),testData.get("Balance"),testData.get("PickTime"),testData.get("RedTime"),testData.get("GreenTime"),testData.get("Show"));
		 //MUMSWEBStationCases.Edit_Station(testData.get("StationNo"),testData.get("Factory"));
		 //MUMSWEBStationCases.Delete_Station(testData.get("StationNo"),testData.get("Factory"));
		 //MUMSWEBDisplayCases.Navigate_Display_Tab();
		 MUMSWEBDisplayCases.Display(testData.get("DisplayName"));
		 System.out.println("MUMSWeb launched Successfully");

		  
	      }
	
}
package com.projectexecution;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.bussinesslibraries.Functionality_TS01;
import com.genericlib.Driver;
import com.genericlib.WebDriverCommonUtilities;

public class Verify_fb_staus_Test extends Driver{
	  @BeforeSuite
	  public void lunchBrowser() throws Exception {
		  
		  String BrowserName = WebDriverCommonUtilities.getTestData("Data", 5, 0);
		  String Url = WebDriverCommonUtilities.getTestData("Data", 8, 0);
		  String PageTitle = WebDriverCommonUtilities.getTestData("Data", 5, 2);
		  
		  LunchBrowser(BrowserName, Url);
	  }

	@Test
	public void verify_fb_status_TC01() throws Exception {

		Functionality_TS01.verify_status_TC01();

	}
	  @AfterSuite
	  public void CloseBrowser() {
		WebDriverCommonUtilities.quitBrowser();
		  
	  }

}

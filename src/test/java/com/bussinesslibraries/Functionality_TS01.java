package com.bussinesslibraries;

import com.genericlib.WebDriverCommonUtilities;
import com.pageobjectmodel.HomepageLocators;

import okio.Timeout;

public class Functionality_TS01 {

	static HomepageLocators loc = new HomepageLocators();

	public static void verify_status_TC01() throws Exception{

		// Login to FB
		WebDriverCommonUtilities.performClick(loc.login);
		
		//under src/test/resources got to test data and add user name and password under the mentioned username and mentioned field.
		WebDriverCommonUtilities.enterValue(loc.login, WebDriverCommonUtilities.getTestData("Data", 11, 0));
		WebDriverCommonUtilities.performClick(loc.password);
		WebDriverCommonUtilities.enterValue(loc.password, WebDriverCommonUtilities.getTestData("Data", 11, 1));
		WebDriverCommonUtilities.performClick(loc.continue_login);
		
		WebDriverCommonUtilities.switchToAlert().accept();
		
		WebDriverCommonUtilities.waitForElement(5000, loc.not_save_pwd);
		WebDriverCommonUtilities.performClick(loc.not_save_pwd);
		
		WebDriverCommonUtilities.performClick(loc.status);
		WebDriverCommonUtilities.enterValue(loc.status, "Hello World");
		WebDriverCommonUtilities.performClick(loc.post);
		

	}
}

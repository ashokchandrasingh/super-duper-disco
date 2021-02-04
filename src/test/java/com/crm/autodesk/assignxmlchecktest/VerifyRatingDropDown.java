package com.crm.autodesk.assignxmlchecktest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Organizations;


public class VerifyRatingDropDown extends BaseClass {

	/* object Creation */
	JavaUtils jLib = new JavaUtils();
	ExcelUtility eLib = new ExcelUtility();

	@Test
	public void verifyRatingDropDownIsEnabled() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();
	
		/* test Data */
		
		String loginPageParText = eLib.getExcelData("contact", "tc_01", "loginPageParText");
		String homePageParText = eLib.getExcelData("contact", "tc_01", "homePageParText");
		String orgPageParText = eLib.getExcelData("contact", "tc_01", "orgPageParText");
		String createOrgPageParText = eLib.getExcelData("contact", "tc_01", "createOrgPageParText");

	
		Assert.assertTrue(driver.getTitle().contains(loginPageParText));

		/* step 4 : navigate to organizations page */

		hp = new Home(driver);
		hp.getOrgLnk().click();
		Assert.assertTrue(driver.getTitle().contains(homePageParText));

		/* step 5 : navigate to create organization page */

		Organizations org = new Organizations(driver);
		org.getCreateOrgImg().click();
		Assert.assertTrue(driver.getTitle().contains(orgPageParText));

		/* step 6 : create organization with rating */

		CreateNewOrganization newOrg = new CreateNewOrganization(driver);
		newOrg.verifyDropDownInCreateOrg();
		

	
	}
}

package com.crm.autodesk.assignxmlchecktest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Organizations;

public class CopyBillAddIsEnabled extends BaseClass{
	JavaUtils jLib = new JavaUtils();
	ExcelUtility eLib = new ExcelUtility();

	@Test
	public void verifycopyBillingButtonIsEnabledTest() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();

		/* test Data */
		
		String loginPageParText = eLib.getExcelData("contact", "tc_01", "loginPageParText");
		String homePageParText = eLib.getExcelData("contact", "tc_01", "homePageParText");
		String orgPageParText = eLib.getExcelData("contact", "tc_01", "orgPageParText");
				
		Assert.assertTrue(driver.getTitle().contains(loginPageParText));
		hp = new Home(driver);
		hp.getOrgLnk().click();
		Assert.assertTrue(driver.getTitle().contains(homePageParText));

		Organizations org = new Organizations(driver);
		org.getCreateOrgImg().click();
		Assert.assertTrue(driver.getTitle().contains(orgPageParText));

		CreateNewOrganization newOrg = new CreateNewOrganization(driver);
		newOrg.verifyBillRadioButtonIsEnabled();


	}
}

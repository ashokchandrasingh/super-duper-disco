package com.crm.autodesk.assignxmlchecktest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Organizations;

public class VerifyElementsInOrg extends BaseClass{
	
	@Test(groups = "regressionTest")
	public void verifyRatingDropDownIsEnabled() throws Throwable {

		String loginPageParText = eLib.getExcelData("contact", "tc_01", "loginPageParText");
		String homePageParText = eLib.getExcelData("contact", "tc_01", "homePageParText");
		String orgPageParText = eLib.getExcelData("contact", "tc_01", "orgPageParText");
		eLib.getExcelData("contact", "tc_01", "createOrgPageParText");

		Assert.assertTrue(driver.getTitle().contains(loginPageParText));
		
		hp = new Home(driver);
		hp.getOrgLnk().click();
		Assert.assertTrue(driver.getTitle().contains(homePageParText));

		Organizations org = new Organizations(driver);
		org.getCreateOrgImg().click();
		Assert.assertTrue(driver.getTitle().contains(orgPageParText));

		CreateNewOrganization newOrg = new CreateNewOrganization(driver);
		newOrg.verifyDropDownInCreateOrg();
	}
	
	@Test(groups = "smokeTest")
	public void verifyNotifyOwnerOptionEnabledTest() throws Throwable {

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
		newOrg.verifyNotifyOwnerchkBx();
	}

	@Test(groups = "regressionTest")
	public void verifycopyBillingButtonIsEnabledTest() throws Throwable {

				
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
	
	@Test(groups = "regressionTest")
	public void verifyCopyShipButtonIsEnabled() throws Throwable {

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
		newOrg.verifyShipRadioButtonIsEnabled();
	}
	

}

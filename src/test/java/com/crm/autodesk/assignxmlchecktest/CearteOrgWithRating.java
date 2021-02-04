package com.crm.autodesk.assignxmlchecktest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.OrganizationInfo;
import com.crm.autodesk.objectrrepositorylib.Organizations;

public class CearteOrgWithRating extends BaseClass {
	/* object Creation */
	JavaUtils jLib = new JavaUtils();
	ExcelUtility eLib = new ExcelUtility();

	@Test
	public void createOrgwithRatingTest() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();
		
		/* test Data */
		String orgName = eLib.getExcelData("contact", "tc_01", "OrgName") + randomNum;
		eLib.getExcelData("contact", "tc_01", "orgType");
		eLib.getExcelData("contact", "tc_01", "Industry");
		String orgRating = eLib.getExcelData("contact", "tc_01", "rating");
		eLib.getExcelData("contact", "tc_01", "loginPageParText");
		String homePageParText = eLib.getExcelData("contact", "tc_01", "homePageParText");
		String orgPageParText = eLib.getExcelData("contact", "tc_01", "orgPageParText");
		String createOrgPageParText = eLib.getExcelData("contact", "tc_01", "createOrgPageParText");
		eLib.getExcelData("contact", "tc_01", "contactName");

		
		hp = new Home(driver);
		hp.getOrgLnk().click();
		/* Assert.assertTrue(driver.getTitle().contains(homePageParText)); */
		wlib.VerifyPageTitle(driver, homePageParText);
		/* step 5 : navigate to create organization page */

		Organizations org = new Organizations(driver);
		org.getCreateOrgImg().click();
		/* Assert.assertTrue(driver.getTitle().contains(orgPageParText)); */
		wlib.VerifyPageTitle(driver, orgPageParText);
		/* step 6 : create organization with rating */

		CreateNewOrganization newOrg = new CreateNewOrganization(driver);
		newOrg.createOrganization(orgName, orgRating);
		/* Assert.assertTrue(driver.getTitle().contains(createOrgPageParText)); */
		wlib.VerifyPageTitle(driver, createOrgPageParText);
		/* step 7 : Verify organization */

		OrganizationInfo info = new OrganizationInfo(driver);
		String actSuccessfullMsg = info.getSuccessFullMsg().getText();
		Assert.assertTrue(actSuccessfullMsg.contains(orgName));

		System.out.println(newOrg.getHeaderInfo().getText());

		
	}

}

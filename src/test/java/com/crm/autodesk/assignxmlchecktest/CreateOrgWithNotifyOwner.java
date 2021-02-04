package com.crm.autodesk.assignxmlchecktest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;
import com.crm.autodesk.objectrrepositorylib.OrganizationInfo;
import com.crm.autodesk.objectrrepositorylib.Organizations;

public class CreateOrgWithNotifyOwner extends BaseClass {
	/* object Creation */
	JavaUtils jLib = new JavaUtils();
	ExcelUtility eLib = new ExcelUtility();

	@Test
	public void createOrgWithNotifyOwnerOptionTest() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();
	
		/* test Data */
		String orgName = eLib.getExcelData("contact", "tc_01", "OrgName") + randomNum;
		String orgType = eLib.getExcelData("contact", "tc_01", "orgType");
		String orgIndustry = eLib.getExcelData("contact", "tc_01", "Industry");
		String orgRating = eLib.getExcelData("contact", "tc_01", "rating");
		String loginPageParText = eLib.getExcelData("contact", "tc_01", "loginPageParText");
		String homePageParText = eLib.getExcelData("contact", "tc_01", "homePageParText");
		String orgPageParText = eLib.getExcelData("contact", "tc_01", "orgPageParText");
		String createOrgPageParText = eLib.getExcelData("contact", "tc_01", "createOrgPageParText");
		String contLastNAme = eLib.getExcelData("contact", "tc_01", "contactName") + randomNum;

		
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
		newOrg.creatOrganization(orgName);
		Assert.assertTrue(driver.getTitle().contains(createOrgPageParText));
		/* step 7 : Verify organization */

		OrganizationInfo info = new OrganizationInfo(driver);
		String actSuccessfullMsg = info.getSuccessFullMsg().getText();
		Assert.assertTrue(actSuccessfullMsg.contains(orgName));
		System.out.println(newOrg.getHeaderInfo().getText());
		/*
		 * hp.logout(); driver.close();
		 */

	}

}

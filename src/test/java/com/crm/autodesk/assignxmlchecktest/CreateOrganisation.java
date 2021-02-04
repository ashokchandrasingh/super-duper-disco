package com.crm.autodesk.assignxmlchecktest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.OrganizationInfo;
import com.crm.autodesk.objectrrepositorylib.Organizations;

public class CreateOrganisation extends BaseClass{
	
	@Test(groups = "smokeTest")
	public void createOrgwithRatingTest() throws Throwable {

		int randomNum = jLib.generateRandomNum();
		
		String orgName = eLib.getExcelData("contact", "tc_01", "OrgName") + randomNum;
		String orgRating = eLib.getExcelData("contact", "tc_01", "rating");
		String homePageParText = eLib.getExcelData("contact", "tc_01", "homePageParText");
		String orgPageParText = eLib.getExcelData("contact", "tc_01", "orgPageParText");
		String createOrgPageParText = eLib.getExcelData("contact", "tc_01", "createOrgPageParText");
	
		
		hp = new Home(driver);
		hp.getOrgLnk().click();
		wlib.VerifyPageTitle(driver, homePageParText);
	
		Organizations org = new Organizations(driver);
		org.getCreateOrgImg().click();
		wlib.VerifyPageTitle(driver, orgPageParText);
	
		CreateNewOrganization newOrg = new CreateNewOrganization(driver);
		newOrg.createOrganization(orgName, orgRating);
		wlib.VerifyPageTitle(driver, createOrgPageParText);
	
		OrganizationInfo info = new OrganizationInfo(driver);
		String actSuccessfullMsg = info.getSuccessFullMsg().getText();
		Assert.assertTrue(actSuccessfullMsg.contains(orgName));

		System.out.println(newOrg.getHeaderInfo().getText());

	}
	

		
		@Test(groups = "smokeTest")
		public void createOrgwithNotifyOwnerTest() throws Throwable {

			int randomNum = jLib.generateRandomNum();
		
			String orgName = eLib.getExcelData("contact", "tc_01", "OrgName") + randomNum;
			String homePageParText = eLib.getExcelData("contact", "tc_01", "homePageParText");
			String orgPageParText = eLib.getExcelData("contact", "tc_01", "orgPageParText");
			String createOrgPageParText = eLib.getExcelData("contact", "tc_01", "createOrgPageParText");
			
			hp = new Home(driver);
			hp.getOrgLnk().click();
			wlib.VerifyPageTitle(driver, homePageParText);
			
			Organizations org = new Organizations(driver);
			org.getCreateOrgImg().click();
			wlib.VerifyPageTitle(driver, orgPageParText);
		
			CreateNewOrganization newOrg = new CreateNewOrganization(driver);
			newOrg.creatOrganization(orgName);
			wlib.VerifyPageTitle(driver, createOrgPageParText);
			
			OrganizationInfo info = new OrganizationInfo(driver);
			String actSuccessfullMsg = info.getSuccessFullMsg().getText();
			Assert.assertTrue(actSuccessfullMsg.contains(orgName));

			System.out.println(newOrg.getHeaderInfo().getText());

		}
}

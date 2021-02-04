package com.crm.autodesk.orgassignmenttest;

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

public class CearteOrgWithRating extends BaseClass {
	/* object Creation */
	JavaUtils jLib = new JavaUtils();
	ExcelUtility eLib = new ExcelUtility();

	@Test
	public void createOrgwithRatingTest() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();
		/*
		 * String USERNAME = flib.getPropertyKeyValue("username"); String PASSWORD =
		 * flib.getPropertyKeyValue("password"); String URL =
		 * flib.getPropertyKeyValue("url"); String BROWSER =
		 * flib.getPropertyKeyValue("browser");
		 */

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

		/*
		 * step 1 : open Browser and enter url
		 * WebDriver driver = null;
		 * if(BROWSER.equalsIgnoreCase("firefox")) { driver= new FirefoxDriver(); }else
		 * if(BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); }else
		 * if(BROWSER.equalsIgnoreCase("ie")) { driver = new InternetExplorerDriver(); }
		 */
		//navigate to application 
		/*
		 * wLib.waitForHTMLDOM(driver); 
		 //driver.(URL);
		 */
		 /* 
		 * step 3 : login to application
		 * 
		 * Login lp = new Login(driver); lp.loginToApp(USERNAME, PASSWORD);
		 */
		/* Assert.assertTrue(driver.getTitle().contains(loginPageParText)); */
//		wLib.VerifyPageTitle(driver, loginPageParText);

		/* step 4 : navigate to organizations page */

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

		/*
		 * hp.logout(); driver.close();
		 */

	}

}

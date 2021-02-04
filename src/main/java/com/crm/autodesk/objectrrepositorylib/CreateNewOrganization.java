package com.crm.autodesk.objectrrepositorylib;

import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.genericlib.WebDriverUtiles;

/**
 * 
 * @author Deepak
 *
 */
public class CreateNewOrganization extends WebDriverUtiles {
	WebDriver driver;

	public CreateNewOrganization(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(name = "industry")
	private WebElement industriesLst;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "accounttype")
	private WebElement typeLst;

	@FindBy(name = "rating")
	private WebElement ratinglst;

	@FindBy(name = "notify_owner")
	private WebElement notifyOWnChkBx;

	@FindBy(className = "dvHeaderText")
	private WebElement headerInfo;

	@FindBy(xpath = "//input[@onclick='return copyAddressLeft(EditView)']")
	private WebElement shipRadioBtn;

	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement billRadioBtn;

	public WebElement getShpRadioBtn() {
		return shipRadioBtn;
	}

	public WebElement getBillRadioBtn() {
		return billRadioBtn;
	}

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getNotifyOwnChkBx() {
		return notifyOWnChkBx;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustriesLst() {
		return industriesLst;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void creatOrganization(String orgName, String industriesOption) throws Throwable {
		orgNameEdt.sendKeys(orgName);
		select(industriesLst, industriesOption);
		saveBtn.click();

		OrganizationInfo orginfo = new OrganizationInfo(driver);
		waitforElement(orginfo.getSuccessFullMsg());
	}

	public void creatOrganization(String orgName, String industriesOption, String type, String rating)
			throws Throwable {
		orgNameEdt.sendKeys(orgName);
		select(industriesLst, industriesOption);
		select(typeLst, type);
		select(ratinglst, rating);
		saveBtn.click();

		OrganizationInfo orginfo = new OrganizationInfo(driver);
		waitforElement(orginfo.getSuccessFullMsg());
	}

	public void creatOrganization(String orgName) {
		orgNameEdt.sendKeys(orgName);
		notifyOWnChkBx.click();
		saveBtn.click();
	}

	public void createOrganization(String orgName, String rating) {
		orgNameEdt.sendKeys(orgName);
		select(ratinglst, rating);
		saveBtn.click();
	}

	public void verifyDropDownInCreateOrg() {
			Select selRatingLst = new Select(ratinglst);
			List<WebElement> list = null;
			/*Actions act = new Actions(driver);
			act.moveToElement(ratinglst).perform();*/
			
			if(ratinglst.isEnabled())
			{
				list = selRatingLst.getOptions();
				for (WebElement webElement : list) {
					System.out.println(webElement.getText());
				}
			}
			else 
				System.out.println("is not enabled ");
				
	}
		
			/*
			 * Select sel = new Select(ratinglst); boolean isEnabled =
			 * ratinglst.isEnabled(); List<WebElement> list=null; if(isEnabled) { list
			 * =sel.getOptions(); } else System.out.println("is not enabled");
			 * 
			 * for (WebElement webElement : list) {
			 * System.out.println(webElement.getText()); }
			 */
		 
		 
	

	

	public void verifyNotifyOwnerchkBx() {
		if (notifyOWnChkBx.isEnabled()) {
			notifyOWnChkBx.click();
			System.out.println(notifyOWnChkBx.isSelected());
			notifyOWnChkBx.click();
			System.out.println(!notifyOWnChkBx.isSelected());
		} else
			System.out.println("Notify Owner Check Box is not Enabled");
	}

	public void verifyShipRadioButtonIsEnabled() {
		shipRadioBtn.click();
		System.out.println(shipRadioBtn.isEnabled());

	}

	public void verifyBillRadioButtonIsEnabled() {
		shipRadioBtn.click();
		System.out.println(shipRadioBtn.isEnabled());

	}
}

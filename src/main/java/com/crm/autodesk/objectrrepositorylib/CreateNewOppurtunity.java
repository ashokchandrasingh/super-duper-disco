package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewOppurtunity extends WebDriverUtiles { 
	WebDriver driver;
	public CreateNewOppurtunity(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOppur() {
		return oppur;
	}


	public WebElement getCrtOrgBtn() {
		return crtOrgBtn;
	}


	public WebElement getOrgPopUpBtn() {
		return orgPopUpBtn;
	}


	public WebElement getCmpPopUpBtn() {
		return cmpPopUpBtn;
	}


	public WebElement getOppurSaveBtn() {
		return oppurSaveBtn;
	}


	public WebElement getOppurNameEdtBtn() {
		return oppurNameEdtBtn;
	}


	public WebElement getOppurTyp() {
		return oppurTyp;
	}


	public WebElement getSearchBox() {
		return searchBox;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getSelOrgName() {
		return selOrgName;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	

	@FindBy(linkText = "Opportunities")
	private WebElement oppur;
	
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement crtOrgBtn;
	
	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement orgPopUpBtn;
	
	@FindBy(xpath = "//input[@name='campaignname']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement cmpPopUpBtn;
	
	@FindBy(xpath ="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement oppurSaveBtn;
	
	@FindBy(name = "potentialname")
	private WebElement oppurNameEdtBtn;
	
	@FindBy(name ="opportunity_type")
	private WebElement oppurTyp;
	
	@FindBy(name ="search_text")
	private WebElement searchBox;
	
	@FindBy(name ="search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']")
	private WebElement selOrgName;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	
	public void selOrgName(String oppurName ,String childWinParTitle,String orgName, String parentWinParTitle) {
		
		oppurNameEdtBtn.sendKeys("asdfgh");
		orgPopUpBtn.click();
		swicthToWindow(driver, childWinParTitle);
		searchBox.sendKeys(orgName);
		searchBtn.click();
		selOrgName.click();
		swicthToWindow(driver, parentWinParTitle);
		
		
		
	}
		
		
		
	

}

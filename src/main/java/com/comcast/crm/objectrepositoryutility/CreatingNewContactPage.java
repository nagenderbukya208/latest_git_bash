package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   @FindBy(name="lastname")
 private   WebElement lastNameEdt;
   
   @FindBy(xpath="//input[@title='Save [Alt+S]']")
   private WebElement saveBtn;
   @FindBy(name="support_start_date")
   private WebElement startDateEdt;
   @FindBy(name="support_end_date")
   private WebElement endDateEdt;
   @FindBy (name="lastname")
    private WebElement contactLastName;
   @FindBy (name="account_name")
   private WebElement orgNameEdt;
   
 public void getContactWithOrg(String conatctLastname,String orgName) {
	 lastNameEdt.sendKeys(conatctLastname);
	 orgNameEdt.sendKeys(orgName);
 }
   
   
public WebElement getStartDateEdt() {
	return startDateEdt;
}

public WebElement getEndDateEdt() {
	return endDateEdt;
}

public WebElement getLastName() {
	return lastNameEdt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}
public void createContact(String lastName) {
	lastNameEdt.sendKeys(lastName);
	saveBtn.click();
}
public void createContactWithSupportDate(String lastName,String startDate,String endDate) {
	lastNameEdt.sendKeys(lastName);
	startDateEdt.sendKeys(startDate);
	endDateEdt.sendKeys(endDate);
}

}

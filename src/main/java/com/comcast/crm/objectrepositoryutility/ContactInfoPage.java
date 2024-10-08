package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="mouseArea_Last Name")
private	WebElement lastNameTxt;
	public WebElement getLastNameTxt() {
		return lastNameTxt;
	}
	
@FindBy(id="mouseArea_Support Start Date")
    private WebElement supportStartDateInfo;

@FindBy(id="mouseArea_Support End Date")
private WebElement supportEndDateInfo;
public WebElement getSupportStartDateInfo() {
	return supportStartDateInfo;
}

public WebElement getSupportEndDateInfo() {
	return supportEndDateInfo;
}


}

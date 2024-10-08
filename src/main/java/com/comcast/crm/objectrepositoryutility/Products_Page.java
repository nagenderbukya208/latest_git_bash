package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_Page {
	
	
	@FindBy(xpath="//img[@title=\"Create Product...\"]")
	private WebElement createProductImgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchboxele;

	public WebElement getSearchbox() {
		return searchboxele;
	}

	public WebElement getCreateProductImgBtn() {
		return createProductImgBtn;
	}

}

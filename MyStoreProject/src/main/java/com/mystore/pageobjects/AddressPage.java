package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionndriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement prceedToChechPut;

	public  AddressPage() {
		PageFactory.initElements(driver, this);
	}
	public ShippingPage clickOnCheckOut() {
		Action.click(driver, prceedToChechPut);
		return new ShippingPage();
		
	}
	
}



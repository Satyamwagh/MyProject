package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionndriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement bankWireMethod;

	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement payByCheckMethod;
	
	public  PaymentPage() {
		PageFactory.initElements(driver, this);
			}
	public OrderSummery clickOnPaymentMethod() {
		Action.click(driver, bankWireMethod);
		return new OrderSummery();
	}
}

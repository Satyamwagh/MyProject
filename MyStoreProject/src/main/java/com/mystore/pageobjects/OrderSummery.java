package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actionndriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummery extends BaseClass {
	
	@FindBy(xpath="//span[text()='I confirm my order']")
	WebElement confrimOrderBtn;
	
	public OrderSummery() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickConfirmOrderBtn() {
		Action.click(driver, confrimOrderBtn);
		return new OrderConfirmationPage();
		
	}

}
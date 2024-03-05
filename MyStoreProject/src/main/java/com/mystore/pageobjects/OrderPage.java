package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionndriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage  extends BaseClass {
	
	@FindBy(xpath="//li[@class='price']")   ////td[@class='cart_unit']  //td[@class='cart_unit']/span/span
	WebElement unitPrice;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement totalPrice;

	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public  OrderPage() {
		PageFactory.initElements(driver, this);
	}
	public Double getUnitPrice() {
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		Double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice;
	}	
	public Double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		Double finaltotalPrice=Double.parseDouble(tot);
		return finaltotalPrice;
	}	
	public LoginPage clickOnCheckout() {
		Action.click(driver, proceedToCheckOut);
		return new LoginPage();
		
	}
	
	
	




}

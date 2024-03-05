package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actionndriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement terms;
	
	@FindBy(xpath="(//span[contains(text(),'Proceed to checkout')])[2]")	
	WebElement proccedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
		
			}
	public void checkTheTerms() {
		//Action.mouseHoverByJavaScript(terms);
		Action.mouseOverElement(driver, terms);
		Action.click(driver, terms);
	}
	public PaymentPage clickOnProceedToCheckOutBtn() {
		Action.click(driver, proccedToCheckOutBtn);
		return new PaymentPage();
	}
	
	


}

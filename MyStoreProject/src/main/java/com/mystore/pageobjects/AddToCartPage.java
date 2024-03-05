package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actionndriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(name="Submit")
	WebElement addToCartBTN;
	
	@FindBy(xpath="//i[@class='icon-check']")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	
	public  AddToCartPage() {
		PageFactory.initElements(driver, this);		
	}
	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}
	public void selectSize(String size1) {
		Action.selectByVisibaleText(size1, size);
}
	public void clickOnAddToCart() {
		Action.click(driver, addToCartBTN);		
	}
	public boolean validateAddTOCart() {
		return Action.isDisplayed(driver, addToCartMessage)	;
	}
	public OrderPage clickOnCheckOut() {
		Action.mouseOverElement(driver, proceedToCheckOutBtn);
		//Action.fluentWait(driver, proceedToCheckOutBtn, 10);
		Action.JSclick(driver, proceedToCheckOutBtn);
		return new OrderPage();		
	}

}

package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actionndriver.Action;
import com.mystore.base.BaseClass;

/** *  */
public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")      //a[@class='quick-view']
	WebElement productResult;
	
	//@FindBy(xpath="//span[text()='Quick view']")      //a[@class='quick-view']
     //WebElement clickBTN;

	public  SearchResultPage() {
		PageFactory.initElements(driver,this);
	}
	public Boolean isProductAvailable() {
		return Action.isDisplayed(driver, productResult);
				
	}
	public AddToCartPage clickOnProduct() {
		
		Action.mouseOverElement(driver, productResult);
		Action.JSclick(driver, productResult);
		//productResult.click();
		return new AddToCartPage();
	}
}

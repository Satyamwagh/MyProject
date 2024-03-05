package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionndriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement MyStoreLogo;
	
	@FindBy(id ="search_query_top")
	//@FindBy(xpath = "//input[@class='search_query form-control ac_input']")
	WebElement SearchProductBox;
	
	@FindBy(name ="submit_search")
		WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);		
	}
	public LoginPage clickOnSignIn() {
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	public Boolean validateLogo() {
		return Action.isDisplayed(driver, MyStoreLogo);
		}
	public String getMyStoreTitle() {
		String MyStoreTitel=driver.getTitle();
		return MyStoreTitel;
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(SearchProductBox, productName);
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}

}

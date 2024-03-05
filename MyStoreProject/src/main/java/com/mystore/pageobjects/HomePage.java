package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actionndriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {


	@FindBy(xpath = "//a[@title='Orders']")
	WebElement orderHistory;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateOrderHistory() {
		return Action.isDisplayed(driver, orderHistory);

	}
	public String getCurrUrl() {
	String homePageUrl=	driver.getCurrentUrl();
	return homePageUrl;

	}
}

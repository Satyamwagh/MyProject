package com.mystore.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	IndexPage index;
	LoginPage loginPage;
	AddToCartPage addToCartPage;
	SearchResultPage searchResultPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		 Thread.sleep(10000);
		// driver.quit();
	}
	
	@Test
	public void addToCartTest() throws Throwable {
		index= new IndexPage();
		searchResultPage=index.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0,200)", "");
		addToCartPage.clickOnAddToCart();	
		Thread.sleep(10000);
	boolean result=addToCartPage.validateAddTOCart();
	
		addToCartPage.clickOnCheckOut();
		js.executeScript("window.scrollBy(0,200)", "");
		 Assert.assertTrue(result);
		/*index=new IndexPage();
		searchResultPage= new SearchResultPage();
		searchResultPage=index.searchProduct("t-shirt");
		
	

		   Thread.sleep(5000);	
		   addToCartPage=searchResultPage.clickOnProduct();
		 	addToCartPage.enterQuantity("2");
	addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddTOCard();
		Assert.assertTrue(result);		*/
		
	
		
	}
	
}

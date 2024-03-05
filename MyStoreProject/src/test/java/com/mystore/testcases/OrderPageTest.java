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
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage index;
	LoginPage loginPage;
	AddToCartPage addToCartPage;
	SearchResultPage searchResultPage;
	OrderPage orderPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.quit();
	}
	@Test
	public void verifyTotalPrice() throws InterruptedException {
		index= new IndexPage();
		searchResultPage=index.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.selectSize("M");
		addToCartPage.enterQuantity("2");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0,200)", "");
		addToCartPage.clickOnAddToCart();	
		Thread.sleep(10000);
		addToCartPage.clickOnCheckOut();
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(10000);
		orderPage=new OrderPage();
		Double unitPrice=orderPage.getUnitPrice(); 		
		Double totalPrice=	orderPage.getTotalPrice();  //	
		Double totalExpectedPrice=(unitPrice*2)+7;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		System.out.println(totalExpectedPrice);
	}

}


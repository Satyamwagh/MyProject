package com.mystore.testcases;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummery;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass {
	IndexPage index;
	LoginPage loginPage;
	AddToCartPage addToCartPage;
	SearchResultPage searchResultPage;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;	
	OrderSummery orderSummery;
	OrderConfirmationPage orderConfirmationPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		 Thread.sleep(5000);
		// driver.quit();
	}
	@Test
	public void endToEndTest() throws InterruptedException {
		index= new IndexPage();
		searchResultPage=index.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		Thread.sleep(10000);
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
		js.executeScript("window.scrollBy(0,250)", "");
		loginPage=orderPage.clickOnCheckout();
		js.executeScript("window.scrollBy(0,250)", "");
		loginPage =new LoginPage();
		addressPage=loginPage.login1(prop.getProperty("username"),(prop.getProperty("password")));
		addressPage=new AddressPage();
		addressPage.clickOnCheckOut();
		js.executeScript("window.scrollBy(0,250)", "");
		shippingPage =new ShippingPage();
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(5000);
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOutBtn();
		paymentPage=new PaymentPage();
		orderSummery=paymentPage.clickOnPaymentMethod();
		orderSummery=new OrderSummery();
		orderConfirmationPage=orderSummery.clickConfirmOrderBtn();
		orderConfirmationPage=new OrderConfirmationPage();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		js.executeScript("window.scrollBy(0,300)", "");
		String expectedMsg="Your order on My Shop is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		System.out.println(actualMessage);
		
		
		/*Double unitPrice=orderPage.getUnitPrice(); 		
		Double totalPrice=	orderPage.getTotalPrice();  //	
		Double totalExpectedPrice=(unitPrice*1)+7;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		System.out.println(totalExpectedPrice);  */
	}

}

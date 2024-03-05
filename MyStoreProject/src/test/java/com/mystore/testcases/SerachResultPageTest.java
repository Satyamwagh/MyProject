package com.mystore.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

public class SerachResultPageTest extends BaseClass {
	IndexPage index;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		 Thread.sleep(10000);
		driver.quit();
	}
	@Test
	public void productAvailabilityTest() {
		index=new IndexPage();
		searchResultPage= new SearchResultPage();
		searchResultPage=index.searchProduct("t-shirt");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		//searchResultPage.clickOnProduct();
		Boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
	
		
	}

}

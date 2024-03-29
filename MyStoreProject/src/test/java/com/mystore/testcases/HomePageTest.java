package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
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
	public void verifyOrderHistory() {
		 indexPage=new IndexPage();
		loginPage= indexPage.clickOnSignIn();
		 homePage=loginPage.login(prop.getProperty("username"),(prop.getProperty("password")));
		boolean result= homePage.validateOrderHistory();
		System.out.println(result);
		
	}
	

}

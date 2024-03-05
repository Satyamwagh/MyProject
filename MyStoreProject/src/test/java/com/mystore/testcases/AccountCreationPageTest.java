package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
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
public void verifyCreateAccountPageTest() {
	indexPage=new IndexPage();
	loginPage= indexPage.clickOnSignIn();
	 accountCreationPage=loginPage.createNewAccount("shubham@gmail.com");
	 boolean result=accountCreationPage.ValidateAccountCreatePage();
	 Assert.assertEquals(true, result);
}
}




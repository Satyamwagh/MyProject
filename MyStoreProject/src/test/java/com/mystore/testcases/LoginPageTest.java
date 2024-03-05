package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;



public class LoginPageTest extends BaseClass {
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
		driver.quit();
	}
	@Test (dataProvider= "Credentials",dataProviderClass=DataProvider.class)
	public void loginTest(String uname,String pswd) throws InterruptedException {
		Log.startTestCase("loginTest");
		Log.info("User is going to click on sign In");
		 indexPage = new IndexPage();
		 Thread.sleep(1000);
		 loginPage=indexPage.clickOnSignIn();
		 Log.info("Enter USerName & Password");
		homePage=loginPage.login(prop.getProperty("username"),(prop.getProperty("password")));
		// homePage=loginPage.login(uname,pswd);
		String actualUrl=homePage.getCurrUrl();
		String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
		Log.info("Verifying if user able to login");
		Assert.assertEquals(actualUrl, expectedURL);
		Log.info("login is success");
		Log.endTestCase("loginTest");
		
		
	}

}

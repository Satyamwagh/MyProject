package com.mystore.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import com.mystore.actionndriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	
	//@BeforeSuite
	public void beforeSuite() {	
	System.getProperty("/MystoreProject/log4j.xml");
	DOMConfigurator.configure("log4j.xml");
	}	
//@BeforeTest
	public void loadConfig() {
				try {
			prop = new Properties();
			System.out.println("Super Constructor invoked");
		    FileInputStream ip = new FileInputStream(
		    		System.getProperty("user.dir")+"\\Configuration\\config.properties");
		    prop.load(ip);
		   System.out.println("driver: "+ driver);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void launchApp(){
		WebDriverManager.chromedriver().setup();
		String browserName=prop.getProperty("browser");		
		browserName.contains("Chrome");
		driver = new ChromeDriver();	
		
		driver.manage().window().maximize();
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));

		//String browserUrl=prop.getProperty("url"); 
		
		
			}
	
}

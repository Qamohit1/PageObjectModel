package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.util.WebEventListner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;

	
	

	
	public Testbase() {		
		try {
			 prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		    }
		catch(FileNotFoundException e) {
			e.printStackTrace();			
		}
		catch(IOException e) {
			e.printStackTrace();			
		}
	}
	
	static String src = System.getProperty("user.dir");
	
	
	
//@BeforeClass
//@Parameters(browser)
public static void initializebrowser() throws InterruptedException{
	
	String broswerName = prop.getProperty("browser");
	
	if(broswerName.equals("Chrome")){
		//WebDriverManager.chromedriver().setup();	
		// To disable "Timed out receiving message from renderer error" in console
		System.setProperty("webdriver.chrome.silentOutput","true");
		System.setProperty("webdriver.chrome.driver", src +"\\src\\main\\Drivers\\chromedriver.exe");	
		// To 𝐂𝐡𝐫𝐨𝐦𝐞 𝐢𝐬 𝐛𝐞𝐢𝐧𝐠 𝐜𝐨𝐧𝐭𝐫𝐨𝐥𝐥𝐞𝐝 𝐛𝐲 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐞𝐝 𝐭𝐞𝐬𝐭  𝐬𝐨𝐟𝐭𝐰𝐚𝐫𝐞? 𝐃𝐢𝐬𝐚𝐛𝐥𝐞 𝐭𝐡𝐢𝐬 𝐚𝐧𝐧𝐨𝐲𝐢𝐧𝐠 𝐩𝐨𝐩𝐮𝐩.
		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		driver =new ChromeDriver(options);
		
	    } 
		else if(broswerName.equals("FF")) {
		WebDriverManager.firefoxdriver().setup();
		//System.setProperty("Webdriver.gecko.driver", src+"\\src\\main\\Drivers\\geckodriver.exe");		
		driver =new FirefoxDriver();
		}
		else if(broswerName.equals("IE")) {
			WebDriverManager.iedriver().setup();
			//System.setProperty("webdriver.ie.driver", src+"\\src\\main\\Drivers\\IEDriverServer.exe");		
			driver =new InternetExplorerDriver();
		}
		else if(broswerName.equals("")) {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("Webdriver.gecko.driver", src+"\\src\\main\\Drivers\\geckodriver.exe");		
			driver =new FirefoxDriver();
		}
	
	//EventFiringWebDriver e_driver= new EventFiringWebDriver(driver);
	//WebEventListner Webevent = new WebEventListner();
	//e_driver.register(Webevent);
	//driver=e_driver;
	
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  driver.manage().deleteAllCookies();
	  
	  driver.get(prop.getProperty("url"));
	  Thread.sleep(3000);


	}
	
@AfterClass
public void Teardown() {
	
	driver.quit();
	
}
	
	
	
	
	
}
	
	
	
	
	

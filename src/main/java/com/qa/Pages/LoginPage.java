package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;
import com.qa.util.TestUtil;

public class LoginPage extends Testbase{

	
	public LoginPage(){		
	 PageFactory.initElements(driver, this);
			
	}
		
	@FindBy(name="username")
	//@CacheLookup
	WebElement Username;
	
	@FindBy(name="password")
	//@CacheLookup
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	//@CacheLookup
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	//@CacheLookup
	WebElement ele;
	
	TestUtil testutil = new TestUtil();
	
	public void logintoapp(String username, String password ) throws InterruptedException {
	Username.sendKeys(username);

	Password.sendKeys(password);
	loginbtn.click();

	}
	

	
}

package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class Signup extends Testbase{

	WebDriver idriver;
	
	public Signup(WebDriver rdriver){
		
	 PageFactory.initElements(rdriver, this);
			
	}
		
	@FindBy(name="username")
	@CacheLookup
	WebElement Username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	@CacheLookup
	WebElement loginbtn;
	
	public void EnterUsername(String username) {
	Username.sendKeys(username);
	}
	
	public void EnterPassword(String password) {
		Password.sendKeys(password);

		}
	
	
	public void ClickonLoginbtn() {
		loginbtn.click();
		}
	
	
	
	
	
	
	
	
	
	
}

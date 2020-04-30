package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qa.base.Testbase;
import com.qa.Pages.Homepage;
import com.qa.Pages.LoginPage;

public class LoginTC extends Testbase{
	LoginPage loginPage;
	Homepage homePage;
	String user = prop.getProperty("Username");
	String pass = prop.getProperty("Password");
	
	
	public LoginTC(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initializebrowser();
		loginPage = new LoginPage();	
	}
	

	@Test(priority=1)
	public void logintest() throws InterruptedException{
		homePage = loginPage.logintoapp(user,pass);
	}
	
	
}

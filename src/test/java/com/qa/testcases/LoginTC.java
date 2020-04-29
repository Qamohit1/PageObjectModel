package com.qa.testcases;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.CreateContactpage;
import com.qa.Pages.Homepage;
import com.qa.Pages.LoginPage;
import com.qa.base.Testbase;

public class LoginTC extends Testbase{
	
	LoginPage login = new LoginPage();
	
	String user = prop.getProperty("Username");
	String pass = prop.getProperty("Password");
	
	
	
	public LoginTC() {
		super();
	}
	   

	@BeforeMethod
	public void Beforet() throws InterruptedException, EncryptedDocumentException, IOException {	
	        initializebrowser();
					
		}
		
	
	
 @Test
 public void logintest() throws InterruptedException {
	 login.logintoapp(user,pass);
	
	 
 }
     
 @AfterMethod
 public void Aftertest() throws InterruptedException {	
 	
 	//driver.close();
 	
 }	

     
	

}
 
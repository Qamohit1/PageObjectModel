package com.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Pages.CreateContactpage;
import com.qa.Pages.Homepage;
import com.qa.Pages.LoginPage;
import com.qa.base.Testbase;
import com.qa.util.TestUtil;

public class CreatecontactTC extends Testbase{
	
	LoginTC logintc;
	Homepage homepage;
	CreateContactpage createContactpage;
	
	public CreatecontactTC() {		
		super();
		
	} 
	
	
	
@BeforeMethod
public void Beforet() throws InterruptedException, EncryptedDocumentException, IOException {	
        initializebrowser();
    	logintc = new LoginTC();
    	homepage =new Homepage();
    	createContactpage =new CreateContactpage();
		logintc.logintest();
		homepage.clickonContactppage("New Contact");
		
				
	}
	
	
	  @Test(priority=1) public void Verifycontactonformation()  { 
		  createContactpage.contactinfo("Contact Information");
	  System.out.println("Verifycontactonformation success verified"); 
	  }
	  
	  
	  @Test(priority=2) public void VerifyLoadbutton() throws InterruptedException{
		  createContactpage.Loadbutton("");
	  System.out.println("VerifyLoadbutton success verified");
	  }
	  
	  
	 
	
	  @DataProvider public Object[][] getdata() throws EncryptedDocumentException,
	  IOException { 
		  Object data[][]=TestUtil.GetTestdata("Sheet1"); 
		  return data;
	  
	  }
	 

	
	  @Test(priority=3,dataProvider ="getdata") 
	  public void createconctactssss(String Title, String FirstNam, String MiddleNam, String
	  LastNam, String Suffi) throws InterruptedException {
		
	  createContactpage.createnewcontact(Title, FirstNam, MiddleNam, LastNam, Suffi);
	  }
	  
	 



@AfterMethod
public void Aftertest() throws InterruptedException {	
	
	driver.close();
	
}	




}

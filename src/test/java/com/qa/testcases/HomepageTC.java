package com.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.Pages.CreateContactpage;
import com.qa.Pages.Homepage;
import com.qa.Pages.LoginPage;
import com.qa.base.Testbase;
import com.qa.util.MyScreenRecorder;

public class HomepageTC extends Testbase{

	
	LoginPage loginPage;
	Homepage homepage;
	CreateContactpage createContactpage;
	String user = prop.getProperty("Username");
	String pass = prop.getProperty("Password");



	
	public HomepageTC() {
		super();
	}
	

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(HomepageTC.class);
	

	
	
	//String log4j = System.getProperty("user.dir" +"\\src\\main\\resources\\log4j.properties");
	
	
	
@BeforeMethod
public void Beforetest() throws InterruptedException {	
	initializebrowser();
	//log.info("Initializing Browser");
	//logintc =new LoginTC();
	loginPage = new LoginPage();
	homepage =new Homepage();
	createContactpage = new CreateContactpage();
	homepage = loginPage.logintoapp(user,pass);

	//log.info("login too the application");
	
	
}	

@Test(priority=1)
public void Verifuser() throws Exception {	
	 logger.debug("This is debug message");
     logger.info("This is info message");
     logger.warn("This is warn message");
     logger.fatal("This is fatal message");
     logger.error("This is error message");
     System.out.println("Logic executed successfully....");
	//MyScreenRecorder.startRecording("Testcase Recording");
	homepage.verifyusername(" Mohit k");	
	//log.info("Uesrname success verified");
	//System.out.println("Uesrname success verified");
}	


@Test(priority=2)
public void Veriflogin() throws Exception {	
	homepage.verifylogin("  Logout  ");
	logger.info("Login success verified");
	//MyScreenRecorder.stopRecording();
}	
  


  @Test(priority=3) public void Verifcontactlink() throws InterruptedException
  { createContactpage=homepage.clickonContactppage("New Contact");
   System.out.println("Contact link verified"); }
 

@AfterMethod
public void Aftertest() throws InterruptedException {	
	driver.close();
	
}	


}



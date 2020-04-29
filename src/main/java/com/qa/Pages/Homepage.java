package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.util.TestUtil;

public class Homepage extends Testbase{
	
	
	public Homepage() {
		PageFactory.initElements(driver, this);
				
	}

	TestUtil testutil = new TestUtil();
	

	@FindBy(name="mainpanel")
	@CacheLookup
	WebElement Frame;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	@CacheLookup
	WebElement NewContact;
	
	
	@FindBy(xpath = "//td[contains(text(),'User: Mohit k')]")
	@CacheLookup
	WebElement verifyuser;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement veriflogin;
	
	public void verifyusername(String Actual) {
		testutil.SwithchToframe();	
		String exp = verifyuser.getText();
		String Exp[]=exp.split(":"); 
		String Expected = Exp[1];
		Assert.assertEquals(Expected, Actual);		
	}
	
	
	
	public void verifylogin(String Act) {	
		testutil.SwithchToframe();	
		Assert.assertEquals(veriflogin.getText(), Act);		
	}
		

public CreateContactpage clickonContactppage(String Expected) throws InterruptedException {
	
	testutil.SwithchToframe();	
	
	 Actions action = new Actions(driver);
	 action.moveToElement(contactsLink).build().perform();
	 System.out.println("Contact link is displaying...!"); 
	 //Assert.assertEquals(NewContact.getText(), Expected);
	 NewContact.click();
	 System.out.println("New Contact page opens successfully...!");		
	 return new CreateContactpage();
}	

	



}

package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.base.Testbase;
import com.qa.util.TestUtil;

public class CreateContactpage extends Testbase{
	
	TestUtil testutil= new TestUtil();
	
	 public CreateContactpage() {
		PageFactory.initElements(driver, this);
	}
	
	

	
	@FindBy(xpath = "//select[@name='title']")
	@CacheLookup
	WebElement Dropdown;
	
	@FindBy(xpath = "//input[@id='first_name']")
	@CacheLookup
	WebElement FirstName;
	
	
	@FindBy(xpath = "//input[@id='middle_initial']")
	@CacheLookup
	WebElement MiddleName;
	
	
	@FindBy(xpath = "//input[@id='surname']")
	@CacheLookup
	WebElement LastName;
	
	@FindBy(xpath = "//select[@name='suffix']")
	@CacheLookup
	WebElement Suffix;	
	
	@FindBy(xpath = "//legend[contains(text(),'Contact Information')]")
	@CacheLookup
	WebElement contactinfo;	
	
	@FindBy(xpath = "//input[@value='Load From Company']")
	@CacheLookup
	WebElement Loadbutton;	
	
	@FindBy(xpath = "//input[@value='Save']")
	@CacheLookup
	WebElement Savebutton;	
	
	
	
	public void contactinfo(String Expected) {	
		//testutil.SwithchToframe();	
		Assert.assertEquals(contactinfo.getText(), Expected);		
	}
	
		
	public void Loadbutton(String Expected) {	
		//testutil.SwithchToframe();	
		String loadtext = Loadbutton.getText();
		System.out.println(loadtext+"loadtext..................");
		
		Assert.assertEquals(loadtext, Expected);		
	}
	
	public void createnewcontact(String Title, String FirstNam, String MiddleNam, String LastNam,String Suffi) throws InterruptedException {
		
		Select select =new Select(Dropdown);
		select.selectByVisibleText(Title);

		FirstName.sendKeys(FirstNam);

		MiddleName.sendKeys(MiddleNam);

		LastName.sendKeys(LastNam);	

		Select select2 =new Select(Suffix);

		select2.selectByVisibleText(Suffi);

		Savebutton.click();
		
	}
	
	
	

}

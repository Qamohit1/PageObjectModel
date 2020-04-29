package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.UseSelFSRecord;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.UserAndPassword;

import com.qa.base.Testbase;

public class TestUtil extends Testbase{
	
	public static Workbook wb;
	public static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public File Src;
	
	
	
	public void SwithchToframe() {
		driver.switchTo().frame("mainpanel");
	}

	//String path = System.getProperty("user.dir");
	static String Testdatasheet = "./src\\main\\java\\com\\qa\\testdata\\TestData.xlsx";
	
	public static Object[][] GetTestdata(String Sheetname) throws EncryptedDocumentException, IOException {

		FileInputStream file = null;	
			file = new FileInputStream(Testdatasheet);
			wb = WorkbookFactory.create(file);
		sheet = wb.getSheet(Sheetname);
		int Getlastrownu = sheet.getLastRowNum();
		int Getlastcolvalue =sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[Getlastrownu][Getlastcolvalue];
		 System.out.println("Getlastrownu===> "+ Getlastrownu);
		System.out.println("Getlastcolvalue =====>"+Getlastcolvalue);
		for (int i = 0; i < Getlastrownu; i++) {
			for (int k = 0; k < Getlastcolvalue; k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
		
	
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir= System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File("./src\\main\\java\\com\\qa"+"\\Screenshots\\" + System.currentTimeMillis()+".png"));
		
		
	}

	/*
	 * public static void takeScreenshotAtEndOfTesta() throws IOException { File
	 * scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); String
	 * currentDir = System.getProperty("user.dir"); FileUtils.copyFile(scrFile, new
	 * File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png")); }
	 */	
		
	}
	
	
	
	



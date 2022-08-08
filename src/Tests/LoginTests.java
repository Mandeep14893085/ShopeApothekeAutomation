/**
 * 
 */
package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.LoginPage;
import Pages.SignUp;

/**
 * @author Mandeep
 *
 */

public class LoginTests extends BrowserFactory {
	
	//WebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	 String projectlocation=System.getProperty("user.dir");	
	
	
	@Test
	public void verifyValidLogin() throws InterruptedException
	{

	
	LoginPage login=new LoginPage(driver);
	
		
	
	//In this testcase I have fetch username and password from excel sheet ,instead of changing code we will only update excel 
		 try {
			
			    
			  FileInputStream file = new FileInputStream(new File(projectlocation+"/Testdata/Testdata.xlsx")); 
			  XSSFWorkbook workbook = new XSSFWorkbook(file);
			  
			  XSSFSheet sheet = workbook.getSheetAt(0);
			   
			  String UserEmail = sheet.getRow(0).getCell(0).getStringCellValue();
			    
			  String Password = sheet.getRow(0).getCell(1).getStringCellValue();
			    
	 
	  
			
				
				
			  Thread.sleep(1000);
				
				//Read useremail from excel sheet
			  login.typeusername(UserEmail);
			  
				//Read Password from excel sheet
			   login.typePassword(Password);
			   Thread.sleep(1000);
		
			  
			  // Click login button
				login.clickOnLoginButton(); 
			  
			 		 			
					  
			  
			  file.close();
			 
			 } 
		 
		 catch (FileNotFoundException fnfe)
             {
			  fnfe.printStackTrace();
			 } 
		 catch (IOException ioe) {
			  ioe.printStackTrace();
			 }
	
	
	
	driver.quit();
	
	
	}
	
	@Test (dependsOnMethods = { "verifyValidLogin" })
	public void verifyInValidLogin() throws InterruptedException
	{
	
	
	LoginPage login=new LoginPage(driver);
	

	//In this testcase I have fetch username and password from excel sheet ,instead of changing code we will only update excel 
		 try {
			 
			
			    
			  FileInputStream file = new FileInputStream(new File(projectlocation+"/Testdata//Testdata.xlsx")); 
			  XSSFWorkbook workbook = new XSSFWorkbook(file);
			  
			  XSSFSheet sheet = workbook.getSheetAt(0);
			   
			  String UserEmail = sheet.getRow(0).getCell(2).getStringCellValue();
			    
			  String Password = sheet.getRow(0).getCell(3).getStringCellValue();
			    
	 					
		
			  Thread.sleep(1000);
				
				//Read useremail from excel sheet
			  login.typeusername(UserEmail);
			  
				//Read Password from excel sheet
			   login.typePassword(Password);
			   Thread.sleep(1000);
		
			  
			  // Click login button
				login.clickOnLoginButton(); 
				
				 String exp = "E-Mail-Adresse und/oder Passwort sind falsch. Bitte überprüfen Sie Ihre Eingaben.";
				 
				 WebElement message = driver.findElement(By.className("l-flex__primary u-no-margin u-padding--ends m-Notification__message"));
			      String act = message.getText();
			      System.out.println("Error message is: "+ act);
			      //verify error message with Assertion
			      Assert.assertEquals(exp, act);
			 		 			
					  
			  
			  file.close();
			 
			 } 
		 
		 catch (FileNotFoundException fnfe)
             {
			  fnfe.printStackTrace();
			 } 
		 catch (IOException ioe) {
			  ioe.printStackTrace();
			 }
	
	
	
	driver.quit();
	
	
	
	
	}
	
	/*@AfterTest
	public void closedriver()
	{
		driver.close();
		softAssert.assertAll();
	}*/

}

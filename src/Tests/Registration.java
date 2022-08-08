/**
 * 
 */
package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import Pages.LoginPage;
import Pages.SignUp;

/**
 * @author saingur
 *
 */
public class Registration extends BrowserFactory {
	
	

	
	SoftAssert softAssert=new SoftAssert();
	 String projectlocation=System.getProperty("user.dir");	
	
	
	@Test(priority=2,groups = { "Regression"})
	public void verifyValidLogin() throws InterruptedException
	{
	
	
		SignUp signup=new SignUp(driver);
	
	
   	
	
	
	//In this testcase I have fetch username and password from excel sheet ,instead of changing code we will only update excel 
		 try {

				signup.becomeMember();
				signup.slectgender();
			    
			  FileInputStream file = new FileInputStream(new File(projectlocation+"/Testdata/Testdata.xlsx")); 
			  XSSFWorkbook workbook = new XSSFWorkbook(file);
			  
			  XSSFSheet sheet = workbook.getSheetAt(0);
			   
			  String userfirstname = sheet.getRow(0).getCell(0).getStringCellValue();
			    
			  String userlastname = sheet.getRow(0).getCell(1).getStringCellValue();
			  
			  String useremail = sheet.getRow(0).getCell(2).getStringCellValue();
			  
			  String userpassword = sheet.getRow(0).getCell(3).getStringCellValue();
			    
			  Thread.sleep(1000);
			 		  
			
				
				
			   
			   signup.firstname(userfirstname);
			 signup.lastname(userlastname);
			 signup.email(useremail);
			signup.password(userpassword);
			
			signup.DOB();
						
			Thread.sleep(500);
				signup.selectterms(); 
				signup.clickOnRegisterButton();
				Thread.sleep(2000);
		
			 
			  
			 
			 
		String ActualTitle=driver.getTitle();
	System.out.println("Actual Title:"+ActualTitle);
	String Expectedtitle="Mein Konto / Ihre Übersicht";
	
	
	
	AssertJUnit.assertEquals(ActualTitle, Expectedtitle);
	
	if (Expectedtitle.equals(ActualTitle))
   {
          System.out.println("Verification Successful - User is successfully logged in to the application");
   }
   else
   {
          System.out.println("Verification Failed - User is not logged in to the application");
   }
			  
			   
					  
			  
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
	

	
	@Test(priority=1,groups = { "Sanity"})
	public void verifyInValidLogin() throws InterruptedException
	{
	
	
		SignUp signup=new SignUp(driver);
		
		
	
   	
	
	
	//In this testcase I have fetch username and password from excel sheet ,instead of changing code we will only update excel 
		 try {

				signup.becomeMember();
				signup.slectgender();
			    
			  FileInputStream file = new FileInputStream(new File(projectlocation+"/Testdata/Testdata.xlsx")); 
			  XSSFWorkbook workbook = new XSSFWorkbook(file);
			  
			  XSSFSheet sheet = workbook.getSheetAt(0);
			   
			  String userfirstname = sheet.getRow(0).getCell(0).getStringCellValue();
			    
			  String userlastname = sheet.getRow(0).getCell(1).getStringCellValue();
			  
			  String useremail = sheet.getRow(0).getCell(2).getStringCellValue();
			  
			  String userpassword = sheet.getRow(0).getCell(3).getStringCellValue();
			    
			  Thread.sleep(1000);
			 		  
			
				
				
			   
			   signup.firstname(userfirstname);
			 signup.lastname(userlastname);
			 signup.email(useremail);
			signup.password(userpassword);
			
			signup.DOB();
						
			Thread.sleep(500);
				signup.selectterms(); 
				signup.clickOnRegisterButton();
				Thread.sleep(2000);
		
			 
			  
			 
			 
		
	
	
	
	
	
	 String exp = "Bitte prüfen Sie Ihre Eingaben.";
	 
	 WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/main/article/div/div/div[2]/div[3]/div/div/div/div/aside/div[2]"));
      String act = message.getText();
      System.out.println("Error message is: "+ act);
      //verify error message with Assertion
      AssertJUnit.assertEquals(exp, act);
     
	
	
	if (exp.equals(act))
   {
          System.out.println("Verification Successful - User is not successfully logged in to the application");
   }
   else
   {
          System.out.println("Verification Failed - User is  logged in to the application");
   }
			  
			   
					  
			  
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
	

	

}

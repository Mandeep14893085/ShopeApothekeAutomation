/**
 * 
 */
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Mandeep
 *
 */
public class SignUp {

	
WebDriver driver;

    By becomeMember=By.name("register");
	By gender=By.xpath("/html/body/div[1]/div/div[5]/main/article/div/div/div[2]/div[3]/div/div/div/form/div[1]/fieldset/ul/li[1]/label/span");
	By firstname=By.id("firstName");
	By lastname=By.id("lastName");
	By email=By.name("email");
	By password=By.id("registerForm-password");
	By date=By.xpath("/html/body/div[1]/div/div[5]/main/article/div/div/div[2]/div[3]/div/div/div/form/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div[1]/div[2]");
	By month=By.xpath("/html/body/div[1]/div/div[5]/main/article/div/div/div[2]/div[3]/div/div/div/form/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div[1]/div[2]");
	By year=By.xpath("/html/body/div[1]/div/div[5]/main/article/div/div/div[2]/div[3]/div/div/div/form/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]");
	By terms=By.xpath("/html/body/div[1]/div/div[5]/main/article/div/div/div[2]/div[3]/div/div/div/form/ul[3]/li[2]/label/span");
	By registerButton=By.id("register-submit-btn");
	
	public SignUp(WebDriver driver)
	{
	this.driver=driver;
	}
	
	public void becomeMember()
	{
	driver.findElement(becomeMember).click();
	}
	
	public void slectgender()
	{
	driver.findElement(gender).click();
	}
	
	public void firstname(String Firstname)
	{
		driver.findElement(firstname).sendKeys(Firstname);
	}
	
	public void lastname(String Lastname)
	{
		driver.findElement(lastname).sendKeys(Lastname);
	}
	
	public void email(String Email)
	{
		driver.findElement(email).sendKeys(Email);
	}
	
	public void password(String Password)
	{
		driver.findElement(password).sendKeys(Password);
	}
	
	public void DOB() throws InterruptedException
	{
		driver.findElement(date).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/main/article/div/div/div[2]/div[3]/div/div/div/form/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div[2]")).click();
	
		driver.findElement(month).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/main/article/div/div/div[2]/div[3]/div/div/div/form/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]")).click();
		
		driver.findElement(year).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/main/article/div/div/div[2]/div[3]/div/div/div/form/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[3]")).click();
		
	}
		
	public void selectterms()
	{
		driver.findElement(terms).click();
	}
	
	
	
	public void clickOnRegisterButton()
	{
		driver.findElement(registerButton).click();
	}
	
	
}

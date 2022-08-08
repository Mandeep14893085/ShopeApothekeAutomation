/**
 * 
 */
package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Mandeep
 * 
 * This class will store all the locators and methods of login page
 *
 */
public class LoginPage {
	
	WebDriver driver;
	
	By username=By.id("loginForm-eMail");
	By password=By.id("loginForm-password");
	By loginButton=By.name("loginForm-submit-button");

	
	public LoginPage(WebDriver driver)
	{
	this.driver=driver;
	}
	
/*	public void loginToShopApotheke(String userid,String pass)
	{
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}*/
	
	
	public void typeusername(String uid)
	{
	driver.findElement(username).sendKeys(uid);
	}
	
	public void typePassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	public void clickOnLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
}

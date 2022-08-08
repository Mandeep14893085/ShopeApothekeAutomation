package Tests;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class BrowserFactory {
	
	static WebDriver driver;
	 
	
	@BeforeMethod
	public void  startBrowser() throws InterruptedException
	{
		
		String projectlocation=System.getProperty("user.dir");	
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\saingur\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		//driver=new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\saingur\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",projectlocation+"/Drivers/chromedriver/chromedriver.exe");
		driver=new ChromeDriver();
		
		//System.setProperty("webdriver.ie.driver","C:\\Users\\saingur\\Downloads\\IEDriverServer_x64_4.3.0\\IEDriverServer.exe");
	//	 driver=new InternetExplorerDriver();
		
		
	    driver.manage().window().maximize();
	    
		Thread.sleep(1000);
		
		//Redirecting link
		driver.get("https://www.shop-apotheke.com/nx/login/");
		Thread.sleep(5000);
		
			/*	WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(50));
       
				 webdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]//div/div/div/div/div/div/div[2]/div/div/div[2]/div/button[2]")));
              // click on the compose button as soon as the "compose" button is visible
       driver.findElement(By.xpath("/html/body/div[4]//div/div/div/div/div/div/div[2]/div/div/div[2]/div/button[2]")).click();*/
		
				
	}
	
	 public void getscreenshot() throws Exception 
     {
             File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             
          //The below method will save the screen shot in d drive with name "screenshot.png"
             FileUtils.copyFile(source, new File("./Screenshots/errorpage.png"));
             
             }
	

}

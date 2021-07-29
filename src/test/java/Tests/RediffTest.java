package Tests;


import org.testng.annotations.Test;
import util.WebDriverMethods;
import util.WebElementMethods;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class RediffTest 
{
  WebDriver driver;
  
  @BeforeClass(alwaysRun=true)
  public void beforeClass()
  {
	  driver=WebDriverMethods.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
  }
  
  @Test(priority=0)
  public void VerifyLogo() 
  {
	  String logo=driver.findElement(By.cssSelector("div.logtext")).getText();
	  if(logo.equals("rediffmail"))
	  {
		  Reporter.log("Logo text apprearded as expected");
	  }
	  else
	  {
		  Reporter.log("Incorrect logo text");
	  }
  }
 /* @Parameters({"uid","password"})
  @Test(groups="Top")
  public void loginWithInvalid(String uid,String password) 
  
  {
	    WebElementMethods.enterText(driver, By.id("login1"),uid);
		WebElementMethods.enterText(driver, By.id("password"),password);
		WebElementMethods.clickButton(driver, By.className("signinbtn"));
  }*/
  
  @Test(groups="Top")
  public void loginWithInvalid()
  
  {
	    WebElementMethods.enterText(driver, By.id("login1"),"testuser");
		WebElementMethods.enterText(driver, By.id("password"),"testpass");
		WebElementMethods.clickButton(driver, By.className("signinbtn"));
  }
  @Test(priority=1)
  public void gotoRegistration()
  {
	  driver.findElement(By.linkText("Create a new account")).click();
	  String title=driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr[1]/td")).getText();
	  if(title.equals("Create a Rediffmail Account"))
	  {
		  Reporter.log("Title appeared as expected");
	  }
	  else
	  {
		  Reporter.log("Incorrect title");
	  }	 
	  driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
  }
 /* @Test
  public void TC3ResetPassword()
  {
	  driver.findElement(By.linkText("Forgot Password?")).click();
	  driver.findElement(By.id("txtlogin")).sendKeys("Ranjana");
	  driver.findElement(By.name("next")).click();
  }*/
  
  
  @AfterClass(alwaysRun=true)
   public void afterClass()
  {
	  driver.close();
  }

}


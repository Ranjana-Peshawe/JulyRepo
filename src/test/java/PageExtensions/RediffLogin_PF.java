package PageExtensions;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RediffLogin_PF
{
   @FindBy(id="login1")
   private WebElement txtusername;
   
   @FindBy(id="password")
   private WebElement txtpassword;
   
   @FindBy(name="proceed")
   private WebElement btnsignin;
   
   @FindBy(linkText="Create a new account")
   private WebElement linkcreateacc;
   
   
   @FindBy(css="div#div_login_error")
  	WebElement lblerror;
   
   public RediffLogin_PF(WebDriver driver)
   {
	// TODO Auto-generated constructor stub
	   PageFactory.initElements(driver, this);
   }
   
   public void login(String username,String password)
   {
	   txtusername.sendKeys(username);
	   txtpassword.sendKeys(password);
	   btnsignin.click();
   }
   public void clearData()
   {
	   txtusername.clear();
	   txtpassword.clear();
   }
  
public void validateError()
	{
		String acterror = lblerror.getText();
		Assert.assertEquals(acterror, "Wrong username and password combination.");
	}
   public void gotoRegistration()
   {
	   linkcreateacc.click();
   }
}

package PageExtensions;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffReg_PF
{
   @FindBy(css="input[name^='name']")
   private WebElement txtfullname;
   
   @FindBy(css="input[name^='login']")
   private WebElement txtemail;
   
   @FindBy(css="input[name^='passwd']")
   private WebElement txtpassword;
   
   @FindBy(css="input[name^='gender']")
   List<WebElement> rbgender;
   
   public RediffReg_PF(WebDriver driver)
   {
	// TODO Auto-generated constructor stub
	   PageFactory.initElements(driver, this);
   }
   
   public void register(String fullname,String email,String password,String gender)
   {
	 txtfullname.sendKeys(fullname);
	 txtemail.sendKeys(email);
	 txtpassword.sendKeys(password);
	 
	 for(WebElement rb:rbgender)
	 {
		if(rb.getText().equals(gender)) 
		{
			rb.click();
			break;
		}
	 }
   }
   
   
}

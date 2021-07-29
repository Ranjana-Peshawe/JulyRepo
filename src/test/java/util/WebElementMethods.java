package util;


import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;;

public class WebElementMethods
{
     public static void enterText(WebDriver driver,By locator,String text)
     {
    	 try
    	 {
    		 WebElement textbox=driver.findElement(locator);
    		 textbox.sendKeys(text);
    	 }
    	 catch(NoSuchElementException e)
    	 {
    		 System.out.println("Element not found on the page");
    	 }
     }
     public static void clickButton(WebDriver driver,By locator)
     {
    	 try
    	 {
    		 WebElement button=driver.findElement(locator);
    		 button.click();
    	 }
    	 catch(NoSuchElementException e)
    	 {
    		 System.out.println("Element not found on the page");
    	 }
     }
     
     public static void selectCheckBox(WebDriver driver, By locator, String value) 
 	 {
 		try {
 			List<WebElement> chkboxes = driver.findElements(locator);		
 			for(WebElement ch : chkboxes)
 			{
 				if(ch.getAttribute("value").toLowerCase().equals(value.toLowerCase()))
 				{
 					if(!ch.isSelected())
 					{
 						ch.click();
 						break;
 					}
 				}
 			}
 		}
 		catch (NoSuchElementException e) {
 			System.out.println("Element not found on the page");
 		}		
 		
 	 }
 	
 	public static void selectRadio(WebDriver driver, By locator, String value) 
 	 {
 		try {
 			List<WebElement> radios = driver.findElements(locator);		
 			for(WebElement rb : radios)
 			{
 				if(rb.getAttribute("value").equalsIgnoreCase(value))
 				{					
 						rb.click();
 						break;
 					
 				}
 			}
 		}
 		catch (NoSuchElementException e) {
 			System.out.println("Element not found on the page");
 		}			
 	 }
     public static void selectDDByText(WebDriver driver,By locator,String option)
     {
    	 boolean flag=false;
    	 Select dd=new Select(driver.findElement(locator));
 		List<WebElement> options=dd.getOptions();
 		for(WebElement op:options)
 		{
 			if(op.getText().equalsIgnoreCase(option))
 			{	
 			    dd.selectByVisibleText(option);	
 			    flag=true;
 			    break;
 			}
 		}
 		if(flag==true)
        {
        	System.out.println("Item Selected");
        }
        else
        {
        	System.out.println("Item can not be Selected: plz check the option you selected");
        }
     }
     public static void selectDDByValue(WebDriver driver,By locator,String option)
     {
    	 boolean flag=false;
    	 Select dd=new Select(driver.findElement(locator));
 		List<WebElement> options=dd.getOptions();
 		for(WebElement op:options)
 		{
 			if(op.getText().equalsIgnoreCase(option))
 			{	
 			    dd.selectByValue(option);	
 			    flag=true;
 			    break;
 			}
 		}
 		if(flag==true)
        {
        	System.out.println("Item Selected");
        }
        else
        {
        	System.out.println("Item can not be Selected: plz check the option you selected");
        }
     }
     
}

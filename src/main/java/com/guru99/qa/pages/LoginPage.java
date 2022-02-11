package com.guru99.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.guru99.qa.base.TestBase;
public class LoginPage {
	public static WebDriver driver;
	@FindBy(xpath="//input[@name='uid']")
	WebElement userID;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginbtn;
	
	@FindBy (xpath="//a[contains(text(),'Log out')]")
	WebElement linkLogout;
	
	public LoginPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this); 
	
	}
	
	public void setUserID(String user) {
		userID.sendKeys(user);
	
	}
	public void setPassword(String pwd) {
		pass.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		loginbtn.click();
	}
	public void clickLogout()
	{
		linkLogout.click();
	}

	

}

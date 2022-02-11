package com.guru99.qa.pagesTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBase;
import com.guru99.qa.pages.LoginPage;

@Listeners(com.guru99.qa.utilities.ListenerTest.class)
public class TC_LoginPageTest_001 extends TestBase {
	@Test(priority=1)
	public void LoginPage_TC001() throws IOException {
		
		if(driver.getTitle().equals("Guru99 Bank Home Page123"))
		{
			Assert.assertTrue(true);
		logger.info("LoginPage test 001 is passed");
	    }else
	    {
	    	captureScreen(driver, "LoginPage_TC001");
	    	Assert.assertFalse(false);
	    	logger.info("LoginPage test 001 is failed");
	    }
	}
	@Test(priority=2)
	public void LoginPage_TC002() throws IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserID(user);
		logger.info("User id is Entered");
		lp.setPassword(pwd);
		logger.info("Password is entered");
		lp.clickLoginBtn();
		logger.info("Clicked on login button");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage1"))
		{
			Assert.assertTrue(true);
		logger.info("LoginPage test 002 is passed");
	    }else
	    {
	    	captureScreen(driver, "LoginPage_TC002");
	    	Assert.assertFalse(false);
	    	logger.info("LoginPage test 002 is failed");
	    }
		
	}
}

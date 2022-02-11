package com.guru99.qa.pagesTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBase;
import com.guru99.qa.pages.AddCustomerPage;
import com.guru99.qa.pages.LoginPage;

public class TC_AddCustomerTest_003 extends TestBase{
	
	@Test(priority=-1)
	public void addNewCustomer() {
	LoginPage lpage=new LoginPage(driver);
	lpage.setUserID(user);
	logger.info("entered user id");
	lpage.setPassword(pwd);
	logger.info("entered password");
	lpage.clickLoginBtn();
	logger.info("clicked on login button");
	
	AddCustomerPage addcust=new AddCustomerPage(driver);
	addcust.clickAddNewCustomer();
	addcust.custName("Rekha");
	addcust.custgender("Female");
	addcust.custdob("10", "10", "1992");
	addcust.custaddress("Hinjewadi phase 1");
	addcust.custcity("Pune");
	addcust.custstate("Maharashtra");
	addcust.custpinno("410057");
	addcust.custtelephoneno("7503573033");
	String email=randomString()+"@gmail.com";
	addcust.custemailid(email);
	//addcust.custemailid("rekhachaurasiya123@gmail.com");
	addcust.custpassword("aggsjdk");
	addcust.custsubmit();
	
	boolean succussmsg=driver.getPageSource().contains("Customer Registered Successfully!!!");
	if(succussmsg==true)
	{
		Assert.assertTrue(true);
		logger.info("Test case is passed....");
	}
	else
	{
		logger.info("Test case is failed.....");
		captureScreen(driver, "addNewCustomer");
		Assert.assertTrue(false);
		
	}

	}
	
	public String randomString() {
		String generaterandomString= RandomStringUtils.randomAlphabetic(8);
		return generaterandomString;
	}
	
	

}

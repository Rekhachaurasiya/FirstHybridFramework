package com.guru99.qa.pagesTest;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBase;
import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.utilities.ExcelUtil;

public class TC_LoginPage_DDT_002 extends TestBase {
	@Test(dataProvider="LoginPageDDT")
	public void loginPageDDT(String user,String pwd) {
		LoginPage lp=new LoginPage(driver);
		lp.setUserID(user);
		logger.info("user id entered");
		lp.setPassword(pwd);
		logger.info("Password is entered");
		lp.clickLoginBtn();
		logger.info("cliked on login button");
		lp.clickLogout();
		logger.info("Clicked on logout link");
		
	    if(isAlertPresent()==true) {
	    	driver.switchTo().alert().accept();
	    	driver.switchTo().defaultContent();
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    	lp.clickLogout();
	    	driver.switchTo().alert().accept();
	    	driver.switchTo().defaultContent();
	    }
	}
		public boolean isAlertPresent() {
			try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
					
	}

	
	@DataProvider(name="LoginPageDDT")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guru99\\qa\\testData\\LoginPageData.xlsx";
		int rownum=ExcelUtil.getRowCount(path, "sheet1");
		int colcount=ExcelUtil.getCellCount(path, "sheet1", 1);
		String[][] logindata=new String[rownum][colcount];
		for(int i=0;i<rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i][j]=ExcelUtil.getCellData(path, "sheet1", i, j);
				System.out.println(logindata[i][j]);
			}
		}
		return logindata;
	}
	
}
	
	
	

package com.guru99.qa.base;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.guru99.qa.utilities.ReadConfig;

public class TestBase {
	public static WebDriver driver;
	ReadConfig readConfig=new ReadConfig();
	public String baseUrl=readConfig.getURL();
	public String user=readConfig.getusername();
	public String pwd=readConfig.getPass();
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String brwsr) {
		if(brwsr.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readConfig.getChrome());
			driver = new ChromeDriver();
			logger=Logger.getLogger("guru99");
			PropertyConfigurator.configure("Log4j.properties");
		  
		}
		else if(brwsr.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",readConfig.getFireFox());
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
		logger.info("URL is opened");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		//driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String testname) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+testname+".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot taken");
		logger.info("Screenshot has taken");
		
	}
	
		

}

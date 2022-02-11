package com.guru99.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	public static Properties prop;
	
	public ReadConfig(){
	File scr=new File("./Configuration/config.properties");
	try {
		FileInputStream fis=new FileInputStream(scr);
		 prop=new Properties();
		 prop.load(fis);
	}catch(Exception e)
	{
		e.printStackTrace();
	}	
}
	public String getURL() {
		String url=prop.getProperty("baseUrl");
		return url;	
	}
	public String getusername() {
		String getusername=prop.getProperty("user");
		return getusername;	
	}
	public String getPass() {
		String pswd=prop.getProperty("pwd");
		return pswd;	
	}
	public String getChrome() {
		String chromeBrowser=prop.getProperty("chrome");
		return chromeBrowser;	
	}
	public String getFireFox() {
		String FireFox=prop.getProperty("Firefox");
		return FireFox;	
	}
	
}

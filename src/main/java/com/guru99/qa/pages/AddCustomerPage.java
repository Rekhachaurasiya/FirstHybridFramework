package com.guru99.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//a[contains(text(),'New Customer')]")
	WebElement InkAddNewCustomer;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement txtCustomerName;

	@FindBy(xpath= "//input[@value='f']")
	WebElement rdGender;

	@FindBy(xpath= "//input[@id='dob']")
	WebElement txtdob;

	@FindBy(xpath= "//textarea[@name='addr']")
	WebElement txtaddress;

	@FindBy(xpath= "//input[@name='city']")
	WebElement txtcity;

	@FindBy(name = "state")
	WebElement txtstate;

	@FindBy(name= "pinno")
	WebElement txtpinno;

	@FindBy(name= "telephoneno")
	WebElement txttelephoneno;

	@FindBy(name= "emailid")
	WebElement txtemailid;

	@FindBy(name= "password")
	WebElement txtpassword;
	
	@FindBy (name = "sub")
	WebElement btnSubmit;
	   
	public void clickAddNewCustomer () {
	    InkAddNewCustomer.click();
	}

	public void custName(String cname){
	    txtCustomerName.sendKeys(cname);
	}
	public void custgender (String cgender) {
	    rdGender.click();
	}
	public void custdob(String mm,String dd,String yy) {
	    txtdob.sendKeys (mm);
	    txtdob.sendKeys(dd);
	    txtdob.sendKeys (yy);
	}
	public void custaddress (String caddress) {
	    txtaddress.sendKeys(caddress);
	}
	public void custcity(String ccity) {
	   txtcity.sendKeys(ccity);
	}
	public void custstate(String cstate) {
	   txtstate.sendKeys(cstate);
	}
	public void custpinno(String cpinno) {
		//txtpinno.sendKeys(cpinno);
	    txtpinno.sendKeys(String.valueOf(cpinno));
	}
	public void custtelephoneno(String ctelephoneno) {
	   txttelephoneno.sendKeys (ctelephoneno);
	}
	public void custemailid(String cemailid) {
	   txtemailid.sendKeys (cemailid);
	}
	public void custpassword(String cpassword) {
	    txtpassword.sendKeys (cpassword);
	}
	public void custsubmit() {
	    btnSubmit.click();
	}

}
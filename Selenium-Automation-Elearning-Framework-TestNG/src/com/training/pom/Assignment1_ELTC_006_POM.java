package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Assignment1_ELTC_006_POM {
	
		private WebDriver driver; 
		
		public Assignment1_ELTC_006_POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="login")
		private WebElement userName; 
		
		@FindBy(id="password")
		private WebElement password;
		
		@FindBy(xpath="//button[@id='form-login_submitAuth']")
		private WebElement loginBtn; 
		
		@FindBy(xpath="//section[@id='cm-content']//p[1]")
		private WebElement actualtext;
		
		String Expected="Hello Jayashree1 Bhukele1 and welcome,";
		
		public void sendUserName(String userName) {
			this.userName.clear();
			this.userName.sendKeys(userName);
		}
		
		public void sendPassword(String password) {
			this.password.clear(); 
			this.password.sendKeys(password); 
		}
		
		public void clickLoginBtn() {
			this.loginBtn.click(); 
		}
		public void assertpagetitle()
		{
			Assert.assertEquals(actualtext.getText(), Expected);
		}
	}




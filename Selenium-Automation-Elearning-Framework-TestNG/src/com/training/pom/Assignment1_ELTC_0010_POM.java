package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Assignment1_ELTC_0010_POM {
private WebDriver driver; 
	
	public Assignment1_ELTC_0010_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	
	//locating login button
	@FindBy(xpath="//button[@id='form-login_submitAuth']")
	private WebElement loginBtn; 
	
	
	//Locating course catalog
	@FindBy(linkText="Course catalog")
	private WebElement coursecatalog;
	
	//Locating search textbox
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement searchtextbox; 
	

		//Locating searchbutton
	@FindBy(xpath="//div[@class='input-group']//button[1]")
	private WebElement searchButton;
	
	@FindBy(xpath="//strong[contains(text(),'Search results for: oracle')]")
	private WebElement assertText;
	
	
	
	//entering username
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	//entering password
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//click on login button
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	//clicking course icon
	public void clickcoursecatalog()
	{
		this.coursecatalog.click();
	}
	//entering search criteria
	public void search(String course)
	{
		this.searchtextbox.sendKeys(course);
	}
	//clicking search button
	public void clickSearchButton ()
	{
		this.searchButton.click()  ;
		
	}
	
	public void assertingupdates()
	{
		String actual=this.assertText.getText();
		String expected ="Search results for: oracle";
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion passed");
	}
}


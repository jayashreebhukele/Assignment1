package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Assignment1_ELTC_009_POM {
private WebDriver driver; 
	
	public Assignment1_ELTC_009_POM(WebDriver driver) {
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
	
	
	//Locating course icon
	@FindBy(css="main.section-mycourses:nth-child(1) div.container div.row div.col-md-9.col-md-push-3 "
			+ "div.page-content div.classic-courses div.panel.panel-default:nth-child(9) "
			+ "div.panel-body div.row div.col-md-10 h4.course-items-title > a:nth-child(1)")
	private WebElement courseicon;
	
	//Locating user icon
	@FindBy(linkText="Users")
	private WebElement usericon; 
	
	//Locating user1 which is going to unsubscribe
	String user;
		//Locating checkbox of user
	@FindBy(xpath="//tr[2]//td[1]//input[1]")
	private WebElement checkbox;
	
	//Locating unsubscribe button
	@FindBy(xpath="//tr[@class='row_even row_selected']//a[@class='btn btn-small btn-danger'][contains(text(),'Unsubscribe')]")
	private WebElement unsubscribebutton;
	
	//Locating content textbox
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement contenttextbox;
	
	//Locating update stmt
		@FindBy(xpath="//div[@class='alert alert-info']")
		private WebElement assertupdatestmt;
	
	
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
	public void clickcourseIcon()
	{
		this.courseicon.click();
	}
	//clicking user icon
	public void clickUserIcon()
	{
		this.usericon.click();
	}
	
	public void getUser()
	{
		user=driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]"
				+ "/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]")).getText();
		
	}
	//clicking Description icon on new page
	public void selectCheckbox()
	{
		this.checkbox.click();
	}
    //selecting unscribe button
	public void clickUnsubscribebutton()
	{
		this.unsubscribebutton.click();
	}
	
	//asserting the updation
	public void assertingupdates()
	{
		String actual=this.assertupdatestmt.getText();
		String expected ="User is now unsubscribed";
		Assert.assertEquals(actual, expected);
	}
	int i=0;
	public void assertinguserunsubscription()
	{
		driver.navigate().refresh();
	    List <WebElement> row= driver.findElements(By.xpath("/html[1]/body[1]/main[1]/section[1]/"
			+ "div[1]/form[1]/div[1]/table[1]/tbody[1]/tr"));
	    int rowcount=row.size();
	
	     for(int i=2;i<rowcount;i++)
	     {
		      String username= driver.findElement(By.xpath("/html[1]/body[1]/main[1]/"
				+ "section[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]")).getText();
		
		      if(user==username)
		       {
			     i++;
		        }
		}
	     if(i==0)
	     {
	    	 System.out.println("user "+user+ " unsubscribed successfully");
	     }
	     else
	     {
	    	 System.out.println("user unsubscription failed");
	     }
}
}
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment1_ELTC_008_POM {
private WebDriver driver; 
	
	public Assignment1_ELTC_008_POM(WebDriver driver) {
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
	@FindBy(css="main.section-mycourses:nth-child(1) div.container div.row"
			+ " div.col-md-9.col-md-push-3 div.page-content div.classic-courses div"
			+ ".panel.panel-default:nth-child(7) div.panel-body div.row div.col-md-2 > a.thumbnail")
	private WebElement courseicon;
	
	//Locating course description icon
	@FindBy(linkText="Course description")
	private WebElement descriptionicon; 
	
	//	//Locating description icon on new screen
	@FindBy(xpath="//div[@id='toolbar']//a[1]//img[1]")
	private WebElement descriptionicon1;
	
	//Locating title textbox
	@FindBy(id="course_description_title")
	private WebElement titletextbox;
	
	//Locating content textbox
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement contenttextbox;
	
	//locating save button
	@FindBy(id="course_description_submit")
	private WebElement savebutton;
	
	@FindBy(xpath="//*[contains(text(),'The description has been updated')]")
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
	//clicking Description icon
	public void clickDescriptionIcon()
	{
		this.descriptionicon.click();
	}
	//clicking Description icon on new page
	public void clickDescriptionIcon1()
	{
		this.descriptionicon1.click();
	}
	//entering title
	public void sendTitle(String title)
	{
		this.titletextbox.clear();
		this.titletextbox.sendKeys(title);
		
	}
   //entering content
	public void sendContent(String content)
	{
		this.contenttextbox.clear();
		this.contenttextbox.sendKeys(content);
		
	}
	//click on save button
	public void clickSave()
	{
		this.savebutton.click();
	}
	
	//asserting the updation
	public void assertingupdates()
	{
		String actual=this.assertupdatestmt.getText();
		String expected ="The description has been updated";
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion passed");
	}
}

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment1_ELTC_007_POM {
	private WebDriver driver; 
	
	public Assignment1_ELTC_007_POM(WebDriver driver) {
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
	
	//locating welcome text for user logged in
	//@FindBy(xpath="//section[@id='cm-content']//p[1]")
	//private WebElement actualtext;
	
	//String Expected="Hello Jayashree Bhukele and welcome,";
	
	//Locating create course link
	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement createcourse;
	
	//Locating coursename Text box
	@FindBy(xpath="//input[@id='title']")
	private WebElement coursename;
	
	//locating advanced setting button
	@FindBy(xpath="//button[@id='advanced_params']")
	private WebElement advancesetting;
	
	//locating category listbox
	@FindBy(xpath="//select[@id='add_course_category_code']")
	private WebElement category;
	
	//locating search box to enter category
	////@FindBy(xpath="//div[@class='bs-searchbox']//input[@class='form-control' and @xpath='1']")
	//private WebElement categoryinsearchbox;
	
	@FindBy(xpath="//input[@id='add_course_wanted_code']")
	private WebElement coursecode;
	
	//locating language dropdown
	@FindBy(xpath="//select[@id='add_course_course_language']")
		private WebElement language;
	
	//Locating createcourse button
	@FindBy(xpath="//button[@id='add_course_submit']")
	private WebElement createcoursebutton;

	
	//locating add introduction texticon
	@FindBy(xpath="//div[@class='help-course']//a[@class='btn btn-default']")
	private WebElement introtexticon;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement frame1;
	
	//Locating courseintrotext
	@FindBy(css="body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:nth-child(2) > p:nth-child(1)")
	private WebElement introtext;
	
	
	//Locating save intro text button
	@FindBy(id="introduction_text_intro_cmdUpdate")
	private WebElement saveintrotextbutton;
	
	
	//Locating entered intro text
	@FindBy(xpath="//div[@class='col-md-12']//div[@class='page-course']//p")
	private WebElement enteredintrotext;
	
	
	//Locating update successful text
	@FindBy(xpath="//div[contains(text(),'Intro was updated')]")
	private WebElement updatesuccess;
	
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
	
	//asserting page title
	/*public void assertpagetitle()
	{
		Assert.assertEquals(actualtext.getText(), Expected);
	}*/
	
	//clicking on create course link
	public void clickCreateCourseLink()
	{
		this.createcourse.click();
		
	}
	
	//entering course name
	public void sendCourseName( String course)
	{
		this.coursename.sendKeys(course);
	}
	
	//click on advanced setting button
	public void clickadvancedsetting( )
	{
		this.advancesetting.click();
	}
	
	//selecting option in category dropdown
	public void selectcategoryoption()
	{
		//this.category.click();
	    Select select =new Select(category);
		select.selectByVisibleText("Projects (PR001)");	                 
	}
	
	/*public void sendcategorysearchbox(String category)
	{
		this.categoryinsearchbox.sendKeys(category);
		
	}*/
	//selecting course code
	public void sendcoursecode(String ccode)
	{
		this.coursecode.sendKeys(ccode);
	}
	public void selectlanguage()
	{
		Select select =new Select(language);
		select.selectByVisibleText("English");
	}
	public void clickCreatecoursebutton()
	{
		
		this.createcoursebutton.click();
	}
	
	public void clickintrotextIcon()
	{
		
		this.introtexticon.click();
	}
	
	public void sendIntroText(String text)
	{
		
		this.introtext.sendKeys(text);
	}
	
	public void clickSaveIntroText()
	{
		this.saveintrotextbutton.click();
	}
	
	public void assertintrotext(String expected1,String expected2)
	{
		String actual1=enteredintrotext.getText();
		String actual2=updatesuccess.getText();
		Assert.assertEquals(actual1,expected1);
		Assert.assertEquals(actual2, expected2);
	}
	
	
}



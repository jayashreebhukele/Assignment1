package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Assignment1_ELTC_007_POM;
import com.training.pom.Assignment1_ELTC_008_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Assignment1_ELTC_008_Test {

	private WebDriver driver;
	private String baseUrl;
	private Assignment1_ELTC_008_POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;  
	JavascriptExecutor js;
	int i=0;
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new Assignment1_ELTC_008_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		js=(JavascriptExecutor)driver;
	
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("jayashree");
		loginPOM.sendPassword("jayashree@123");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("Assignment1_ELTC_008"+i);
		i++;
	
		//clicking on course icon
		js.executeScript("window.scrollBy(0,450)");
		
		//clicking course icon created by user
		loginPOM.clickcourseIcon();
		js.executeScript("window.scrollBy(0,350)");
		screenShot.captureScreenShot("Assignment1_ELTC_008"+i);
		i++;
		
		//clicking description icon 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		loginPOM.clickDescriptionIcon();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		screenShot.captureScreenShot("Assignment1_ELTC_008"+i);
		i++;
		
		//clicking description icon on new page
		loginPOM.clickDescriptionIcon1();
		screenShot.captureScreenShot("Assignment1_ELTC_008"+i);
		i++;
		
		js.executeScript("window.scrollBy(0,300)");
		//entering title
		loginPOM.sendTitle("Selenium course for beginner");
		screenShot.captureScreenShot("Assignment1_ELTC_008"+i);
		i++;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		//switching the frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		loginPOM.sendContent("This is the course for the beginners");
		screenShot.captureScreenShot("Assignment1_ELTC_008"+i);
		i++;
		
		//switching to default frame
		driver.switchTo().defaultContent();
		
	    //saving updates
		loginPOM.clickSave();
		
		//asserting the updates
		loginPOM.assertingupdates();
	
		}
}

package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.Assignment1_ELTC_007_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class Assignment1_ELTC_007_Test {
	
		private WebDriver driver;
		private String baseUrl;
		private Assignment1_ELTC_007_POM loginPOM;
		private static Properties properties;
		private ScreenShot screenShot;
		int i=0;
		JavascriptExecutor js;
		Actions act;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

		@BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new Assignment1_ELTC_007_POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
			js=(JavascriptExecutor)driver;
			act=new Actions(driver);
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
			//loginPOM.assertpagetitle();
			screenShot.captureScreenShot("Assignment1_ELTC_007"+i);
			i++;
		    js.executeScript("window.scrollBy(0,650)");
			//js.executeScript("document.getElementBy('Create a course').scrollIntoView()");
			loginPOM.clickCreateCourseLink();
			screenShot.captureScreenShot("Assignment1_ELTC_007"+i);
			i++;
			//Sending course name
			loginPOM.sendCourseName("Selenium advance course");
			//clicking on advanced setting button
			loginPOM.clickadvancedsetting( );
			//selecting Category
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
			loginPOM.selectcategoryoption();
				
			//entering coursecode
			js.executeScript("window.scrollBy(0,450)");
			loginPOM.sendcoursecode("sel54");
			
			//selecting language
			loginPOM.selectlanguage();
			
			//click on create course button
			loginPOM.clickCreatecoursebutton();
			screenShot.captureScreenShot("Assignment1_ELTC_007"+i);
			i++;
			
			//clicking on intro text icon
			loginPOM.clickintrotextIcon();
			screenShot.captureScreenShot("Assignment1_ELTC_007"+i);
			i++;
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
			
			//switching the frame
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
			
			//enter text in introtext textbox
			loginPOM.sendIntroText("This is a Selenium advance Course");
			screenShot.captureScreenShot("Assignment1_ELTC_007"+i);
			i++;
			
			//switching to default frame
			driver.switchTo().defaultContent();
			
			//click on save intro text
			loginPOM.clickSaveIntroText();
			screenShot.captureScreenShot("Assignment1_ELTC_007"+i);
			
			//asserting the text
			loginPOM.assertintrotext("This is a Selenium Course","Intro was updated");
				
		}

	}


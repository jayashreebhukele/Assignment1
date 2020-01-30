package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.Assignment1_ELTC_009_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Assignment1_ELTC_009_Test {
	private WebDriver driver;
	private String baseUrl;
	private Assignment1_ELTC_009_POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;  
	JavascriptExecutor js;
	int i=0;
	Alert alert;
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new Assignment1_ELTC_009_POM(driver); 
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
		
		//loginPOM.assertpagetitle();
		screenShot.captureScreenShot("Assignment1_ELTC_009"+i);
		i++;
	
		//clicking on course icon
		js.executeScript("window.scrollBy(0,450)");
		//clicking course icon created by user
		loginPOM.clickcourseIcon();
		js.executeScript("window.scrollBy(0,700)");
		screenShot.captureScreenShot("Assignment1_ELTC_009"+i);
		i++;
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		
		//clicking description icon 
		loginPOM.clickUserIcon();
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		screenShot.captureScreenShot("Assignment1_ELTC_009"+i);
		i++;
		
		//capturing user name
		loginPOM.getUser();
		
		//selecting checkbox
		loginPOM.selectCheckbox();
		screenShot.captureScreenShot("Assignment1_ELTC_009"+i);
		i++;
		
		//Clicking on unsubscribe button
		loginPOM.clickUnsubscribebutton();
		Thread.sleep(1000);
		
		//Handling the alerts
		alert=driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		
		//asserting update stmt
		loginPOM.assertingupdates();
		
		//asserting the user got unsubscribed
		loginPOM.assertinguserunsubscription();
		
	}
}

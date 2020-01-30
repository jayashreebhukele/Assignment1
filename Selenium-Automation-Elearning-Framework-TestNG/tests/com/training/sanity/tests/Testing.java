package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Assignment1_ELTC_0010_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Testing {
	private WebDriver driver;
	private String baseUrl;
	private Assignment1_ELTC_0010_POM loginPOM;
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

	@BeforeTest
	void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new Assignment1_ELTC_0010_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		js=(JavascriptExecutor)driver;
	
	
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		//driver.quit();
	}
	
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("jayashree");
		loginPOM.sendPassword("jayashree@123");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		loginPOM.clickLoginBtn();
		
		//loginPOM.assertpagetitle();
		screenShot.captureScreenShot("Assignment1_ELTC_0010"+i);
		i++;
	}
	
	@Test(priority=2)
	public void searchCatalogTest()
	{
		//clicking on course icon
		js.executeScript("window.scrollBy(0,450)");
		
		//clicking course icon created by user
		loginPOM.clickcoursecatalog();
		js.executeScript("window.scrollBy(0,700)");
		screenShot.captureScreenShot("Assignment1_ELTC_0010"+i);
		i++;
		
		//Entering text in search textbox
		loginPOM.search("oracle");
		screenShot.captureScreenShot("Assignment1_ELTC_0010"+i);
		i++;
		
		//clicking description icon
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		loginPOM.clickSearchButton();
		screenShot.captureScreenShot("Assignment1_ELTC_0010"+i);
		i++;
		
		//asserting the results
		loginPOM.assertingupdates();
		
	}
}


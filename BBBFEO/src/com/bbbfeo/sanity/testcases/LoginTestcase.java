package com.bbbfeo.sanity.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.bbbfeo.sanity.basetest.BaseTest;
import com.bbbfeo.sanity.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTestcase extends BaseTest {

	@Test
	public void LoginTC(){
		report= ExtentManager.getInstance();
		test=report.startTest("Verify bbb login credentails");
		launchbrowser("Chrome");
		driver.get("http://docs.seleniumhq.org/download/");
		test.log(LogStatus.INFO, "BBB website launced successfully");
		takescreenshot("BBB Homepage dispayed");
		System.out.println("Chrome:"+driver.getTitle());
		driver.close();
		report.endTest(test);
		report.flush();
		
		
	/*	System.setProperty("webdriver.gecko.driver", "H:\\JARS\\selenium-3.7.1\\\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		FirefoxDriver ff=new FirefoxDriver();
		ff.get("http://docs.seleniumhq.org/download/");
		System.out.println("FF-"+ff.getTitle());
		ff.close();
		*/
	}
	
	
	
	
}

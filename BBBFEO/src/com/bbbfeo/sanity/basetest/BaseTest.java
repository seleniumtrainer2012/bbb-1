package com.bbbfeo.sanity.basetest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	public ExtentTest test;
	public ExtentReports report;
	public WebDriver driver;
	public void launchbrowser(String browserType){
		if(driver==null){			
			if(browserType.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
				driver=new ChromeDriver();				
			}else if(browserType.equals("FF")){
				driver=new FirefoxDriver();				
			}else if(browserType.equals("IE")){
				driver=new InternetExplorerDriver();
			}else{
				System.out.println("invalid browsertype");
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);			
		}
	}
	public void takescreenshot(String msg){
		try {
			Date d=new Date();
			String TimeStamp=d.toString().replace(" ", "_").replace(":", "_");
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			File f=screenshot.getScreenshotAs(OutputType.FILE);
			String screenshotPath=System.getProperty("user.dir")+"\\screenshots\\screenshot_"+TimeStamp+".png";
			FileUtils.copyFile(f, new File(screenshotPath));

			test.log(LogStatus.INFO,test.addScreenCapture(screenshotPath));

		} catch (IOException e) {			
			e.printStackTrace();
		}

	}
}

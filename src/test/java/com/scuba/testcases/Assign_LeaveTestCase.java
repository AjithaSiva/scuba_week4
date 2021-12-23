package com.scuba.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.scuba.pageFactory.Assign_leavePage;
import com.scuba.pageFactory.OrangeHRM_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign_LeaveTestCase {
	WebDriver driver;

	@BeforeTest
	public void Browser_open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
	}

	@Test
	public void assign_leave() throws InterruptedException {

		OrangeHRM_LoginPage login = new OrangeHRM_LoginPage(driver);
		login.typeUserName();
		login.typePassword();
		login.clickOnLoginButton();
		login.click_dashBoard();
		  Thread.sleep(5000); 
		  Assign_leavePage assign=new Assign_leavePage(driver);
		  Thread.sleep(5000); 
		  assign.ClickAssign_Leave();
		  Thread.sleep(5000);
		  assign.enter_empName("Orange Test"); 
		  assign.LeaveType();
		  assign.click_fromAndToDate(); 
		  assign.enter_comment("Vacation Leave");
		  assign.click_assignBtn();
		Thread.sleep(5000);
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        //Copy the file to a location and use try catch block to handle exception
	        try {
	            FileUtils.copyFile(screenshot, new File("C:\\Users\\ajithas\\Desktop\\Training recording\\Scuba_Training\\Selenium_week4\\Assign_leave_Screenshot.png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
		 
	}
}

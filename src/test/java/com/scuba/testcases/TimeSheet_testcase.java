package com.scuba.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.scuba.pageFactory.OrangeHRM_LoginPage;
import com.scuba.pageFactory.Submit_timesheetPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeSheet_testcase {
	WebDriver driver;

	@BeforeTest
	public void Browser_open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
	}

	@Test
	public void timeSheet_Submit() throws InterruptedException {

		OrangeHRM_LoginPage login = new OrangeHRM_LoginPage(driver);
		login.typeUserName();
		login.typePassword();
		login.clickOnLoginButton();
		login.click_dashBoard();
		  Submit_timesheetPage time=new Submit_timesheetPage(driver);
		  Thread.sleep(5000);
		  time.timesheet_Entry();
		  time.enter_ProjectName("ACME Ltd - ACME Ltd");
		  Thread.sleep(5000);
		  time.activity_Name();
		  time.enter_hour("8");
		  time.submit();
		  Thread.sleep(5000);
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        //Copy the file to a location and use try catch block to handle exception
	        try {
	            FileUtils.copyFile(screenshot, new File("C:\\Users\\ajithas\\Desktop\\Training recording\\Scuba_Training\\Selenium_week4\\Time_sheet_Screenshot.png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	}
	@Test (description = "Demonstration of softAssert in Selenium Java", priority = 6, enabled = true)
    public void Test_soft_assert() throws IOException, InterruptedException
    {
        String Value = "Status: Submitted";
        String verify = driver.findElement(By.xpath("//*[@id=\"timesheet_status\"]/h2")).getText();
 
 
        /* Create an instance of Soft Assert */
        SoftAssert softAssert = new SoftAssert();
        /* This raises an assert but does not throw an exception since it is a Soft Assert */
        softAssert.assertEquals(Value, verify);
                Thread.sleep(2000);
        System.out.println("SoftAssert Test Passed\n");
    }
}

package com.scuba.pageFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mongodb.MapReduceCommand.OutputType;

public class OrangeHRM_LoginPage {
	WebDriver driver;
	
    //Locators
	By username = By.id("txtUsername");
	By password = By.name("txtPassword");
	By loginButton = By.xpath("//input[@name='Submit']");
	By forgotYourNames = By.xpath("//a[contains(text(),'Forgot your password?')]");
	By dashBoard=By.xpath("//*[@id=\"menu_dashboard_index\"]/b");
	
	// constructor invoked at the time of object creation, pass driver chrome/firefox/safari..
	public OrangeHRM_LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	public void typeUserName()
	{
		driver.findElement(username).sendKeys("Admin");
		
	}
	public void typePassword()
	{
		driver.findElement(password).sendKeys("admin123");
		
	}
	public void clickOnLoginButton()
	{
		driver.findElement(loginButton).click();
		
	}
	public void click_dashBoard()
	{
  driver.findElement(dashBoard).click();
	}
	


}

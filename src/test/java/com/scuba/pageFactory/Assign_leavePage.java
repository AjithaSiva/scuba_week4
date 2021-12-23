package com.scuba.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Assign_leavePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'Assign Leave')]")
	WebElement assign_leave;
	
	@FindBy(id="assignleave_txtEmployee_empName")
	WebElement empName;	
	
	@FindBy(id="assignleave_txtLeaveType")
	WebElement leaveType;
	
	@FindBy(xpath="//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[4]/img")
	WebElement fromDate;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[4]/a")
	WebElement pickfromDate;
	
	@FindBy(xpath="//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[5]/img")
	WebElement toDate;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[4]/a")
	WebElement picktoDate;
	
	@FindBy(id="assignleave_txtComment")
	WebElement comment;
	
	@FindBy(id="assignBtn")
	WebElement click_assign;
	
	
	public Assign_leavePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void ClickAssign_Leave()
	{
		assign_leave.click();
	}
	
	public void enter_empName(String setEmpname) {
		empName.sendKeys(setEmpname);
	}
	
	public void LeaveType() {
		Select option=new Select(leaveType);
		option.selectByValue("6");
	}
	
	public void click_fromAndToDate()
	{
		fromDate.click();
		pickfromDate.click();
		toDate.click();
		picktoDate.click();
	}
	
	public void enter_comment(String addcomment)
	{
		comment.sendKeys(addcomment);
	}
	
	public void click_assignBtn()
	{
		click_assign.click();
	}

}

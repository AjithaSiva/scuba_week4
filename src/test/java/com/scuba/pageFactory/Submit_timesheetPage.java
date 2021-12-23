package com.scuba.pageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Submit_timesheetPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[6]/div/a/img") 
	WebElement time_entry;
	
	@FindBy(id="btnEdit")
	WebElement editBtn;
	
	@FindBy(name="initialRows[0][projectName]")
	WebElement projectName;
	
	@FindBy(id="initialRows_0_projectActivityName")
	WebElement activityName;
	
	@FindBy(id="initialRows_0_0")
	WebElement monHr;
	
	@FindBy(id="initialRows_0_1")
	WebElement tusHr;
	
	@FindBy(id="initialRows_0_2")
	WebElement wedHr;
	
	@FindBy(id="initialRows_0_3")
	WebElement thrHr;
	
	@FindBy(id="initialRows_0_4")
	WebElement friHr;
	
	@FindBy(id="submitSave")
	WebElement saveBtn;
	
	//Constructor
	public Submit_timesheetPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void timesheet_Entry()
	{
		time_entry.click();
		editBtn.click();
	}
	
	public void enter_ProjectName(String update_projectname)
	{
		projectName.clear();
		projectName.sendKeys(update_projectname);
		projectName.sendKeys(Keys.ENTER);

	}
	
	public void activity_Name() {
		Select options=new Select(activityName);
		options.selectByVisibleText("\r\n"
				+ "    Feature Development    ");
	}
	
	public void enter_hour(String hour) {
		monHr.clear();
		monHr.sendKeys(hour);
		tusHr.clear();
		tusHr.sendKeys(hour);
		wedHr.clear();
		wedHr.sendKeys(hour);
		thrHr.clear();
		thrHr.sendKeys(hour);
		friHr.clear();
		friHr.sendKeys(hour);
	}
	
	public void submit()
	{
		saveBtn.click();
}}

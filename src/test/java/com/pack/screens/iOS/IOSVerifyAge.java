package com.pack.screens.iOS;

import org.openqa.selenium.By;
import com.pack.base.*;

import io.appium.java_client.AppiumDriver;

public class IOSVerifyAge extends DefaultGestures{

	private By backBtn=By.xpath("/UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
	private By submitBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAButton[1]");

	private AppiumDriver driver1;
	
	
	public IOSVerifyAge(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}
	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public void SelectMonth(String month)
	{
		driver1.findElements(By.className("UIAPickerWheel")).get(0).sendKeys(month);
	}
	public void SelectDate(String date)
	{
		driver1.findElements(By.className("UIAPickerWheel")).get(1).sendKeys(date);
	}
	public void SelectYear(String year)
	{
		driver1.findElements(By.className("UIAPickerWheel")).get(2).sendKeys(year);
	}
	public void TapSubmitBtn()
	{
		System.out.println("In Tap Submit Verify Age");
		try
		{
			TapElement(submitBtn);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

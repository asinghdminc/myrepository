package com.pack.screens.Tablet;

import org.openqa.selenium.By;
import com.pack.base.*;

import io.appium.java_client.AppiumDriver;

public class TabletVerifyAge extends DefaultGestures{

	private By backBtn=By.id("back");
	private By monthUpArrow=By.id("month_arrow_up");
	private By monthDownArrow=By.id("month_arrow_down");
	private By dayUpArrow=By.id("day_arrow_up");
	private By dayDownArrow=By.id("day_arrow_down");
	private By yearUpArrow=By.id("year_arrow_up");
	private By yearDownArrow=By.id("year_arrow_down");
	private By submitBtn=By.id("submit_verify_age");
	
	public TabletVerifyAge(AppiumDriver driver)
	{
		super(driver);
	}
	
	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public void TapMonthUpArrow()
	{
		TapElement(monthUpArrow);
	}
	public void TapMonthDownArrow()
	{
		TapElement(monthDownArrow);
	}
	public void TapDayUpArrow()
	{
		TapElement(dayUpArrow);
	}
	public void TapDayDownArrow()
	{
		TapElement(dayDownArrow);
	}
	public void TapYearUpArrow()
	{
		TapElement(yearUpArrow);
	}
	public void TapYearDownArrow()
	{
		TapElement(yearDownArrow);
	}
	public void TapSubmitBtn()
	{
		TapElement(submitBtn);
	}
}

package com.pack.screens.Tablet;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;


public class TabletNavigation extends DefaultGestures {

	public TabletNavigation(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By plan=By.id("ll_home");
	private By save=By.id("ll_deals");
	private By navigate=By.id("ll_navigation");
	private By more=By.id("ll_locations");
	
	public void TapPlan()
	{
		TapElement(plan);
	}
	public void TapSave()
	{
		TapElement(save);
	}
	public void TapNavigate()
	{
		TapElement(navigate);
	}
	public void TapMore()
	{
		TapElement(more);
	}
}

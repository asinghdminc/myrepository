package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;


public class AndroidNavigation extends DefaultGestures {

	public AndroidNavigation(AppiumDriver driver) {
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

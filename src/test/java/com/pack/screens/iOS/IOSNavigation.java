package com.pack.screens.iOS;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class IOSNavigation extends DefaultGestures {

	public IOSNavigation(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By plan=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]");
	private By save=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]");
	private By navigate=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]");
	private By more=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]");
	
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

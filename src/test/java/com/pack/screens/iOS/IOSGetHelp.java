package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class IOSGetHelp extends DefaultGestures {
	private AppiumDriver driver1;
	private By backbtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By helpHeader=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]/UIAImage[1]");
	
	

	public IOSGetHelp(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}

	public void TapBackBtn()
	{
		TapElement(backbtn);
	}
	
	public boolean HelpHeaderVisible()
	{
		boolean flag;
		MobileElement element=(MobileElement)driver1.findElement(helpHeader);
		if (element.isDisplayed())
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		return flag;
	}
}

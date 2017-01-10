package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class AndroidGetHelp extends DefaultGestures {
	private AppiumDriver driver1;
	
	private By backbtn=By.id("faq_back");
	private By helpHeader=By.xpath("//android.view.View[@content-desc='ONE20 Help Link']");
	
	

	public AndroidGetHelp(AppiumDriver driver, AppiumDriver driver1) {
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

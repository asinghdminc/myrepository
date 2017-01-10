package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class IOSContactUs extends DefaultGestures {

	private By backBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By callBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
	private By emailBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	
	public IOSContactUs(AppiumDriver driver) {
		super(driver);
	}

	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public void TapCallBtn()
	{
		TapElement(callBtn);
	}
	public void TapEmailBtn()
	{
		TapElement(emailBtn);
	}

	public boolean callPopUp() {
		
		return VerifyElementDisplayed(callBtn);
	}
	public boolean emailButtonDisplay()
	{
		return VerifyElementDisplayed(emailBtn);
	}
}

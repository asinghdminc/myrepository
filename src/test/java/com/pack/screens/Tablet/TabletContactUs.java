package com.pack.screens.Tablet;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class TabletContactUs extends DefaultGestures {

	private By backBtn=By.id("contact_us_back");
	private By callBtn=By.id("callSupportTxt");
	private By emailBtn=By.id("emailSupportBtn");
	private By callPopUpBpx=By.id("message");
	private By noBtn=By.id("button2");
	
	public TabletContactUs(AppiumDriver driver) {
		super(driver);
	}

	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public boolean verifyCallBtn()
	{
		return VerifyElementDisplayed(callBtn);
	}
	public void TapEmailBtn()
	{
		TapElement(emailBtn);
	}
	public boolean emailButtonDisplay()
	{
		return VerifyElementDisplayed(emailBtn);
	}
	public void tapNo()
	{
		TapElement(noBtn);
	}
}

package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class AndroidContactUs extends DefaultGestures {

	private By backBtn=By.id("contact_us_back");
	private By callBtn=By.id("callSupportBtn");
	private By emailBtn=By.id("emailSupportBtn");
	private By callPopUpBpx=By.id("message");
	private By noBtn=By.id("button2");
	
	public AndroidContactUs(AppiumDriver driver) {
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
	public boolean callPopUp()
	{
		return VerifyElementDisplayed(callPopUpBpx);
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

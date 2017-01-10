package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class IOSShare extends DefaultGestures {

	private By backBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By emailAddressTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
	private By shareBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
	private By confirmationPopup=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]");
	
	public IOSShare(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public void ShareOne20(String email)
	{
		EnterText(emailAddressTxt, email);
		TapElement(shareBtn);
	}
	public boolean verifyConfirmationPopup()
	{
		return VerifyElementDisplayed(confirmationPopup);
	}
}

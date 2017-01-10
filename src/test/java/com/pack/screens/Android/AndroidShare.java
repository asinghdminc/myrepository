package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class AndroidShare extends DefaultGestures {

	private By backBtn=By.id("invite_buddies_back");
	private By emailAddressTxt=By.id("shareONE20EmailET");
	private By shareBtn=By.id("shareBtn");
	private By confirmationPopup=By.id("errorPopUpTextBody");
	
	public AndroidShare(AppiumDriver driver) {
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

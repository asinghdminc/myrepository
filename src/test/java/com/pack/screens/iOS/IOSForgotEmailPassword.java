package com.pack.screens.iOS;

import org.openqa.selenium.By;
import com.pack.base.*;
import io.appium.java_client.AppiumDriver;


public class IOSForgotEmailPassword extends DefaultGestures{

	private By emailONE20Btn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
	private By emailTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
	private By requestTempPasswordBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
	private By cancelBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
	
	public IOSForgotEmailPassword(AppiumDriver driver) {
		super(driver);
	}

	public void TapEmailONE20()
	{
		TapElement(emailONE20Btn);
	}
	public void TapCancel()
	{
		TapElement(cancelBtn);
	}
	public void ResquestTempPwd(String email)
	{
		EnterText(emailTxt, email);
		TapElement(requestTempPasswordBtn);
	}
}

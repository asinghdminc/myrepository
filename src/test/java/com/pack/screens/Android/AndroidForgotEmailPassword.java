package com.pack.screens.Android;

import org.openqa.selenium.By;
import com.pack.base.*;

import io.appium.java_client.AppiumDriver;


public class AndroidForgotEmailPassword extends DefaultGestures {

	private By emailONE20Btn=By.id("emailONE20Btn");
	private By emailTxt=By.id("emailForgetPasswordEmailET");
	private By requestTempPasswordBtn=By.id("reqPasswordBtn");
	private By backBtn=By.id("backArrowIV");
	
	public AndroidForgotEmailPassword(AppiumDriver driver) {
		super(driver);
	}

	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public void TapEmailONE20()
	{
		TapElement(emailONE20Btn);
	}
	public void ResquestTempPwd(String email)
	{
		EnterText(emailTxt, email);
		TapElement(requestTempPasswordBtn);
	}
}

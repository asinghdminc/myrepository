package com.pack.screens.Tablet;

import org.openqa.selenium.By;
import com.pack.base.*;

import io.appium.java_client.AppiumDriver;

public class TabletSignUpLogin extends DefaultGestures {
	
	
	private By signUpBtn=By.id("signUp");
	private By haveAccountLink=By.id("haveAccount");
	private By one20Logo=By.id("logo");
	
	public TabletSignUpLogin (AppiumDriver driver)
	{
		super(driver);
	}
	public void TapSignUp()
	{
		System.out.println("In Android wala Sign Up If");
		try{
		TapElement(signUpBtn);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Sign Up Clicked");
	}
	public void TapHaveAccount()
	{
		TapElement(haveAccountLink);
	}
	public void WaitForLogo()
	{
		try{
		WaitForElement(one20Logo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

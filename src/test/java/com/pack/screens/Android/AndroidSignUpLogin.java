package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import net.thucydides.core.annotations.Step;

public class AndroidSignUpLogin extends DefaultGestures {
	
	
	private By signUpBtn=By.id("signUp");
	private By haveAccountLink=By.id("haveAccount");
	private By one20Logo=By.id("logo");
	
	public AndroidSignUpLogin (AppiumDriver driver)
	{
		super(driver);
	}
	@Step
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
	@Step
	public void TapHaveAccount()
	{
		TapElement(haveAccountLink);
	}
	@Step
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

package com.pack.screens.iOS;

import org.openqa.selenium.By;
import com.pack.base.*;

import io.appium.java_client.AppiumDriver;

public class IOSSignUpLogin extends DefaultGestures {
	
	
	private By signUpBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
	private By haveAccountLink=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[4]");
	private By one20Logo=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[2]");
	
	public IOSSignUpLogin (AppiumDriver driver)
	{
		super(driver);
	}
	public void TapSignUp()
	{
		TapElement(signUpBtn);
	}
	public void TapHaveAccount()
	{
		TapElement(haveAccountLink);
	}
	public void WaitForLogo()
	{
		WaitForElement(one20Logo);
	}
	
}

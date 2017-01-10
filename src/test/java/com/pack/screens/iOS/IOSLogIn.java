package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class IOSLogIn extends DefaultGestures{


	private By emailTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
	private By passwordTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
	private By forgotLink=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
	private By logInBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]");
	private By needAccountLink=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]");
	private By planScreenMap=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]");



	public IOSLogIn(AppiumDriver driver) {
		super(driver);

	}
	public void PerformLogIn(String email, String password)
	{
		WaitForElement(emailTxt);
		EnterText(emailTxt, email);
		EnterText(passwordTxt, password);

		TapElement(logInBtn);
		WaitForElement(planScreenMap);
	}
	public void TapForgorLink()
	{
		TapElement(forgotLink);
	}
	public void TapNeedAccount()
	{
		TapElement(needAccountLink);
	}

}

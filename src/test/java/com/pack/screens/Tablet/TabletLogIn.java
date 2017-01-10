package com.pack.screens.Tablet;

import org.openqa.selenium.By;
import com.pack.base.*;

import io.appium.java_client.AppiumDriver;

public class TabletLogIn extends DefaultGestures{

	private By emailTxt=By.id("email_edt");
	private By passwordTxt=By.id("password");
	private By forgotLink=By.id("forgot_password");
	private By logInBtn=By.id("submit");
	private By needAccountLink=By.id("create");
	private By planScreenMap=By.xpath("//android.view.View[@content-desc='Google Map']");

	public TabletLogIn(AppiumDriver driver) {
		super(driver);
		
	}


	public void PerformLogIn(String email, String password)
	{
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

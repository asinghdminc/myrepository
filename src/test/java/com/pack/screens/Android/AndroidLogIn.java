package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import net.thucydides.core.annotations.Step;

public class AndroidLogIn extends DefaultGestures{

	private By emailTxt=By.id("email_edt");
	private By passwordTxt=By.id("password");
	private By forgotLink=By.id("forgot_password");
	private By logInBtn=By.id("submit");
	private By needAccountLink=By.id("create");
	private By planScreenMap=By.xpath("//android.view.View[@content-desc='Google Map']");

	public AndroidLogIn(AppiumDriver driver) {
		super(driver);

	}

	@Step
	public void PerformLogIn(String email, String password)
	{
		EnterText(emailTxt, email);
		EnterText(passwordTxt, password);
		TapElement(logInBtn);
		WaitForElement(planScreenMap);
	}
	@Step
	public void TapForgorLink()
	{
		TapElement(forgotLink);
	}
	@Step
	public void TapNeedAccount()
	{
		TapElement(needAccountLink);
	}

}

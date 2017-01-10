package com.pack.screens.Android;

import org.openqa.selenium.By;
import com.pack.base.*;

import io.appium.java_client.AppiumDriver;

public class AndroidCreateAccount extends DefaultGestures
{	
	
	
	public AndroidCreateAccount(AppiumDriver driver) {
		super(driver);

	}
	private By backBtn=By.id("ivBack");
	private By emailTxt=By.id("emailATV");
	private By passwordTxt=By.id("passwordET");
	private By confirmPasswordTxt=By.id("ConfirmpasswordET");
	private By submitBtn=By.id("submit_login");
	private By driverType=By.id("radioOwnerOperator");
	private By questionnaireSubmit=By.id("btn_questionnaire_submit");
	private By skipBtn=By.id("decline_button");

	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public void CreateAnAccount(String email, String password, String confirmPassword)
	{
		EnterText(emailTxt, email);
		EnterText(passwordTxt,password);
		EnterText(confirmPasswordTxt,confirmPassword);
		TapElement(submitBtn);
		WaitForElement(driverType);
		TapElement(driverType);
		TapElement(questionnaireSubmit);
		TapElement(skipBtn);
	}
//	public String VerifyTermsnConditions()
//	{
//		String flag;
//		WaitForElement(termsnConditions);
//		if (VerifyElementDisplayed(termsnConditions)==true)
//		{
//			flag="Element Displayed";
//		}
//		else
//		{
//			flag="Element not displaed";
//		}
//		return flag;
//	}
}

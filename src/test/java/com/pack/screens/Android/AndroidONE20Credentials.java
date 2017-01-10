package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class AndroidONE20Credentials extends DefaultGestures {

	private By backBtn=By.id("ivBack");
	private By editBtn=By.id("image_button_edit");
	private By currentPasswordTxt=By.id("oldPasswordET");
	private By newPasswordTxt=By.id("passwordET");
	private By confirmNewPasswordTxt=By.id("ConfirmpasswordET");
	private By doneBtn=By.id("imageButtonRegDone");
	private By okBtn=By.id("gotItPopUpBtn");

	public AndroidONE20Credentials(AppiumDriver driver) {
		super(driver);
	}

	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public void ChangePassword (String CurrentPassword, String NewPassword, String ConfirmNewPassword)
	{
		TapElement(editBtn);
		EnterText(currentPasswordTxt, CurrentPassword);
		EnterText(newPasswordTxt, NewPassword);
		EnterText(confirmNewPasswordTxt, ConfirmNewPassword);
		TapElement(doneBtn);
		WaitForElement(okBtn);
		TapElement(okBtn);
	}
}

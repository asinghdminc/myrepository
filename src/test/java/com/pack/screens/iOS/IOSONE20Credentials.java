package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;



public class IOSONE20Credentials extends DefaultGestures {

	private By backBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By editBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	private By currentPasswordTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
	private By newPasswordTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[2]");
	private By confirmNewPasswordTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[3]");
	private By doneBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	private By cancelBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
	private By okBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]");
	
	public IOSONE20Credentials(AppiumDriver driver) {
		super(driver);
	}
	
	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public void TapCancelBtn()
	{
		TapElement(cancelBtn);
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

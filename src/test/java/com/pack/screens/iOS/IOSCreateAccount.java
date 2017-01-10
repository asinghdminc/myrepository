package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class IOSCreateAccount extends DefaultGestures
{	

	public IOSCreateAccount(AppiumDriver driver) 
	{
		super(driver);
	}

	private By backBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
	private By emailTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
	private By passwordTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
	private By confirmPasswordTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[2]");
	private By submitBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
	private By moreBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]");
	private By logoutBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By logoutBtn2=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]");
	private By emailTxtLogin=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
	private By driverType=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	private By questionnaireSubmit=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
	private By skipBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]");

	public void TapBackBtn()
	{
		TapElement(backBtn);
	}

	public void CreateAnAccount(String email, String password, String confirmPassword)
	{
		//		MobileElement element1=(MobileElement) driver1.findElement(passwordTxt);
		//		MobileElement element2=(MobileElement) driver1.findElement(confirmPasswordTxt);

		EnterText(emailTxt, email);
		TapElement(passwordTxt);
		EnterText(passwordTxt, password);
		TapElement(confirmPasswordTxt);
		EnterText(confirmPasswordTxt,confirmPassword);
		TapElement(submitBtn);
		WaitForElement(driverType);
		TapElement(driverType);
		TapElement(questionnaireSubmit);
		WaitForElement(skipBtn);
		TapElement(skipBtn);
	}
	public void logout()
	{
		TapElement(moreBtn);
		TapElement(logoutBtn);
		TapElement(logoutBtn2);
		WaitForElement(emailTxtLogin);
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

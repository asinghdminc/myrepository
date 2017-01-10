package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class IOSMore extends DefaultGestures {

	private By one20Credentials=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	private By profileInformation=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]");
	private By truckProfile=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]");
	private By settings=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]");
	private By contactUs=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]");
	private By getHelp=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]");
	private By about=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]");
	private By logOut=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By logOutBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]");
	private By emailTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
	public IOSMore(AppiumDriver driver) {
		super(driver);	
	}
	
	public void TapOne20Credentials()
	{
		TapElement(one20Credentials);
	}
	public void TapProfileInfo()
	{
		TapElement(profileInformation);
	}
	public void TapTruckProfile()
	{
		TapElement(truckProfile);
	}
	public void TapSettings()
	{
		TapElement(settings);
	}
	public void TapContactUs()
	{
		TapElement(contactUs);
	}
	public void TapGetHelp()
	{
		TapElement(getHelp);
	}
	public void TapAbout()
	{
		TapElement(about);
	}
	public void TapLogout()
	{
		TapElement(logOut);
		TapElement(logOutBtn);
		WaitForElement(emailTxt);
	}
}

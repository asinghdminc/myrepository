package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class IOSWhyOne20 extends DefaultGestures {

	public IOSWhyOne20(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By backBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By titleSection=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]");
	private By planTitle=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[1]");
	private By planContent=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[2]");
	private By saveTitle=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[3]");
	private By saveContent=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[4]");
	private By connectTitle=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[5]");
	private By connectContent=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[6]");
	
	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public String ReadTitleSection()
	{
		String content=ReadValue(titleSection);
		return content;
	}
	public String ReadPlanTitle()
	{
		String content=ReadValue(planTitle);
		return content;
	} 
	public String ReadPlanContent()
	{
		String content=ReadValue(planContent);
		return content;
	}
	public String ReadSaveTitle()
	{
		String content=ReadValue(saveTitle);
		return content;
	}
	public String ReadSaveContent()
	{
		String content=ReadValue(saveContent);
		return content;
	}
	public String ReadConnectTitle()
	{
		String content=ReadValue(connectTitle);
		return content;
	}
	public String ReadConnectContent()
	{
		String content=ReadValue(connectContent);
		return content;
	}
}

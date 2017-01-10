package com.pack.screens.Tablet;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class TabletWhyOne20 extends DefaultGestures {

	public TabletWhyOne20(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By backBtn=By.id("why_one20_back");
	private By titleSection=By.id("whyOne20Title");
	private By planTitle=By.id("tvViewPlanTitle");
	private By planContent=By.id("tvViewPlanText");
	private By saveTitle=By.id("tvViewSaveTitle");
	private By saveContent=By.id("tvViewSaveText");
	private By connectTitle=By.id("tvViewConnectTitle");
	private By connectContent=By.id("tvViewConnectText");
	
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

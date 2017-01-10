package com.pack.screens.Tablet;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class TabletPrivacyPolicy extends DefaultGestures {

	private By backBtn=By.id("contact_us_back");
	private By privacyHeader=By.id("privacy_header_tv");
	private By updatedDate=By.id("privacy_update_tv");
	private By privacyPolicyContent=By.id("privacy_policy_content_tv");
	
	public TabletPrivacyPolicy(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public String ReadPrivacyHeader()
	{
		String content=ReadValue(privacyHeader);
		return content;
	}
	public String ReadUpdatedDate()
	{
		String content=ReadValue(updatedDate);
		return content;
	}
	public String ReadPrivacyBody()
	{
		String content=ReadValue(privacyPolicyContent);
		return content;
	}
}

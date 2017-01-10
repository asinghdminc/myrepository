package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AndroidAbout extends DefaultGestures {
	private AppiumDriver driver1;

	private By backBtn=By.id("back");
	private By whyONE20=By.id("rl_whyOne20");
	private By share=By.id("rl_share");
	private By termsnConditions=By.id("rl_terms_condition");
	private By privacyPolicy=By.id("rl_privacy_policy");
	private By version=By.id("versionNameTV");


	public AndroidAbout(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}


	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public void TapWhyONE20()
	{
		TapElement(whyONE20);
	}
	public void TapShare()
	{
		TapElement(share);
	}
	public void TapTermsnConditions()
	{
		TapElement(termsnConditions);
	}
	public void TapPrivacyPolicy()
	{
		TapElement(privacyPolicy);
	}
	public String ReadVersion()
	{
		MobileElement element=(MobileElement)driver1.findElement(version);
		String version;
		version=element.getText().toString();
		return version;

	}
}

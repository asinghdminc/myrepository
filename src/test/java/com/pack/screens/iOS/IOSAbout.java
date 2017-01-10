package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class IOSAbout extends DefaultGestures {
	private AppiumDriver driver1;

	private By backBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
	private By whyONE20=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
	private By share=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
	private By termsnConditions=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]");
	private By privacyPolicy=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]");
	private By version=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
	
	
	
	public IOSAbout(AppiumDriver driver, AppiumDriver driver1) {
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

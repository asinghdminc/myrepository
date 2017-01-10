package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class AndroidTermsnConditions extends DefaultGestures {

	private By backBtn=By.xpath("ll_image_button_back");
	private By headerSection=By.xpath("header_tv");
	private By updatedDate=By.xpath("update_tv");
	private By termsBody=By.xpath("terms_body");
	private By termsbodyBottom=By.xpath("terms_body_bottom");
	
	public AndroidTermsnConditions(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public String ReadHeader()
	{
		String content=ReadValue(headerSection);
		return content;
	}
	public String ReadUpdatedDate()
	{
		String content=ReadValue(updatedDate);
		return content;
	}
	public String ReadTermsBody()
	{
		String content=ReadValue(termsBody);
		return content;
	}
	public String ReadTermsBodyBottom()
	{
		String content=ReadValue(termsbodyBottom);
		return content;
	}
}

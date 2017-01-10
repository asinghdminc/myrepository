package com.pack.screens.Tablet;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class TabletMore extends DefaultGestures {

	private By one20Credentials=By.id("title_account_credentials");
	private By profileInformation=By.id("title_profile_information");
	private By truckProfile=By.id("title_truck_profile");
	private By partners=By.id("title_partners");
	private By contactUs=By.id("title_contact_us");
	private By getHelp=By.id("title_faq");
	private By about=By.id("title_about");
	private By moreOptions=By.id("options_more");
	private By logOut=By.id("title_account_credentials");
	private By goLinkPartners=By.id("tv_goto_link");
	private By LogoutPopUp=By.id("gotItPopUpBtn");

	public AppiumDriver driver1;


	public TabletMore(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
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
	public void TapPartners()
	{
		TapElement(partners);
		WaitForElement(goLinkPartners);
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
		TapElement(moreOptions);

		TapElement(logOut);
		TapElement(LogoutPopUp);
	}

}
package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class AndroidMore extends DefaultGestures {

	private By one20Credentials=By.id("title_account_credentials");
	private By profileInformation=By.id("title_profile_information");
	private By truckProfile=By.id("title_truck_profile");
	private By partners=By.id("title_partners");
	private By contactUs=By.id("title_contact");
	private By getHelp=By.id("title_faq");
	private By about=By.id("title_about");
	private By moreOptions=By.id("action_logout");
	private By logOut=By.id("rl_account_credentials");
	private By goLinkPartners=By.id("tv_goto_link");
	
	public AppiumDriver driver1;
	
	
	public AndroidMore(AppiumDriver driver, AppiumDriver driver1) {
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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			TapElement(logOut);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				driver1.findElement(By.name("Log Out"));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}

	}
}

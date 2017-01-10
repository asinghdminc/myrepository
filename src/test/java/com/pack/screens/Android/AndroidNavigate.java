package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;

public class AndroidNavigate extends DefaultGestures {

	private By truckSafeNav=By.id("alkNavigationTxt");
	private By googleNav=By.id("googleNavigationStartBtn");
	private By yesTruckSafe=By.id("yes");
	private By okBtn=By.id("gotItPopUpBtn");
	private By googleMaps=By.xpath("//android.view.View[@package='com.google.android.apps.maps']");

	public AndroidNavigate(AppiumDriver driver) {
		super(driver);
	}

	public void verifyTruckSafeNavDisplayed()
	{
		String truckSafeTxt=ReadValue(truckSafeNav);
		try{

			Assert.assertEquals("Use Turn-By-Turn Truck Safe Navigation", truckSafeTxt);
		}
		catch (Exception e)
		{
			takeScreenShot();
			Assert.fail("Truck Safe Nav Not Displayed");
		}

	}
	public void openGoogleMaps()
	{
		TapElement(googleNav);
		TapElement(yesTruckSafe);
		TapElement(okBtn);
		WaitForElement(googleMaps);
	}
	public void verifyGoogleMapsDisplayed()
	{
		try{

			Assert.assertEquals(true,VerifyElementDisplayed(googleMaps));
		}
		catch(Exception e)
		{
			takeScreenShot();
			Assert.fail("Google Maps not opened");
		}
	}

}

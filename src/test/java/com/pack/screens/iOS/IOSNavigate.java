package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;

public class IOSNavigate extends DefaultGestures {

	private By truckSafeNav=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
	private By appleNav=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");
	private By yesTruckSafe=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
	private By okBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
	private By appleMaps=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAMapView[1]/UIAElement[4]");
	private By iUnderstandBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");

	public IOSNavigate(AppiumDriver driver) {
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
	public void openAppleMaps()
	{
		TapElement(appleNav);
		TapElement(yesTruckSafe);
		WaitForElement(okBtn);
		TapElement(okBtn);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TapElement(iUnderstandBtn);
		WaitForElement(appleMaps);
	}
	public void verifyAppleMapsDisplayed()
	{
		try{

			Assert.assertEquals(true,VerifyElementDisplayed(appleMaps));
		}
		catch(Exception e)
		{
			takeScreenShot();
			Assert.fail("Google Maps not opened");
		}
	}

}

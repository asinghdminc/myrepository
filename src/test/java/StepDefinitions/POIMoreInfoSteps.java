package StepDefinitions;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.pack.base.Constants;
import com.pack.base.TestBaseSetup;
import com.pack.screens.Android.AndroidLogIn;
import com.pack.screens.Android.AndroidPOIMoreInfo;
import com.pack.screens.Android.AndroidPlanMapView;
import com.pack.screens.Android.AndroidSignUpLogin;
import com.pack.screens.Tablet.TabletLogIn;
import com.pack.screens.Tablet.TabletPOIMoreInfo;
import com.pack.screens.Tablet.TabletPlanMapView;
import com.pack.screens.Tablet.TabletSignUpLogin;
import com.pack.screens.iOS.IOSLogIn;
import com.pack.screens.iOS.IOSPOIMoreInfo;
import com.pack.screens.iOS.IOSPlanMapView;
import com.pack.screens.iOS.IOSSignUpLogin;

import junit.framework.Assert;
import net.thucydides.core.annotations.Steps;

public class POIMoreInfoSteps extends TestBaseSetup {
	@Steps
	AndroidSignUpLogin androidsignUpLogin;
	AndroidLogIn androidLogIn;
	AndroidPlanMapView androidPlanMapView;
	AndroidPOIMoreInfo androidPOIMoreInfo;

	IOSSignUpLogin iosSignUpLogin;
	IOSLogIn iosLogIn;
	IOSPlanMapView iosPlanMapView;
	IOSPOIMoreInfo iospoiMoreInfo;

	TabletSignUpLogin tabletSignUpLogin;
	TabletLogIn tabletLogIn;
	TabletPlanMapView tabletPlanMapView;
	TabletPOIMoreInfo tabletPOIMoreInfo;
	@BeforeStory
	public void setup()
	{
		driver=getDriver();
	}

	@Given("user is on plan")
	public void userOnPlan()
	{
		androidsignUpLogin=new AndroidSignUpLogin(driver);
		androidLogIn=new AndroidLogIn(driver);
		androidPlanMapView=new AndroidPlanMapView(driver);
		androidPOIMoreInfo=new AndroidPOIMoreInfo(driver, driver);


		iosSignUpLogin=new IOSSignUpLogin(driver);
		iosLogIn=new IOSLogIn(driver);
		iosPlanMapView=new IOSPlanMapView(driver);
		iospoiMoreInfo=new IOSPOIMoreInfo(driver, driver);

		tabletSignUpLogin=new TabletSignUpLogin(driver);
		tabletLogIn=new TabletLogIn(driver);
		tabletPlanMapView=new TabletPlanMapView(driver);
		tabletPOIMoreInfo=new TabletPOIMoreInfo(driver, driver);

		if (flag.equalsIgnoreCase("Android"))
		{
//			androidsignUpLogin.WaitForLogo();
//			androidsignUpLogin.TapHaveAccount();
//			androidLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
			androidPlanMapView.VerifyPlanScreen();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
//						iosSignUpLogin.WaitForLogo();
//						iosSignUpLogin.TapHaveAccount();
//						iosLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
			iosPlanMapView.VerifyPlanScreen();
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		else
		{
			tabletSignUpLogin.WaitForLogo();
			tabletSignUpLogin.TapHaveAccount();
			tabletLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
		}

	}
	@When("user searches for $POI")
	public void searchPOI(@Named("POI") String poiName)
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidPlanMapView.SearchPOI(poiName);
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosPlanMapView.SearchPOI(poiName);
		}
		else
		{
			tabletPlanMapView.SearchPOI(poiName);
		}

	}
	@When("goes to POI More Info")
	public void openMoreInfo()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidPlanMapView.OpenSearchedPOI();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosPlanMapView.OpenSearchedPOI();

		}
		else
		{
			tabletPlanMapView.OpenSearchedPOI();
		}
	}

	@Then("POI name should be $POIName")
	public void verifyPOIName(@Named("POIName") String poiName)
	{
		String name;
		if (flag.equalsIgnoreCase("android"))
		{
			name=androidPOIMoreInfo.ReadPOIName();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			name=iospoiMoreInfo.ReadPOIName();
		}
		else
		{
			name=tabletPOIMoreInfo.ReadPOIName();
		}

		System.out.println("POIName"+name);

		try
		{
			Assert.assertEquals(poiName, name);
		}
		catch(Exception e)
		{
			takeScreenShot();
			Assert.fail("Name not matched");
		}
	}

	@Then ("POI address should be $POIAddress")
	public void verifyPOIAddress(@Named("POIAddress") String poiAddress)
	{
		String address;
		if (flag.equalsIgnoreCase("android"))
		{
			address=androidPOIMoreInfo.ReadAddress();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			address=iospoiMoreInfo.ReadAddress();
		}
		else
		{
			address=tabletPOIMoreInfo.ReadAddress();
		}
		try
		{
			Assert.assertEquals(poiAddress, address);
		}
		catch(Exception e)
		{
			takeScreenShot();
			Assert.fail("Address not matched");
		}
		finally
		{
			driver.resetApp();
		}
	}
	@Then ("POI open hours should be $POIOpenHours")
	public void verifyOpenHours(@Named("POIOpenHours") String poiOpenHours)
	{
		String openHours;

		if (flag.equalsIgnoreCase("android"))
		{
			openHours=androidPOIMoreInfo.ReadOpenHours();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			openHours=iospoiMoreInfo.ReadOpenHours();
		}
		else 
		{
			openHours=tabletPOIMoreInfo.ReadOpenHours();
		}

		try
		{
			Assert.assertEquals(poiOpenHours, openHours);
		}
		catch(Exception e)
		{
			takeScreenShot();
			Assert.fail("Open Hours not matched");
		}
	}
	@Then("Parking status should be displayed")
	public void verifyParkingDisplayed()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			try{
				Assert.assertEquals(true, androidPOIMoreInfo.parkingDisplayed());
			}
			catch (Exception e)
			{
				takeScreenShot();
				Assert.fail("Parking Status not displayed");
			}
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			try{
				Assert.assertEquals(true, iospoiMoreInfo.parkingDisplayed());
			}
			catch (Exception e)
			{
				takeScreenShot();
				Assert.fail("Parking Status not displayed");
			}
		}
		else
		{
			try{
				Assert.assertEquals(true, tabletPOIMoreInfo.parkingDisplayed());
			}
			catch (Exception e)
			{
				takeScreenShot();
				Assert.fail("Parking Status not displayed");
			}

		}
	}
	@When("verifies list of amenities")
	public void readAmenitiesAtPOI()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidPOIMoreInfo.readAmenities();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iospoiMoreInfo.readAmenities();
		}
		else
		{
			tabletPOIMoreInfo.readAmenities();
		}

	}
	@Then("correct list of POI's should be displayed")
	public void verifyAmenitiesAtPOI()
	{
		if (flag.equalsIgnoreCase("Android"))
		{
		androidPOIMoreInfo.verifyAmenities();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iospoiMoreInfo.verifyAmenities();
		}
		else
		{
			tabletPOIMoreInfo.verifyAmenities();
		}
	}
	@Then("Navigate button should be displayed")
	public void verifyNavigateDisplayed()
	{
		if (flag.equalsIgnoreCase("android"))
		{		
			try
			{
				Assert.assertEquals(true, androidPOIMoreInfo.navigateDisplayed());
			}
			catch (Exception e)
			{
				takeScreenShot();
				Assert.fail("Navigate button not displayed");
			}
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			try
			{

				Assert.assertEquals(true, iospoiMoreInfo.navigateDisplayed());
			}
			catch (Exception e)
			{
				takeScreenShot();
				Assert.fail("Navigate button not displayed");
			}
		}
		else
		{		
			try
			{

				Assert.assertEquals(true, tabletPOIMoreInfo.navigateDisplayed());
			}
			catch (Exception e)
			{
				takeScreenShot();
				Assert.fail("Navigate button not displayed");
			}

		}

	}
//	@AfterStory
//	public void end()
//	{
//		driver.resetApp();
//	}
}

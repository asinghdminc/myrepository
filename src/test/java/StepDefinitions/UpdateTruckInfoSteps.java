package StepDefinitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.pack.base.Constants;
import com.pack.base.TestBaseSetup;
import com.pack.screens.Android.AndroidLogIn;
import com.pack.screens.Android.AndroidMore;
import com.pack.screens.Android.AndroidNavigate;
import com.pack.screens.Android.AndroidNavigation;
import com.pack.screens.Android.AndroidPOIMoreInfo;
import com.pack.screens.Android.AndroidPlanMapView;
import com.pack.screens.Android.AndroidSignUpLogin;
import com.pack.screens.Android.AndroidTruckInfomation;
import com.pack.screens.Tablet.TabletLogIn;
import com.pack.screens.Tablet.TabletMore;
import com.pack.screens.Tablet.TabletNavigate;
import com.pack.screens.Tablet.TabletNavigation;
import com.pack.screens.Tablet.TabletPOIMoreInfo;
import com.pack.screens.Tablet.TabletPlanMapView;
import com.pack.screens.Tablet.TabletSignUpLogin;
import com.pack.screens.Tablet.TabletTruckInfomation;
import com.pack.screens.iOS.IOSLogIn;
import com.pack.screens.iOS.IOSMore;
import com.pack.screens.iOS.IOSNavigate;
import com.pack.screens.iOS.IOSNavigation;
import com.pack.screens.iOS.IOSPOIMoreInfo;
import com.pack.screens.iOS.IOSPlanMapView;
import com.pack.screens.iOS.IOSSignUpLogin;
import com.pack.screens.iOS.IOSTruckInformation;

import junit.framework.Assert;
import mx4j.tools.config.DefaultConfigurationBuilder.New;
import net.thucydides.core.annotations.Steps;

public class UpdateTruckInfoSteps extends TestBaseSetup {
	int poiCount=0;

	@Steps
	AndroidSignUpLogin androidsignUpLogin;
	AndroidLogIn androidLogIn;
	AndroidNavigation androidNavigation;
	AndroidMore androidMore;
	AndroidPlanMapView androidPlanMapView;
	AndroidTruckInfomation androidTruckInfomation;
	AndroidPOIMoreInfo androidPOIMoreInfo;
	AndroidNavigate androidNavigate;

	IOSSignUpLogin iosSignUpLogin;
	IOSLogIn iosLogIn;
	IOSNavigation iosNavigation;
	IOSMore iosMore;
	IOSPlanMapView iosPlanMapView;
	IOSTruckInformation iosTruckInformation;
	IOSPOIMoreInfo iospoiMoreInfo;
	IOSNavigate iosNavigate;

	TabletSignUpLogin tabletSignUpLogin;
	TabletLogIn tabletLogIn;
	TabletNavigation tabletNavigation;
	TabletMore tabletMore;
	TabletPlanMapView tabletPlanMapView;
	TabletTruckInfomation tabletTruckInfomation;
	TabletPOIMoreInfo tabletPOIMoreInfo;
	TabletNavigate tabletNavigate;

	String reviewText="This is a test review";

	@BeforeStory
	public void setup()
	{
		driver=getDriver();
	}

	@Given("user is on plan map view")
	public void LoginBeforePasswordChange()
	{
		androidsignUpLogin=new AndroidSignUpLogin(driver);
		androidLogIn=new AndroidLogIn(driver);
		androidMore=new AndroidMore(driver, driver);
		androidTruckInfomation=new AndroidTruckInfomation(driver, driver);
		androidNavigation=new AndroidNavigation(driver);
		androidPlanMapView=new AndroidPlanMapView(driver);
		androidPOIMoreInfo=new AndroidPOIMoreInfo(driver, driver);
		androidNavigate=new AndroidNavigate(driver);

		iosSignUpLogin=new IOSSignUpLogin(driver);
		iosLogIn=new IOSLogIn(driver);
		iosMore=new IOSMore(driver);
		iosTruckInformation=new IOSTruckInformation(driver, driver);
		iosNavigation=new IOSNavigation(driver);
		iosPlanMapView=new IOSPlanMapView(driver);
		iospoiMoreInfo=new IOSPOIMoreInfo(driver, driver);
		iosNavigate= new IOSNavigate(driver);

		tabletSignUpLogin=new TabletSignUpLogin(driver);
		tabletLogIn=new TabletLogIn(driver);
		tabletMore=new TabletMore(driver, driver);
		tabletTruckInfomation=new TabletTruckInfomation(driver, driver);
		tabletNavigation=new TabletNavigation(driver);
		tabletPlanMapView=new TabletPlanMapView(driver);
		tabletPOIMoreInfo=new TabletPOIMoreInfo(driver, driver);
		tabletNavigate=new TabletNavigate(driver);

		if (flag.equalsIgnoreCase("Android"))
		{
			androidsignUpLogin.WaitForLogo();
			androidsignUpLogin.TapHaveAccount();
			androidLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
//			iosSignUpLogin.WaitForLogo();
//			iosSignUpLogin.TapHaveAccount();
//			iosLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);			

			iosPlanMapView.VerifyPlanScreen();

		}	
		else
		{
			tabletSignUpLogin.WaitForLogo();
			tabletSignUpLogin.TapHaveAccount();
			tabletLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
		}
	}

	@When("user goes to more screen")
	public void OpenMore()
	{
		try{
			if (flag.equalsIgnoreCase("android"))
			{
				androidNavigation.TapMore();
			}
			else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
			{
				iosNavigation.TapMore();
			}
			else
			{
				tabletNavigation.TapMore();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@When("goes to truck information screen")
	public void OpenTruckProfile()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidMore.TapTruckProfile();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosMore.TapTruckProfile();
		}
		else
		{
			tabletMore.TapTruckProfile();
		}
	}
	@When("updates the truck information")
	public void UpdateProfileInfo()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidTruckInfomation.UpdateTruckInfo("Model Update", "abc 1234", "2011");
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosTruckInformation.UpdateTruckInfo("Freightliner", "Model Update", "abc 1234", "Dry Van", "2011", "Black");

		}
		else
		{
			tabletTruckInfomation.UpdateTruckInfo("Model Update", "abc 1234", "2011");
		}
	}
	@Then("user is able see the updated truck information")
	public void VerifyTruckProfileInfo()
	{
		System.out.println("In Then");
		ArrayList<String> truckProfile;
		if (flag.equalsIgnoreCase("android"))
		{
			truckProfile=androidTruckInfomation.ReadTruckInfo();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosMore.TapTruckProfile();
			truckProfile=iosTruckInformation.ReadTruckInfo();
		}
		else
		{
			truckProfile=tabletTruckInfomation.ReadTruckInfo();
		}
		System.out.println(truckProfile);
		try{
			Assert.assertEquals("Freightliner", truckProfile.get(0));
			Assert.assertEquals("Model Update", truckProfile.get(1));
			Assert.assertEquals("abc 1234", truckProfile.get(2));
			Assert.assertEquals("Dry Van", truckProfile.get(3));
			Assert.assertEquals("2011", truckProfile.get(4));
			Assert.assertEquals("Black", truckProfile.get(5));
		}
		catch (Exception e)
		{
			takeScreenShot();
			Assert.fail("Could not validate");
		}
		finally
		{
			driver.resetApp();
		}
	}
	@When("user goes to POI More info screen")
	public void openPOI()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidPlanMapView.openPOI();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosPlanMapView.openPOI();
		}
		else
		{
			tabletPlanMapView.openPOI();
		}
	}
	@When("Submits a rating for that POI")
	public void ratingPOI()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidPOIMoreInfo.ratePOI();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			try {
				iospoiMoreInfo.ratePOI();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			tabletPOIMoreInfo.ratePOI();
		}

	}
	@When("updates parking for that POI")
	public void updateParking()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidPOIMoreInfo.updateParkingAtPOI();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iospoiMoreInfo.updateParkingAtPOI();
		}
		else
		{
			tabletPOIMoreInfo.updateParkingAtPOI();
		}
	}
	@Then("Rating is submitted")
	public void verifyRatingSubmitted()
	{
		boolean confirmation = false;
		if (flag.equalsIgnoreCase("android"))
		{
			confirmation=androidPOIMoreInfo.verifyRated();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			confirmation=iospoiMoreInfo.verifyRated();
		}
		else
		{
			confirmation=tabletPOIMoreInfo.verifyRated();
		}
		try
		{
			Assert.assertEquals(true, confirmation);
		}
		catch (Exception e)
		{
			takeScreenShot();
			Assert.fail("Could not rate");
		}
	}
	@When("user goes to list view screen")
	public void openListView()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidPlanMapView.OpenListView();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosPlanMapView.OpenListView();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			tabletPlanMapView.OpenListView();
		}
	}
	@When("counts number of POI's in list view screen")
	public void countPOI() throws InterruptedException
	{
		Thread.sleep(4000);
		ArrayList<String> allDeals=new ArrayList<String>();
		Dimension size= driver.manage().window().getSize();
		int startx=(int) (size.getWidth()*0.5);
		int starty=(int) (size.getHeight()*0.7);
		int endy=(int) (size.getHeight()*0.3);

		int startyException=(int) (size.getHeight()*0.35);

		if (flag.equalsIgnoreCase("android"))
		{

			for(int i=0; i<20;i++)
			{
				for (int j=0; j<7;j++)
				{
					try{
						String poiName=driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='"+j+"']/android.widget.TextView[@resource-id='com.one20.ota:id/poiTitle']")).getText().toString();
						String poiAddress=driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='"+j+"']/android.widget.TextView[@resource-id='com.one20.ota:id/address']")).getText().toString();
						allDeals.add(poiName+" "+poiAddress);
					}
					catch (NoSuchElementException e)
					{

					}
				}
				try
				{
					driver.swipe(startx, starty, startx, endy, 2000);
				}
				catch(Exception e)
				{
					driver.swipe(startx, startyException, startx, endy, 2000);
				}
				Thread.sleep(3000);
			}
			System.out.println("Length of ArrayList: "+allDeals.size());
			Set<String> set = new LinkedHashSet<String>();
			for (int i=0;i<allDeals.size();i++)
			{
				set.add(allDeals.get(i));
			}
			poiCount=set.size();
			System.out.println("Length of set is: "+poiCount);
			Iterator<String> iterator=set.iterator();
			int i=0;
			while(iterator.hasNext())
			{
				System.out.println("POI"+(i+1)+": "+iterator.next());
				i++;
			}
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			ArrayList<WebElement> allPOIs=new ArrayList<WebElement>();
			allPOIs=(ArrayList<WebElement>) driver.findElements(By.className("UIATableCell"));
			//			for(int i=1; i<=40;i++)
			//			{
			//				try{
			//					String poiName=driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell["+i+"]/UIAStaticText[1]")).getText().toString();
			//					String poiAddress=driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell["+i+"]/UIAStaticText[2]")).getText().toString();
			//					allDeals.add(poiName+" "+poiAddress);
			//				}
			//				catch (NoSuchElementException e)
			//				{
			//					break;
			//				}
			//			}
			System.out.println("Length of ArrayList: "+allPOIs.size());
			//			Set<String> set = new LinkedHashSet<String>();
			//			for (int i=0;i<allDeals.size();i++)
			//			{
			//				set.add(allDeals.get(i));
			//			}
			poiCount=allPOIs.size();
			System.out.println("Length of set is: "+poiCount);
			//			Iterator<String> iterator=set.iterator();
			//			int i=0;
			//			while(iterator.hasNext())
			//			{
			//				System.out.println("POI"+(i+1)+": "+iterator.next());
			//				i++;
			//			}
		}
		else
		{
			int startx2=(int) (size.getWidth()*0.100);
			for(int i=0; i<20;i++)
			{
				for (int j=0; j<7;j++)
				{
					try{
						String poiName=driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='"+j+"']/android.widget.TextView[@resource-id='com.one20.ota:id/poiTitle']")).getText().toString();
						String poiAddress=driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='"+j+"']/android.widget.TextView[@resource-id='com.one20.ota:id/address']")).getText().toString();
						allDeals.add(poiName+" "+poiAddress);
					}
					catch (NoSuchElementException e)
					{

					}
				}
				try
				{
					driver.swipe(startx2, starty, startx, endy, 2000);
				}
				catch(Exception e)
				{
					driver.swipe(startx2, startyException, startx, endy, 2000);
				}
				Thread.sleep(3000);
			}
			System.out.println("Length of ArrayList: "+allDeals.size());
			Set<String> set = new LinkedHashSet<String>();
			for (int i=0;i<allDeals.size();i++)
			{
				set.add(allDeals.get(i));
			}
			poiCount=set.size();
			System.out.println("Length of set is: "+poiCount);
			Iterator<String> iterator=set.iterator();
			int i=0;
			while(iterator.hasNext())
			{
				System.out.println("POI"+(i+1)+": "+iterator.next());
				i++;
			}
		}
	}
	@Then("POI count should be 40")
	public void verifyPoiCount()
	{
		try
		{
			Assert.assertEquals(40, poiCount);
		}
		catch (Exception e)
		{
			takeScreenShot();
			Assert.fail("POI Count is not 40");
		}
	}
	@When("user goes to POI within 2 miles radius")
	public void openPOIin2miles()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidPlanMapView.openPOI2Miles();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosPlanMapView.openPOI2Miles();
		}
		else
		{
			tabletPlanMapView.openPOI2Miles();
		}
	}
	@Then("updated parking status is submitted")
	public void verifyParkingStatusUpdated()
	{ 
		boolean confirmation;

		if (flag.equalsIgnoreCase("android"))
		{
			confirmation=androidPOIMoreInfo.verifyParkingUpdated();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			confirmation=iospoiMoreInfo.verifyParkingUpdated();
		}
		else
		{
			confirmation=tabletPOIMoreInfo.VerifyParkingUpdated();
		}
		try
		{
			Assert.assertEquals(true, confirmation);
		}
		catch (Exception e)
		{
			takeScreenShot();
			Assert.fail("Could not update parking");
		}
	}
	@When("opens Navigate screen")
	public void openNavigate()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidPOIMoreInfo.openNavigateScreen();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iospoiMoreInfo.openNavigateScreen();
		}
		else
		{
			tabletPOIMoreInfo.openNavigateScreen();
		}

	}

	@Then("Truck Safe Navigation option should be displayed")
	public void verifyTruckSafe()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidNavigate.verifyTruckSafeNavDisplayed();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosNavigate.verifyTruckSafeNavDisplayed();
		}
		else
		{
			tabletNavigate.verifyTruckSafeNavDisplayed();
		}
	}
	@Given("user goes to plan map view")
	public void goToPlan()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidNavigation.TapPlan();		
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosNavigation.TapPlan();
		}
		else
		{
			tabletNavigation.TapPlan();
		}
	}
	@When("chooses Google Maps/Apple maps")
	public void goToGoogleorAppleMaps()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidNavigate.openGoogleMaps();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosNavigate.openAppleMaps();
		}
		else
		{
			tabletNavigate.openGoogleMaps();
		}
	}
	@Then("Google Maps/Apple Maps should get launched")
	public void verifyGoogleMapsOpened()
	{
		try
		{
			if (flag.equalsIgnoreCase("android"))
			{
				androidNavigate.verifyGoogleMapsDisplayed();
			}
			else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
			{
				iosNavigate.verifyAppleMapsDisplayed();
			}
			else
			{
				tabletNavigate.verifyGoogleMapsDisplayed();
			}
		}
		catch (Exception e)
		{

		}
		finally
		{
			driver.resetApp();
		}
	}
	@When("Submits a review for that POI")
	public void submitReview()
	{
		if(flag.equalsIgnoreCase("android"))
		{
			androidPOIMoreInfo.submitAReview(reviewText);
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iospoiMoreInfo.submitAReview(reviewText);
		}
		else
		{
			tabletPOIMoreInfo.submitAReview(reviewText);
		}
	}
	@Then("review is shown at the top in the reviews tab")
	public void verifyReview()
	{
		if(flag.equalsIgnoreCase("andorid"))
		{
			androidPOIMoreInfo.verifyReviewed(reviewText);
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iospoiMoreInfo.verifyReviewed(reviewText);
		}
		else
		{
			tabletPOIMoreInfo.verifyReviewed(reviewText);
		}

	}
}

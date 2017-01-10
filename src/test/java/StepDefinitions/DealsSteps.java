package StepDefinitions;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.pack.base.Constants;
import com.pack.base.TestBaseSetup;
import com.pack.screens.Android.AndroidLogIn;
import com.pack.screens.Android.AndroidNavigation;
import com.pack.screens.Android.AndroidPlanMapView;
import com.pack.screens.Android.AndroidSave;
import com.pack.screens.Android.AndroidSignUpLogin;
import com.pack.screens.Tablet.TabletLogIn;
import com.pack.screens.Tablet.TabletNavigation;
import com.pack.screens.Tablet.TabletPlanMapView;
import com.pack.screens.Tablet.TabletSave;
import com.pack.screens.Tablet.TabletSignUpLogin;
import com.pack.screens.iOS.IOSLogIn;
import com.pack.screens.iOS.IOSNavigation;
import com.pack.screens.iOS.IOSPlanMapView;
import com.pack.screens.iOS.IOSSave;
import com.pack.screens.iOS.IOSSignUpLogin;

import net.thucydides.core.annotations.Steps;

public class DealsSteps extends TestBaseSetup {
	@Steps
	AndroidSignUpLogin androidsignUpLogin;
	AndroidLogIn androidLogIn;
	AndroidNavigation androidNavigation;
	AndroidPlanMapView androidPlanMapView;
	AndroidSave androidSave;

	IOSSignUpLogin iosSignUpLogin;
	IOSLogIn iosLogIn;
	IOSNavigation iosNavigation;
	IOSPlanMapView iosPlanMapView;
	IOSSave iosSave;

	TabletSignUpLogin tabletSignUpLogin;
	TabletLogIn tabletLogIn;
	TabletNavigation tabletNavigation;
	TabletPlanMapView tabletPlanMapView;
	TabletSave tabletSave;

	@BeforeStory
	public void setup()
	{
		driver=getDriver();
	}

	@Given("user is on plan map view screen")
	public void openPlan()
	{
		try
		{
			androidsignUpLogin=new AndroidSignUpLogin(driver);
			androidLogIn=new AndroidLogIn(driver);
			androidNavigation=new AndroidNavigation(driver);
			androidPlanMapView=new AndroidPlanMapView(driver);
			androidSave=new AndroidSave(driver, driver);

			iosSignUpLogin=new IOSSignUpLogin(driver);
			iosLogIn=new IOSLogIn(driver);
			iosNavigation=new IOSNavigation(driver);
			iosPlanMapView=new IOSPlanMapView(driver);
			iosSave=new IOSSave(driver, driver);

			tabletSignUpLogin=new TabletSignUpLogin(driver);
			tabletLogIn=new TabletLogIn(driver);
			tabletNavigation=new TabletNavigation(driver);
			tabletPlanMapView=new TabletPlanMapView(driver);
			tabletSave=new TabletSave(driver, driver);

			if (flag.equalsIgnoreCase("android"))
			{
				androidsignUpLogin.WaitForLogo();
				androidsignUpLogin.TapHaveAccount();
				androidLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
			}
			else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
			{
//				iosSignUpLogin.WaitForLogo();
//				iosSignUpLogin.TapHaveAccount();
//				iosLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);			

				iosPlanMapView.VerifyPlanScreen();

			}
			else
			{
				tabletSignUpLogin.WaitForLogo();
				tabletSignUpLogin.TapHaveAccount();
				tabletLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	@When("user goes to save tab")
	public void openSave()
	{
		if(flag.equalsIgnoreCase("android"))
		{
			androidNavigation.TapSave();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosNavigation.TapSave();
		}
		else
		{
			tabletNavigation.TapSave();
		}
	}
	@Given("user is on save tab")
	public void onSave()
	{
		if(flag.equalsIgnoreCase("android"))
		{
			androidNavigation.TapSave();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosNavigation.TapSave();
		}
		else
		{
			tabletNavigation.TapSave();
		}
	}
	@When("sorts deals by recently added")
	public void sortByStartDate()
	{
		if(flag.equalsIgnoreCase("android"))
		{
			androidSave.sortByStartDate();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosSave.sortByStartDate();

		}
		else
		{
			tabletSave.sortByStartDate();
		}
	}
	@When("sorts deals by expiring soon")
	public void sortByEndDate()
	{
		if(flag.equalsIgnoreCase("android"))
		{
			androidSave.sortByEndDate();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosSave.sortByEndDate();

		}
		else
		{
			tabletSave.sortByEndDate();
		}
	}
	@When("user filters deals")
	public void whenFiltered()
	{ 
		if (flag.equalsIgnoreCase("android"))
		{
			androidSave.filterDeals();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
		iosSave.filterDeals();
		}
		else
		{
			tabletSave.filterDeals();
		}
	}
	@Then("deals should get sorted by start date")
	public void verifySortByStartDate()
	{
		if(flag.equalsIgnoreCase("android"))
		{
			androidSave.verifySortedByStartDate();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosSave.verifySortedByStartDate();
		}
		else
		{
			tabletSave.verifySortedByStartDate();
		}
	}
	@Then("deals should get sorted by end date")
	public void verifySortByEndDate()
	{
		if(flag.equalsIgnoreCase("android"))
		{
			androidSave.verifySortedByEndDate();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosSave.verifySortedByEndDate();

		}
		else
		{
			tabletSave.verifySortedByEndDate();
		}
	}
	@Then("user should get correct number of deals on save screen")
	public void verifyDealFilters()
	{
		if(flag.equalsIgnoreCase("android"))
		{
			androidSave.verifyFiltered();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
		iosSave.verifyFiltered();
		}
		else
		{
			tabletSave.verifyFiltered();
		}
	}
}

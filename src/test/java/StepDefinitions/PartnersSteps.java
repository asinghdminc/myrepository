package StepDefinitions;

import java.util.ArrayList;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.pack.base.Constants;
import com.pack.base.TestBaseSetup;
import com.pack.screens.Android.AndroidLogIn;
import com.pack.screens.Android.AndroidMore;
import com.pack.screens.Android.AndroidNavigation;
import com.pack.screens.Android.AndroidPartners;
import com.pack.screens.Android.AndroidPlanMapView;
import com.pack.screens.Android.AndroidSignUpLogin;
import com.pack.screens.Tablet.TabletLogIn;
import com.pack.screens.Tablet.TabletMore;
import com.pack.screens.Tablet.TabletNavigation;
import com.pack.screens.Tablet.TabletPartners;
import com.pack.screens.Tablet.TabletPlanMapView;
import com.pack.screens.Tablet.TabletProfileInformation;
import com.pack.screens.Tablet.TabletSignUpLogin;
import com.pack.screens.iOS.IOSLogIn;
import com.pack.screens.iOS.IOSMore;
import com.pack.screens.iOS.IOSNavigation;
import com.pack.screens.iOS.IOSPlanMapView;
import com.pack.screens.iOS.IOSProfileInformation;
import com.pack.screens.iOS.IOSSignUpLogin;

import junit.framework.Assert;
import net.thucydides.core.annotations.Steps;

public class PartnersSteps extends TestBaseSetup {

	@Steps
	AndroidSignUpLogin androidsignUpLogin;
	AndroidLogIn androidLogIn;
	AndroidNavigation androidNavigation;
	AndroidMore androidMore;
	AndroidPlanMapView androidPlanMapView;
	AndroidPartners androidPartners;
	
	TabletSignUpLogin tabletSignUpLogin;
	TabletLogIn tabletLogIn;
	TabletNavigation tabletNavigation;
	TabletMore tabletMore;
	TabletPlanMapView tabletPlanMapView;
	TabletProfileInformation tabletProfileInformation;
	TabletPartners tabletPartners;

	ArrayList<String> partnerapps= new ArrayList<String>();

	@BeforeStory
	public void setup()
	{
		driver=getDriver();
	}
	@Given("user is on plan home screen")
	public void openHome()
	{
		androidsignUpLogin=new AndroidSignUpLogin(driver);
		androidLogIn=new AndroidLogIn(driver);
		androidMore=new AndroidMore(driver, driver);
		androidPartners=new AndroidPartners(driver, driver);
		androidNavigation=new AndroidNavigation(driver);
		androidPlanMapView=new AndroidPlanMapView(driver);
		
		tabletSignUpLogin=new TabletSignUpLogin(driver);
		tabletLogIn=new TabletLogIn(driver);
		tabletMore=new TabletMore(driver, driver);
		tabletPartners=new TabletPartners(driver, driver);
		tabletNavigation=new TabletNavigation(driver);
		tabletPlanMapView=new TabletPlanMapView(driver);
		
		
		if (flag.equalsIgnoreCase("Android"))
		{
			androidsignUpLogin.WaitForLogo();
			androidsignUpLogin.TapHaveAccount();
			androidLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
		}
		else if (flag.equalsIgnoreCase("Tablet")||flag.equalsIgnoreCase("Android Tablet"))
		{
			tabletSignUpLogin.WaitForLogo();
			tabletSignUpLogin.TapHaveAccount();
			tabletLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
		}
	}
	@When ("user goes to more options screen")
	public void openMore()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidNavigation.TapMore();
		}
		else if (flag.equalsIgnoreCase("tablet")||flag.equalsIgnoreCase("android tablet"))
		{
			tabletNavigation.TapMore();
		}
	}
	@When("opens partner screen")
	public void openPartners()
	{
		if (flag.equalsIgnoreCase("android"))
			androidMore.TapPartners();
		else if (flag.equalsIgnoreCase("tablet")||flag.equalsIgnoreCase("android tablet"))
			tabletMore.TapPartners();
	}
	@Then("$Love is shown")
	public void verifyLoveTravelCenterApp(@Named("Love") String loveApp)
	{
		partnerapps=androidPartners.ReadPartnerApps();
		if(flag.equalsIgnoreCase("android"))
		{
			try
			{
				Assert.assertEquals(loveApp, partnerapps.get(0));
			}
			catch(Exception e)
			{
				takeScreenShot();
				Assert.fail("Love's Travel Stops is not shown");
			}
		}
		else if (flag.equalsIgnoreCase("tablet")||flag.equalsIgnoreCase("android tablet"))
		{
			try
			{
				Assert.assertEquals(loveApp, partnerapps.get(0));
			}
			catch(Exception e)
			{
				takeScreenShot();
				Assert.fail("Love's Travel Stops is not shown");
			}
		}
	}	
}
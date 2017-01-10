package StepDefinitions;

import java.util.ArrayList;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.pack.base.Constants;
import com.pack.base.TestBaseSetup;
import com.pack.screens.Android.AndroidLogIn;
import com.pack.screens.Android.AndroidMore;
import com.pack.screens.Android.AndroidNavigation;
import com.pack.screens.Android.AndroidPlanMapView;
import com.pack.screens.Android.AndroidProfileInformation;
import com.pack.screens.Android.AndroidSignUpLogin;
import com.pack.screens.Tablet.TabletLogIn;
import com.pack.screens.Tablet.TabletMore;
import com.pack.screens.Tablet.TabletNavigation;
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

public class UpdateProfileInformationSteps extends TestBaseSetup {

	@Steps
	AndroidSignUpLogin androidsignUpLogin;
	AndroidLogIn androidLogIn;
	AndroidNavigation androidNavigation;
	AndroidMore androidMore;
	AndroidPlanMapView androidPlanMapView;
	AndroidProfileInformation androidProfileInformation;

	IOSSignUpLogin iosSignUpLogin;
	IOSLogIn iosLogIn;
	IOSNavigation iosNavigation;
	IOSMore iosMore;
	IOSPlanMapView iosPlanMapView;
	IOSProfileInformation iosProfileInformation;
	
	TabletSignUpLogin tabletSignUpLogin;
	TabletLogIn tabletLogIn;
	TabletNavigation tabletNavigation;
	TabletMore tabletMore;
	TabletPlanMapView tabletPlanMapView;
	TabletProfileInformation tabletProfileInformation;

	@BeforeStory
	public void setup()
	{
		driver=getDriver();
	}

	@Given("user is on plan screen map view")
	public void LoginBeforePasswordChange()
	{
		androidsignUpLogin=new AndroidSignUpLogin(driver);
		androidLogIn=new AndroidLogIn(driver);
		androidMore=new AndroidMore(driver, driver);
		androidProfileInformation=new AndroidProfileInformation(driver,driver);
		androidNavigation=new AndroidNavigation(driver);
		androidPlanMapView=new AndroidPlanMapView(driver);

		iosSignUpLogin=new IOSSignUpLogin(driver);
		iosLogIn=new IOSLogIn(driver);
		iosMore=new IOSMore(driver);
		iosProfileInformation=new IOSProfileInformation(driver, driver);
		iosNavigation=new IOSNavigation(driver);
		iosPlanMapView=new IOSPlanMapView(driver);

		tabletSignUpLogin=new TabletSignUpLogin(driver);
		tabletLogIn=new TabletLogIn(driver);
		tabletMore=new TabletMore(driver, driver);
		tabletProfileInformation=new TabletProfileInformation(driver, driver);
		tabletNavigation=new TabletNavigation(driver);
		tabletPlanMapView=new TabletPlanMapView(driver);
		
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

	@When("user goes to more")
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

	@When("goes to profile infomation")
	public void OpenProfileInfo()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidMore.TapProfileInfo();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosMore.TapProfileInfo();
		}
		else
		{
			tabletMore.TapProfileInfo();
		}
	}
	@When("updates the profile information")
	public void UpdateProfileInfo()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidProfileInformation.UpdateProfile("Arpit", "Singh", "9999999999", "Alabama", "Male", "MyHandle12", "Independent Owner/Operator", "Local", "AddressLine1 Updated", "AddressLine2 Updated", "City Updated", "Alaska", "12345");
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosProfileInformation.UpdateProfile("Arpit", "Singh", "9999999999", "Alabama", "Male", "MyHandle12", "Independent Owner/Operator", "Local", "AddressLine1 Updated", "AddressLine2 Updated", "City Updated", "Alaska", "12345");
		}
		else
		{
			tabletProfileInformation.UpdateProfile("Arpit", "Singh", "9999999999", "Alabama", "Male", "MyHandle12", "Independent Owner/Operator", "Local", "AddressLine1 Updated", "AddressLine2 Updated", "City Updated", "Alaska", "12345");
		}
	}
	@Then("user is able see the updated profile information")
	public void VerifyProfileInfo()
	{
		System.out.println("In Then");
		ArrayList<String> profileContent;
		if (flag.equalsIgnoreCase("android"))
		{
			profileContent=androidProfileInformation.ReadProfile();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosMore.TapProfileInfo();
			profileContent=iosProfileInformation.ReadProfile();
		}
		else
		{
			profileContent=tabletProfileInformation.ReadProfile();
		}
		System.out.println(profileContent);
		try{
			Assert.assertEquals("Arpit", profileContent.get(0));
			Assert.assertEquals("Singh", profileContent.get(1));
			Assert.assertEquals("(999) 999-9999", profileContent.get(2));
			Assert.assertEquals("Alabama", profileContent.get(3));
			Assert.assertEquals("Male", profileContent.get(4));
			Assert.assertEquals("MyHandle12", profileContent.get(5));
			Assert.assertEquals("Independent Owner/Operator", profileContent.get(6));
			Assert.assertEquals("Local", profileContent.get(7));
			Assert.assertEquals("AddressLine1 Updated", profileContent.get(8));
			Assert.assertEquals("AddressLine2 Updated", profileContent.get(9));
			Assert.assertEquals("City Updated", profileContent.get(10));
			Assert.assertEquals("Alabama", profileContent.get(11));
			Assert.assertEquals("12345", profileContent.get(12));
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
}

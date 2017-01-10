package StepDefinitions;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;

import com.pack.base.Constants;
import com.pack.base.TestBaseSetup;
import com.pack.screens.Android.AndroidLogIn;
import com.pack.screens.Android.AndroidMore;
import com.pack.screens.Android.AndroidNavigation;
import com.pack.screens.Android.AndroidONE20Credentials;
import com.pack.screens.Android.AndroidPlanMapView;
import com.pack.screens.Android.AndroidSignUpLogin;
import com.pack.screens.Tablet.TabletLogIn;
import com.pack.screens.Tablet.TabletMore;
import com.pack.screens.Tablet.TabletNavigation;
import com.pack.screens.Tablet.TabletONE20Credentials;
import com.pack.screens.Tablet.TabletPlanMapView;
import com.pack.screens.Tablet.TabletSignUpLogin;
import com.pack.screens.iOS.IOSLogIn;
import com.pack.screens.iOS.IOSMore;
import com.pack.screens.iOS.IOSNavigation;
import com.pack.screens.iOS.IOSONE20Credentials;
import com.pack.screens.iOS.IOSPlanMapView;
import com.pack.screens.iOS.IOSSignUpLogin;

import net.thucydides.core.annotations.Steps;

public class One20CredentialsSteps extends TestBaseSetup {
	
	public String CurrentPassword="qwerty12";
	public String NewPassword="qwerty1";

	@Steps
	AndroidSignUpLogin androidsignUpLogin;
	AndroidLogIn androidLogIn;
	AndroidNavigation androidNavigation;
	AndroidMore androidMore;
	AndroidPlanMapView androidPlanMapView;
	AndroidONE20Credentials androidONE20Credentials;

	IOSSignUpLogin iosSignUpLogin;
	IOSLogIn iosLogIn;
	IOSNavigation iosNavigation;
	IOSMore iosMore;
	IOSONE20Credentials iosONE20Credentials;
	IOSPlanMapView iosPlanMapView;
	
	TabletSignUpLogin tabletSignUpLogin;
	TabletLogIn tabletLogin;
	TabletNavigation tabletNavigation;
	TabletMore tabletMore;
	TabletONE20Credentials tabletONE20Credentials;
	TabletPlanMapView tabletPlanMapView;

	@BeforeStory
	public void setup()
	{
		driver=getDriver();
	}

	@Given("user is on plan screen")
	public void LoginBeforePasswordChange()
	{
		androidsignUpLogin=new AndroidSignUpLogin(driver);
		androidLogIn=new AndroidLogIn(driver);
		androidMore=new AndroidMore(driver, driver);
		androidONE20Credentials=new AndroidONE20Credentials(driver);
		androidNavigation=new AndroidNavigation(driver);
		androidPlanMapView=new AndroidPlanMapView(driver);

		iosSignUpLogin=new IOSSignUpLogin(driver);
		iosLogIn=new IOSLogIn(driver);
		iosMore=new IOSMore(driver);
		iosONE20Credentials=new IOSONE20Credentials(driver);
		iosNavigation=new IOSNavigation(driver);
		iosPlanMapView=new IOSPlanMapView(driver);
		
		tabletSignUpLogin= new TabletSignUpLogin(driver);
		tabletLogin=new TabletLogIn(driver);
		tabletMore=new TabletMore(driver, driver);
		tabletONE20Credentials=new TabletONE20Credentials(driver);
		tabletNavigation=new TabletNavigation(driver);
		tabletPlanMapView=new TabletPlanMapView(driver);

		if (flag.equalsIgnoreCase("Android"))
		{
			androidsignUpLogin.WaitForLogo();
			androidsignUpLogin.TapHaveAccount();
			androidLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, CurrentPassword);
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))		
		{
//			iosSignUpLogin.WaitForLogo();
//			iosSignUpLogin.TapHaveAccount();
//			iosLogIn.PerformLogIn("asingh@dminc.com", CurrentPassword);		
			
			iosPlanMapView.VerifyPlanScreen();
		}
		else
		{
			tabletSignUpLogin.WaitForLogo();
			tabletSignUpLogin.TapHaveAccount();
			tabletLogin.PerformLogIn(Constants.USER_EMAIL_ADDRESS, CurrentPassword);
		}
	}

	@When("user taps more")
	public void OpenMore()
	{
		try{
			if (flag.equalsIgnoreCase("android"))
			{
				androidNavigation.TapMore();
			}
			else if(flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
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

	@When("goes to ONE20 Credentials")
	public void OpenONE20Credentials()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidMore.TapOne20Credentials();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosMore.TapOne20Credentials();
		}
		else
		{
			tabletMore.TapOne20Credentials();
		}
	}

	@When("enter updates the password")
	public void UpdatePassword()
	{
		if(flag.equalsIgnoreCase("android"))
		{
			androidONE20Credentials.ChangePassword(CurrentPassword, NewPassword, NewPassword);
			androidMore.TapLogout();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosONE20Credentials.ChangePassword(CurrentPassword, NewPassword, NewPassword);
			iosMore.TapLogout();
		}
		else
		{	
			tabletONE20Credentials.ChangePassword(CurrentPassword, NewPassword, NewPassword);
			tabletMore.TapLogout();
		}
	}
	@Then("user is able to login with the new password")
	public void LoginAfterPasswordChange()
	{
		if (flag.equalsIgnoreCase("Android"))
		{
			androidLogIn.PerformLogIn("asingh@dminc.com", NewPassword);
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosLogIn.PerformLogIn("asingh@dminc.com", NewPassword);
		}
		else
		{
			tabletLogin.PerformLogIn("asingh@dminc.com", NewPassword);
		}
		
		String plandisplayed = null;
		if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			plandisplayed=iosPlanMapView.VerifyPlanScreen();	
		}
		else if (flag.equalsIgnoreCase("android"))
		{
			plandisplayed=androidPlanMapView.VerifyPlanScreen();
		}
		else
		{
			plandisplayed=tabletPlanMapView.VerifyPlanScreen();
		}
		try
		{
			System.out.println(plandisplayed);
			Assert.assertEquals(plandisplayed, "Element Displayed");
		}
		catch(Exception e)
		{
			takeScreenShot();
			Assert.fail("Could not login");
		}
		finally
		{

			driver.resetApp();


		}

	}

}

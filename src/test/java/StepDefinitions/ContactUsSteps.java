package StepDefinitions;

import java.util.Random;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.pack.base.Constants;
import com.pack.base.TestBaseSetup;
import com.pack.screens.Android.AndroidAbout;
import com.pack.screens.Android.AndroidContactUs;
import com.pack.screens.Android.AndroidLogIn;
import com.pack.screens.Android.AndroidMore;
import com.pack.screens.Android.AndroidNavigation;
import com.pack.screens.Android.AndroidPartners;
import com.pack.screens.Android.AndroidPlanMapView;
import com.pack.screens.Android.AndroidShare;
import com.pack.screens.Android.AndroidSignUpLogin;
import com.pack.screens.Tablet.TabletAbout;
import com.pack.screens.Tablet.TabletContactUs;
import com.pack.screens.Tablet.TabletLogIn;
import com.pack.screens.Tablet.TabletMore;
import com.pack.screens.Tablet.TabletNavigation;
import com.pack.screens.Tablet.TabletPartners;
import com.pack.screens.Tablet.TabletPlanMapView;
import com.pack.screens.Tablet.TabletShare;
import com.pack.screens.Tablet.TabletSignUpLogin;
import com.pack.screens.iOS.IOSAbout;
import com.pack.screens.iOS.IOSContactUs;
import com.pack.screens.iOS.IOSLogIn;
import com.pack.screens.iOS.IOSMore;
import com.pack.screens.iOS.IOSNavigation;
import com.pack.screens.iOS.IOSPlanMapView;
import com.pack.screens.iOS.IOSProfileInformation;
import com.pack.screens.iOS.IOSShare;
import com.pack.screens.iOS.IOSSignUpLogin;

import junit.framework.Assert;
import net.thucydides.core.annotations.Steps;

public class ContactUsSteps extends TestBaseSetup{

	static int randomnum = randInt(1, 20000);
	public static String email_id = "one20"+randomnum+"@one20test.com";	
	
	@Steps
	AndroidSignUpLogin androidsignUpLogin;
	AndroidLogIn androidLogIn;
	AndroidNavigation androidNavigation;
	AndroidMore androidMore;
	AndroidPlanMapView androidPlanMapView;
	AndroidPartners androidPartners;
	AndroidContactUs androidContactUs;
	AndroidAbout androidAbout;
	AndroidShare androidShare;

	IOSSignUpLogin iosSignUpLogin;
	IOSLogIn iosLogIn;
	IOSNavigation iosNavigation;
	IOSMore iosMore;
	IOSPlanMapView iosPlanMapView;
	IOSProfileInformation iosProfileInformation;
	IOSContactUs iosContactUs;
	IOSAbout iosAbout;
	IOSShare iosShare;

	TabletSignUpLogin tabletSignUpLogin;
	TabletLogIn tabletLogIn;
	TabletNavigation tabletNavigation;
	TabletMore tabletMore;
	TabletPlanMapView tabletPlanMapView;
	TabletPartners tabletPartners;
	TabletContactUs tabletContactUs;
	TabletAbout tabletAbout;
	TabletShare tabletShare;


	@BeforeStory
	public void setup()
	{
		driver=getDriver();
	}
	@Given("user is on home screen")
	public void openHome()
	{
		androidsignUpLogin=new AndroidSignUpLogin(driver);
		androidLogIn=new AndroidLogIn(driver);
		androidMore=new AndroidMore(driver, driver);
		androidPartners=new AndroidPartners(driver, driver);
		androidNavigation=new AndroidNavigation(driver);
		androidPlanMapView=new AndroidPlanMapView(driver);
		androidContactUs=new AndroidContactUs(driver);
		androidAbout=new AndroidAbout(driver, driver);
		androidShare=new AndroidShare(driver);

		iosLogIn=new IOSLogIn(driver);
		iosSignUpLogin=new IOSSignUpLogin(driver);
		iosMore=new IOSMore(driver);
		iosNavigation=new IOSNavigation(driver);
		iosPlanMapView=new IOSPlanMapView(driver);
		iosContactUs=new IOSContactUs(driver);
		iosAbout=new IOSAbout(driver, driver);
		iosShare=new IOSShare(driver);
		
		tabletSignUpLogin=new TabletSignUpLogin(driver);
		tabletLogIn=new TabletLogIn(driver);
		tabletMore=new TabletMore(driver, driver);
		tabletPartners=new TabletPartners(driver, driver);
		tabletNavigation=new TabletNavigation(driver);
		tabletPlanMapView=new TabletPlanMapView(driver);
		tabletContactUs=new TabletContactUs(driver);
		tabletAbout=new TabletAbout(driver, driver);
		tabletShare=new TabletShare(driver);
		
		if (flag.equalsIgnoreCase("Android"))
		{	
			androidsignUpLogin.WaitForLogo();
			androidsignUpLogin.TapHaveAccount();
			androidLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
//						iosSignUpLogin.WaitForLogo();
//						iosSignUpLogin.TapHaveAccount();
//						iosLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
			iosPlanMapView.VerifyPlanScreen();
		}
		else
		{
			tabletSignUpLogin.WaitForLogo();
			tabletSignUpLogin.TapHaveAccount();
			tabletLogIn.PerformLogIn(Constants.USER_EMAIL_ADDRESS, Constants.USER_PASSWORD);
		}
	}
	@When ("user navigates to more")
	public void openMoreScreenNew()
	{
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

	@When("opens contact us screen")
	public void openContactUs()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidMore.TapContactUs();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosMore.TapContactUs();
		}
		else
		{
			tabletMore.TapContactUs();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Then("user is able to call ONE20")
	public void verifyCallPopup()
	{	
		if(flag.equalsIgnoreCase("android"))
		{
			try{
				androidContactUs.TapCallBtn();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Assert.assertEquals(true, androidContactUs.callPopUp());
			}
			catch(Exception e)
			{
				takeScreenShot();
				Assert.fail("Call popup not displayed");
			}
			finally
			{
				androidContactUs.tapNo();
			}
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			try{

				Assert.assertEquals(true, iosContactUs.callPopUp());
			}
			catch(Exception e)
			{
				takeScreenShot();
				Assert.fail("Call popup not displayed");
			}
		}
		else
		{

			try{
				Assert.assertEquals(true, tabletContactUs.verifyCallBtn());
			}
			catch(Exception e)
			{
				takeScreenShot();
				Assert.fail("Call popup not displayed");
			}
		}
	}
	@Then("user gets an option to contact ONE20 via email")
	public void emailDisplayed()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			try
			{
				Assert.assertEquals(true, androidContactUs.emailButtonDisplay());
			}
			catch(Exception e)
			{
				takeScreenShot();
				Assert.fail("Email button not displayed");
			}
			finally
			{
				driver.resetApp();
			}

		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			try
			{
				Assert.assertEquals(true, iosContactUs.emailButtonDisplay());
			}
			catch(Exception e)
			{
				takeScreenShot();
				Assert.fail("Email button not displayed");
			}
			finally
			{
				driver.resetApp();
			}
		}
		else
		{
			try
			{
				Assert.assertEquals(true, tabletContactUs.emailButtonDisplay());
			}
			catch(Exception e)
			{
				takeScreenShot();
				Assert.fail("Email button not displayed");
			}
			finally
			{
				driver.resetApp();
			}
			
		}
	}
	@When("user goes to About screen")
	public void openAbout()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			driver.scrollToExact("About");
			androidMore.TapAbout();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosMore.TapAbout();
		}
		else
		{
			driver.scrollToExact("About");
			tabletMore.TapAbout();
		}
	}
	@When("user goes to Share screen")
	public void openShare()
	{
		if (flag.equalsIgnoreCase("android"))
			androidAbout.TapShare();
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
			iosAbout.TapShare();
		else
			tabletAbout.TapShare();
	}
	@When("sends invite to an email id")
	public void shareONE20()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidShare.ShareOne20(email_id);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosShare.ShareOne20(email_id);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			tabletShare.ShareOne20(email_id);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Then("invite should be sent")
	public void verifyInviteSent()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			try
			{
				Assert.assertEquals(true, androidShare.verifyConfirmationPopup());
			}
			catch (Exception e)
			{
				takeScreenShot();
				Assert.fail("Invitation not sent");
			}
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			try
			{
				Assert.assertEquals(true, iosShare.verifyConfirmationPopup());
			}
			catch (Exception e)
			{
				takeScreenShot();
				Assert.fail("Invitation not sent");
			}
		}
		else
		{
			try
			{
				Assert.assertEquals(true, tabletShare.verifyConfirmationPopup());
			}
			catch (Exception e)
			{
				takeScreenShot();
				Assert.fail("Invitation not sent");
			}
		}
	}

	public static int randInt(int min, int max) {

		Random rand= new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}

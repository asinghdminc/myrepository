package StepDefinitions;

import java.util.Random;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;

import com.pack.base.TestBaseSetup;
import com.pack.screens.Android.AndroidCreateAccount;
import com.pack.screens.Android.AndroidPlanMapView;
import com.pack.screens.Android.AndroidSignUpLogin;
import com.pack.screens.Android.AndroidVerifyAge;
import com.pack.screens.Tablet.TabletCreateAccount;
import com.pack.screens.Tablet.TabletPlanMapView;
import com.pack.screens.Tablet.TabletSignUpLogin;
import com.pack.screens.Tablet.TabletVerifyAge;
import com.pack.screens.iOS.IOSCreateAccount;
import com.pack.screens.iOS.IOSPlanMapView;
import com.pack.screens.iOS.IOSSignUpLogin;
import com.pack.screens.iOS.IOSVerifyAge;

import io.appium.java_client.AppiumDriver;
import net.thucydides.core.annotations.Steps;

public class CreateAccountSteps extends TestBaseSetup {
	private AppiumDriver driver;

	static int randomnum = randInt(1, 20000);
	public static String email_id = "one20"+randomnum+"@one20test.com";	
	public static String password="qwerty1";
	public static String confirm_password="qwerty1";

	@Steps
	AndroidSignUpLogin androidsignUpLogin;
	AndroidCreateAccount androidCreateAccount;
	AndroidVerifyAge androidVerifyAge;
	AndroidPlanMapView androidPlanMapView;

	IOSSignUpLogin iosSignUpLogin;
	IOSVerifyAge iosVerifyAge;
	IOSCreateAccount iosCreateAccount;
	IOSPlanMapView iosPlanMapView;

	TabletSignUpLogin tabletSignUpLogin;
	TabletVerifyAge tabletVerifyAge;
	TabletCreateAccount tabletCreateAccount;
	TabletPlanMapView tabletPlanMapView;
	
	@BeforeStory
	public void setup()
	{
		driver=getDriver();
	}

	@Given("user is on Sign Up-Login screen")
	public void VerifOpenyAge()
	{
		androidsignUpLogin=new AndroidSignUpLogin(driver);
		androidCreateAccount=new AndroidCreateAccount(driver);
		androidVerifyAge=new AndroidVerifyAge(driver);
		androidPlanMapView=new AndroidPlanMapView(driver);
		
		iosCreateAccount=new IOSCreateAccount(driver);
		iosSignUpLogin=new IOSSignUpLogin(driver);
		iosVerifyAge=new IOSVerifyAge(driver, driver);
		iosPlanMapView=new IOSPlanMapView(driver);
		
		tabletCreateAccount=new TabletCreateAccount(driver);
		tabletSignUpLogin=new TabletSignUpLogin(driver);
		tabletVerifyAge=new TabletVerifyAge(driver);
		tabletPlanMapView=new TabletPlanMapView(driver);

		if (flag.equalsIgnoreCase("android"))
		{
			androidsignUpLogin.WaitForLogo();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosSignUpLogin.WaitForLogo();
		}
		else
		{
			tabletSignUpLogin.WaitForLogo();
		}
	}
	@When("user goes to create account screen")
	public void openCreateAccount()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidsignUpLogin.TapSignUp();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosSignUpLogin.TapSignUp();
		}
		else
		{
			tabletSignUpLogin.TapSignUp();
		}
	}
	@When("creates an account using email and password")
	public void CreateAccount()
	{
		if (flag.equalsIgnoreCase("android"))
		{
			androidCreateAccount.CreateAnAccount(email_id, password, confirm_password);

		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosCreateAccount.CreateAnAccount(email_id, password, confirm_password);

		}
		else
		{
			tabletCreateAccount.CreateAnAccount(email_id, password, confirm_password);
		}

	}
	@Then("user goes to home screen")
	public void PlanScreen()
	{
		String plandisplayed = null;
		if (flag.equalsIgnoreCase("ios"))
		{
			System.out.println("afsafsafsafa");
			plandisplayed=iosPlanMapView.VerifyPlanScreen();	
		}
		else if (flag.equalsIgnoreCase("android"))
		{
			System.out.println("In android plan displayed");
			plandisplayed=androidPlanMapView.VerifyPlanScreen();
		}
		else if (flag.equalsIgnoreCase("tablet"))
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
			if (flag.equalsIgnoreCase("ios"))
			iosCreateAccount.logout();


		}
	}

		public static int randInt(int min, int max) {

			Random rand= new Random();

			int randomNum = rand.nextInt((max - min) + 1) + min;

			return randomNum;
		}
	}

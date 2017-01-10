package StepDefinitions;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;

import com.pack.base.TestBaseSetup;
import com.pack.screens.Android.AndroidLogIn;
import com.pack.screens.Android.AndroidPlanMapView;
import com.pack.screens.Android.AndroidSignUpLogin;
import com.pack.screens.Tablet.TabletLogIn;
import com.pack.screens.Tablet.TabletPlanMapView;
import com.pack.screens.Tablet.TabletSignUpLogin;
import com.pack.screens.iOS.IOSLogIn;
import com.pack.screens.iOS.IOSPlanMapView;
import com.pack.screens.iOS.IOSSignUpLogin;

import io.appium.java_client.AppiumDriver;
import net.thucydides.core.annotations.Steps;

public class LoginSteps extends TestBaseSetup {
	private AppiumDriver driver;

	@Steps
	AndroidSignUpLogin androidsignUpLogin;
	AndroidLogIn androidLogIn;
	AndroidPlanMapView androidPlanMapView;
	IOSSignUpLogin iosSignUpLogin;
	IOSLogIn iosLogIn;
	IOSPlanMapView iosPlanMapView;
	TabletSignUpLogin tabletSignUpLogin;
	TabletLogIn tabletLogIn;
	TabletPlanMapView tabletPlanMapView;


	@BeforeStory
	public void setup()
	{
		driver=getDriver();
	}

	@Given("user is on login screen")
	public void openLogin()
	{
		androidsignUpLogin=new AndroidSignUpLogin(driver);
		androidLogIn=new AndroidLogIn(driver);
		androidPlanMapView=new AndroidPlanMapView(driver);
		iosSignUpLogin=new IOSSignUpLogin(driver);
		iosLogIn=new IOSLogIn(driver);
		iosPlanMapView=new IOSPlanMapView(driver);
		tabletSignUpLogin=new TabletSignUpLogin(driver);
		tabletLogIn=new TabletLogIn(driver);
		tabletPlanMapView=new TabletPlanMapView(driver);

		if (flag.equalsIgnoreCase("android"))
		{
			androidsignUpLogin.WaitForLogo();
			androidsignUpLogin.TapHaveAccount();
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iPHone"))
		{
			iosSignUpLogin.WaitForLogo();
			iosSignUpLogin.TapHaveAccount();
		}
		else if (flag.equalsIgnoreCase("tablet"))
		{
			tabletSignUpLogin.WaitForLogo();
			tabletSignUpLogin.TapHaveAccount();
		}

	}
	@When("user logs in with $email and $password")
	public void login(@Named("email") String email, @Named("password") String password)
	{
		System.out.println(email);
		System.out.println(password);
		if (flag.equalsIgnoreCase("android"))
		{
			androidLogIn.PerformLogIn(email, password);
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			iosLogIn.PerformLogIn(email, password);
		}
		else if (flag.equalsIgnoreCase("tablet"))
		{
			tabletLogIn.PerformLogIn(email, password);
		}

	}
	@Then("user lands on plan screen map view")
	public void PlanScreen()
	{
		String plandisplayed = null;
		if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
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
			if (flag.equalsIgnoreCase("android"))
			driver.resetApp();


		}

	}

}

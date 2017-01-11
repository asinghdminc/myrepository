package com.pack.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBaseSetup 
{
	protected static AppiumDriver driver;
	public String flag="ios";
	public DesiredCapabilities capabilities = new DesiredCapabilities();

	public AppiumDriver getDriver() {
		return driver;
	}

	@BeforeStories
	public void testCaseSetup() throws MalformedURLException{
		if (flag.equalsIgnoreCase("android"))
		{
			capabilities.setCapability("device","Android");			
			capabilities.setCapability("platformVersion", "4.4.4");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "06ac1be6006950e5");
			capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.one20.ota");
			capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.one20.ota.activities.SplashActivity");
			capabilities.setCapability(MobileCapabilityType.APP, "//Users//Dmi//Downloads//One20.apk");
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		}
		else if (flag.equalsIgnoreCase("ios")||flag.equalsIgnoreCase("iphone"))
		{
			capabilities.setCapability("automationName", "Appium");
			capabilities.setCapability("autoLaunch",true);		
			capabilities.setCapability("showIOSLog",true);
			capabilities.setCapability("platformVersion", "8.4");
			capabilities.setCapability("deviceName", "iPhone");
			capabilities.setCapability("udid","fa39ae68448836a98cf3c0b023283014376f6395");
			capabilities.setCapability("app","//Users//Dmi//Desktop//Payload//One20.app" );
			driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		}
		else
		{
			capabilities.setCapability("device","Android");			
			capabilities.setCapability("platformVersion", "4.4.4");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "015d4a820433fc09");
			capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.one20.ota");
			capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.one20.ota.activities.SplashActivity");
			capabilities.setCapability(MobileCapabilityType.APP, "//Users//Dmi//Downloads//ONE20_QA_Tablet_App_original.apk");
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		}
	}

	@AfterStories
	public void tearDown(){
		if (flag.equalsIgnoreCase("ios"))
		{
			driver.removeApp(Constants.APP_BUNDLE_ID);
			driver.quit();
		}
		else if (flag.equalsIgnoreCase("Android")||flag.equalsIgnoreCase("tablet"))
		{

			driver.quit();
		}
	}

	public void takeScreenShot() {
		String destDir = "screenshots";

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

		new File(destDir).mkdirs();

		String destFile = dateFormat.format(new Date()) + ".png";

		try {

			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
package com.pack.screens.Android;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.pack.base.DefaultGestures;

import groovyjarjarantlr.collections.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class AndroidPOIMoreInfo extends DefaultGestures {

	private AppiumDriver driver1;

	private By poiName=By.xpath("//android.widget.TextView[@resource-id='com.one20.ota:id/textViewPOITitle']");
	private By address=By.id("textViewAddressExit");
	private By openHours=By.id("textViewTimings");
	private By amenities=By.id("relativeLayoutAmenityListItemWrapper");
	private By parkingStatus=By.id("textViewParkingStatus");
	private By navigateBtn=By.id("buttonNavigate");
	private By ratingBtn=By.id("textViewRateButton");
	private By ratingStars=By.id("poiRatingBar");
	private By submitBtn=By.id("btnPOIRattingSubmit");
	private By ratePopUpTxt=By.id("textViewSubmitMessage");
	private By updateParkingLink=By.id("textViewUpdateParkingButton");
	private By parkingStatusBtn=By.id("rl_some");
	private By reviewTxtBox=By.id("editTextPOIExperience");
	private By parkingPopUpTxt=By.id("errorPopUpTextBody");
	private By okBtnMessageBox=By.id("btnRatingSubmitMessage");
	private By reviewsTab=By.xpath("//android.widget.TextView[@text='Reviews']");
	private By reviewsText=By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@resource-id='com.one20.ota:id/expand_text_view']/android.widget.TextView[@index='0']");

	ArrayList<String> amenities_name=new ArrayList<String>();
	ArrayList<WebElement> amenities_list=new ArrayList<WebElement>();
	LinkedHashSet<String> set = new LinkedHashSet<String>();
	String [] expected_amenities={"Overnight Parking", "Parking Spaces (150 spots)", "Deli", "Snack / Coffee Bar", "Wendy's", "Restroom", "Private Showers", "Pump", "Travel Store", "Trucker's Store", "CAT Scales","Certified Scale"};

	public AndroidPOIMoreInfo(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}
	public String ReadPOIName()
	{
		AndroidElement element=(AndroidElement)driver1.findElement(poiName);
		String content=element.getText();
		System.out.println("gfjfjgf"+content);
		return content;
	}
	public String ReadAddress()
	{
		String content=ReadPOIInfo(address);
		return content;
	}
	public String ReadOpenHours()
	{
		String content=ReadPOIInfo(openHours);
		return content;
	}
	public boolean parkingDisplayed()
	{
		return VerifyElementDisplayed(parkingStatus);
	}
	public boolean navigateDisplayed()
	{
		return VerifyElementDisplayed(navigateBtn);
	}
	public List ReadAmenities()
	{
		List amenities_list=(List) new ArrayList<>();
		List elements=(List) driver1.findElements(amenities);
		for(int i=0; i<elements.length();i++)
		{
			amenities_list.add(((WebElement) elements).getText().toString());
		}
		return amenities_list;
	}
	public void ratePOI()
	{
		WaitForElement(ratingBtn);
		TapElement(ratingBtn);
		WaitForElement(ratingStars);
		TapElement(ratingStars);
		TapElement(submitBtn);
		WaitForElement(ratePopUpTxt);
	}
	public boolean verifyRated()
	{
		String rateConfirmationTxt=ReadValue(ratePopUpTxt);
		if (rateConfirmationTxt.equalsIgnoreCase("Your contribution has been added to the location. ONE20 appreciates your help."))

			return true;

		else
			return false;
	}
	public void updateParkingAtPOI()
	{
		WaitForElement(updateParkingLink);
		TapElement(updateParkingLink);
		WaitForElement(parkingStatusBtn);
		TapElement(parkingStatusBtn);
	}
	public boolean verifyParkingUpdated()
	{
		WaitForElement(parkingPopUpTxt);
		String parkingConfirmationTxt=ReadValue(parkingPopUpTxt);
		if (parkingConfirmationTxt.equalsIgnoreCase("We'll use this info to help other ONE20 members."))

			return true;

		else
			return false;
	}
	public void openNavigateScreen()
	{
		WaitForElement(navigateBtn);
		TapElement(navigateBtn);
	}
	public void readAmenities()
	{
		Dimension size=driver1.manage().window().getSize();
		int startx=size.getWidth()/2;
		int endy=(int) (size.getHeight()*0.1);
		int starty=(int) (size.getHeight()*0.5);
		WaitForElement(navigateBtn);
		driver1.scrollToExact("Reviews");
		for(int j=0; j<3;j++)
		{
			try
			{
				amenities_list=(ArrayList<WebElement>) driver1.findElementsById("textViewAmenityName");
			}
			catch(NoSuchElementException e)
			{

			}
			for (int i=0;i<amenities_list.size();i++)
			{
				amenities_name.add(amenities_list.get(i).getText());
			}
			try
			{
				driver1.swipe(startx, starty, startx, endy, 1000);
			}
			catch(Exception e)
			{

			}
		}
		for(int i=0; i<amenities_name.size();i++)
		{
			set.add(amenities_name.get(i));
		}


	}
	public void verifyAmenities()
	{
		ArrayList <String> amenities_actual= new ArrayList<String>();
		Iterator<String> iterator= set.iterator();
		boolean flag = false;
		while (iterator.hasNext())
		{
			amenities_actual.add(iterator.next());
		}
		for (int i=0; i<expected_amenities.length; i++)
		{
			if (expected_amenities[i].equalsIgnoreCase(amenities_actual.get(i)))
			{
				flag= true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		try
		{
			Assert.assertEquals(true, flag);
		}
		catch(Exception e)
		{	
			takeScreenShot();
			Assert.fail("Amenities Did not match");
		}
		finally
		{
			driver1.resetApp();
		}
	}
	public void submitAReview(String reviewTxt) {
		WaitForElement(ratingBtn);
		TapElement(ratingBtn);
		WaitForElement(ratingStars);
		TapElement(ratingStars);
		EnterText(reviewTxtBox, reviewTxt);
		TapElement(submitBtn);
		WaitForElement(okBtnMessageBox);
		TapElement(okBtnMessageBox);
	}
	public void verifyReviewed(String reviewText) 
	{
		WaitForElement(ratingBtn);
		driver1.scrollToExact("Reviews");
		TapElement(reviewsTab);
		String actualReview=ReadValue(reviewsText);
		try
		{
			WaitForElement(reviewsText);
			System.out.println("Expected Reveiw: "+reviewText);
			System.out.println("Actual Review: "+actualReview);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Assert.assertEquals(reviewText, actualReview);
		}
		catch (Exception e)
		{
			takeScreenShot();
			Assert.fail("Review not submitted");
		}
		finally
		{
			driver1.resetApp();
		}
	}

}

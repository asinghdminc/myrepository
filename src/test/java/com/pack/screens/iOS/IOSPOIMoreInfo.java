package com.pack.screens.iOS;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;

import com.pack.base.DefaultGestures;

import groovyjarjarantlr.collections.List;
import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;

public class IOSPOIMoreInfo extends DefaultGestures {

	private AppiumDriver driver1;

	private By poiName=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]");
	private By address=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
	private By openHours=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAButton[1]");
	private By parkingStatus=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[1]");
	private By navigateBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIAButton[1]");
	private By rateBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAButton[1]");
	private By rateStars=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]");
	private By submitBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]");
	private By ratePopUpTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");

	private By updateParkingLink=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAButton[1]");

	private By parkingStatusBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAActionSheet[1]/UIAButton[2]");

	private By parkingPopUpTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");

	private By reviewTxtBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]");
	private By okBtnMessageBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
	private By reviewsTab=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIASegmentedControl[1]/UIAButton[2]");
	private By reviewsText=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIAStaticText[1]");

	ArrayList <String> amenities_actual=new ArrayList <String>();
	String [] expected_amenities={"Overnight Parking", "Parking Spaces (150 spots)", "Deli", "Snack / Coffee Bar", "Wendy's", "Restroom", "Private Showers", "Pump", "Travel Store", "Trucker's Store", "CAT Scales","Certified Scale"};


	public IOSPOIMoreInfo(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}
	public String ReadPOIName()
	{
		String content=ReadValue(poiName);
		return content;
	}
	public String ReadAddress()
	{
		String content=ReadValue(address);
		return content;
	}
	public String ReadOpenHours()
	{
		String content=ReadValue(openHours);
		return content;
	}

	public boolean parkingDisplayed()
	{
		if (ReadValue(parkingStatus).toString().isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public List ReadAmenities()
	{
		List amenities_list=(List) new ArrayList<>();
		for (int i=0;i<25;i++)
		{
			if (driver1.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell["+i+"]")).isDisplayed())
			{
				amenities_list.add(driver1.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell["+i+"]")).getText().toString());
			}
			else
			{
				break;
			}
		}
		return amenities_list;
	}
	public boolean navigateDisplayed() {

		return VerifyElementDisplayed(navigateBtn);
	}
	public void ratePOI() throws InterruptedException {
		WaitForElement(rateBtn);
		TapElement(rateBtn);
		WaitForElement(rateStars);
		TapElement(rateStars);
		TapElement(submitBtn);
		WaitForElement(ratePopUpTxt);
	}
	public boolean verifyRated() {
		String rateConfirmationTxt=ReadValue(ratePopUpTxt);
		if (rateConfirmationTxt.equalsIgnoreCase("Your contribution has been added to the location. ONE20 appreciates your help."))

			return true;

		else
			return false;
	}
	public boolean verifyParkingUpdated() {
		WaitForElement(ratePopUpTxt);
		String parkingConfirmationTxt=ReadValue(ratePopUpTxt);
		System.out.println(ratePopUpTxt);

		if (parkingConfirmationTxt.equalsIgnoreCase("We'll use this info to help other ONE20 members."))

			return true;

		else
			return false;

	}
	public void updateParkingAtPOI() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		TapElement(updateParkingLink);
		WaitForElement(parkingStatusBtn);
		TapElement(parkingStatusBtn);
	}
	public void openNavigateScreen() 
	{
		TapElement(navigateBtn);
	}
	public void readAmenities() {
		for (int i=8; i<25;i++)
		{
			try{
				amenities_actual.add(driver1.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell["+i+"]/UIAStaticText[1]")).getText());
			}
			catch (Exception e)
			{

			}
		}		
	}
	public void verifyAmenities() {
		boolean flag = false;
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
	public void submitAReview(String reviewText) {
		WaitForElement(rateBtn);
		TapElement(rateBtn);
		WaitForElement(rateStars);
		TapElement(rateStars);
		EnterText3(reviewTxtBox, reviewText);
		driver1.getKeyboard().sendKeys(Keys.ENTER);
		TapElement(submitBtn);
		WaitForElement(okBtnMessageBox);
		TapElement(okBtnMessageBox);
	}
	public void verifyReviewed(String reviewText) {
		WaitForElement(rateBtn);
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

package com.pack.screens.Android;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AndroidTruckInfomation extends DefaultGestures {

	private AppiumDriver driver1;

	private By backBtn=By.id("image_button_back");
	private By editBtn=By.id("image_button_edit");
	private By doneButton=By.id("image_button_done");
	private By makeDropDown=By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.Spinner/android.widget.TextView");
	private By makeValue=By.xpath("//android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[@index='1']");
	private By modelTextBox=By.id("model_other");
	private By licensePlateTextBox=By.id("license_plate");
	private By equipmentTypeDropDown=By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='3']/android.widget.Spinner/android.widget.TextView");
	private By yearTextBox=By.id("et_year");
	private By yearValue=By.id("pickers");
	private By colorDropDown=By.id("spinner_arrow_color");
	private By colorNonEdit=By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='5']/android.widget.Spinner/android.widget.TextView");
	private By moreTitle=By.id("settings_partners");

	public AndroidTruckInfomation(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}

	public void TapBackBtn()
	{
		TapElement(backBtn);
	}

	public void UpdateTruckInfo(String Model, String LicensePlateNumber, String Year)
	{
		TapElement(editBtn);

		TapElement(makeDropDown);
		driver1.scrollTo("Make");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		TapElement(makeValue);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		EnterText(modelTextBox, Model);

		EnterText(licensePlateTextBox, LicensePlateNumber);

		TapElement(equipmentTypeDropDown);

		driver1.scrollTo("Equipment Type");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		TapElement(makeValue);	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		TapElement(yearTextBox);
		try{
			driver1.scrollToExact("Color");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//		driver1.swipe(150,(driver1.findElementByXPath("//android.widget.LinearLayout[@index='0']/"
		//				+ "android.widget.RelativeLayout[@index='3']/android.widget.Spinner/"
		//				+ "android.widget.TextView")).getLocation().getY(), 150, (driver1.findElementById("license_plate")).getLocation().getY(), 6000);
		try{
			EnterText2(yearValue, Year);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		TapElement(colorDropDown);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		TapElement(makeValue);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

		TapElement(doneButton);
		WaitForElement(backBtn);

	}

	public ArrayList<String> ReadTruckInfo()
	{
		ArrayList<String> truckProfile= new ArrayList<String>();
		try {
			TapBackBtn();
			WaitForElement(moreTitle);
			((MobileElement) driver1.findElement(By.id("title_truck_profile"))).tap(1,1);
			WaitForElement(makeDropDown);
			truckProfile.add(ReadValue(makeDropDown));
			truckProfile.add(ReadValue(modelTextBox));
			truckProfile.add(ReadValue(licensePlateTextBox));
			truckProfile.add(ReadValue(equipmentTypeDropDown));
			driver1.scrollToExact("Black");
			//			driver1.swipe(150,((driver1.findElementByXPath("//android.widget.LinearLayout[@index='0']/"
			//					+ "android.widget.RelativeLayout[@index='3']/android.widget.Spinner/"
			//					+ "android.widget.TextView")).getLocation().getY()), 150, ((driver1.findElementById("model_other")).getLocation().getY()), 4000);		
			truckProfile.add(ReadValue(yearTextBox));
			truckProfile.add(ReadValue(colorNonEdit));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return truckProfile;

	}
}


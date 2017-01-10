package com.pack.screens.Tablet;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class TabletTruckInfomation extends DefaultGestures {

	private AppiumDriver driver1;

	private By backBtn=By.id("image_button_back");
	private By editBtn=By.id("image_button_edit");
	private By doneButton=By.id("imageButtonRegDone");
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
	private By closeBtn=By.id("ivClose");

	public TabletTruckInfomation(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}

	public void TapBackBtn()
	{
		TapElement(backBtn);
	}

	public void UpdateTruckInfo(String Model, String LicensePlateNumber, String Year)
	{
		Dimension size = driver1.manage().window().getSize();

		int startX=(int) (size.width*0.5);
		int startY=(int) (size.height*0.75);
		int endY=(int) (size.height*0.40);
		
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
			driver1.swipe(startX,startY,startX,endY, 2000);
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
		driver1.scrollToExact("Color");
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
		WebDriverWait wait=new WebDriverWait(driver1,50);
		try
		{
			wait.until(ExpectedConditions.invisibilityOfElementLocated(closeBtn));
		}
		catch (NoSuchElementException e)
		{
			System.out.println("done");
		}

	}

	public ArrayList<String> ReadTruckInfo()
	{
		Dimension size = driver1.manage().window().getSize();

		int startX=(int) (size.width*0.5);
		int startY=(int) (size.height*0.75);
		int endY=(int) (size.height*0.40);
		ArrayList<String> truckProfile= new ArrayList<String>();
		try {
			WaitForElement(makeDropDown);
			truckProfile.add(ReadValue(makeDropDown));
			truckProfile.add(ReadValue(modelTextBox));
			truckProfile.add(ReadValue(licensePlateTextBox));
			truckProfile.add(ReadValue(equipmentTypeDropDown));
			driver1.swipe(startX, startY, startX, endY, 2000);
			truckProfile.add(ReadValue(yearTextBox));
			truckProfile.add(ReadValue(colorNonEdit));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return truckProfile;

	}
}


package com.pack.screens.Android;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class AndroidProfileInformation extends DefaultGestures {

	private AppiumDriver driver1;

	private By backBtn=By.id("image_button_back");
	private By editBtn=By.id("image_button_edit");
	private By firstNameTxt=By.id("firstName");
	private By lastNameTxt=By.id("lastName");
	private By phoneNumberTxt=By.id("phoneNumber");
	private By cdlStateDropDowm=By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='3']/android.widget.Spinner/android.widget.TextView");
	private By cdlStateValue=By.xpath("//android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[@index='1']");
	private By genderDropDown=By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='4']/android.widget.Spinner/android.widget.TextView");
	private By genderValue=By.xpath("//android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[@index='1']");
	private By ONE20HandleTxt=By.id("truckHandle");
	private By employmentTypeDropDown=By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='7']/android.widget.Spinner/android.widget.TextView");
	private By employmentTypeValue=By.xpath("//android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[@index='2']");
	private By haulAreaDropDown=By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='9']/android.widget.Spinner/android.widget.TextView");
	private By shippingAddressLine1Txt=By.id("address_line_one");
	private By shippingAddressLine2Txt=By.id("address_line_two");
	private By cityTxt=By.id("city");
	private By stateDropDown=By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='13']/android.widget.Spinner/android.widget.TextView");
	private By zipCodeTxt=By.id("zip_code");
	private By doneButton=By.id("image_button_done");
	private By moreTitle=By.id("settings_partners");

	public AndroidProfileInformation(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}
	public void TapBackBtn()
	{
		TapElement(backBtn);
	}
	public void UpdateProfile(String FirstName, String LastName, String PhoneNumber, String CDLState, String Gender, String ONE20Handle, String EmploymentType, String HaulArea, String AddressLine1, String AddressLine2, String City, String State, String Zipcode)
	{
		TapElement(editBtn);
		EnterText(firstNameTxt, FirstName);

		EnterText(lastNameTxt, LastName);


		EnterText(phoneNumberTxt, PhoneNumber);




		TapElement(cdlStateDropDowm);
		driver1.scrollTo("Alabama");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TapElement(cdlStateValue);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TapElement(genderDropDown);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TapElement(genderValue);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EnterText(ONE20HandleTxt, ONE20Handle);

		TapElement(employmentTypeDropDown);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TapElement(employmentTypeValue);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TapElement(haulAreaDropDown);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TapElement(cdlStateValue);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EnterText(shippingAddressLine1Txt, AddressLine1);

		EnterText(shippingAddressLine2Txt, AddressLine2);

		EnterText(cityTxt, City);

		TapElement(stateDropDown);
		driver1.scrollTo("Alabama");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TapElement(cdlStateValue);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EnterText(zipCodeTxt, Zipcode);
			TapElement(doneButton);
			WaitForElement(backBtn);
	}
	public ArrayList<String> ReadProfile()
	{
		ArrayList<String> profileContent= new ArrayList<String>();
		try {
			TapBackBtn();
			WaitForElement(moreTitle);
			((MobileElement) driver1.findElement(By.id("title_profile_information"))).tap(1,1);
			WaitForElement(firstNameTxt);
			profileContent.add(ReadValue(firstNameTxt));
			profileContent.add(ReadValue(lastNameTxt));
			profileContent.add(ReadValue(phoneNumberTxt));
			profileContent.add(ReadValue(cdlStateDropDowm));
			driver1.swipe(150,driver1.scrollTo("CDL State").getLocation().getY(), 150, driver1.scrollTo("Profile Picture").getLocation().getY(), 3000);		
			System.out.println("Reading Gender");
			profileContent.add(ReadValue(genderDropDown));
			System.out.println("Reading ONE20 Handle");
			driver1.scrollToExact("ONE20 Handle");
			profileContent.add(ReadValue(ONE20HandleTxt));
			driver1.scrollToExact("Employment Type");
			profileContent.add(ReadValue(employmentTypeDropDown));
			driver1.scrollToExact("Haul Area");
			profileContent.add(ReadValue(haulAreaDropDown));
			driver1.scrollToExact("Address Line 1");
			profileContent.add(ReadValue(shippingAddressLine1Txt));
			driver1.scrollToExact("Address Line 2");
			profileContent.add(ReadValue(shippingAddressLine2Txt));
			driver1.scrollToExact("City");
			profileContent.add(ReadValue(cityTxt));
			driver1.scrollToExact("State");
			profileContent.add(ReadValue(stateDropDown));
			driver1.scrollToExact("Zip Code");
			profileContent.add(ReadValue(zipCodeTxt));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return profileContent;

	}
}

package com.pack.screens.Tablet;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;


public class TabletProfileInformation extends DefaultGestures {

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
	private By haulAreaDropDown=By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='8']/android.widget.Spinner/android.widget.TextView");
	private By shippingAddressLine1Txt=By.id("address_line_one");
	private By shippingAddressLine2Txt=By.id("address_line_two");
	private By cityTxt=By.id("city");
	private By stateDropDown=By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='12']/android.widget.Spinner/android.widget.TextView");
	private By zipCodeTxt=By.id("zip_code");
	private By doneButton=By.id("imageButtonRegDone");
	private By closeBtn=By.id("ivClose");

	
	public TabletProfileInformation(AppiumDriver driver, AppiumDriver driver1) {
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
	public ArrayList<String> ReadProfile()
	{
		ArrayList<String> profileContent= new ArrayList<String>();
		try 
		{
			Dimension size = driver1.manage().window().getSize();

			int startX=(int) (size.width*0.5);
			int startY=(int) (size.height*0.75);
			int endY=(int) (size.height*0.40);
			
			WaitForElement(firstNameTxt);
			profileContent.add(ReadValue(firstNameTxt));
			profileContent.add(ReadValue(lastNameTxt));
			profileContent.add(ReadValue(phoneNumberTxt));
			profileContent.add(ReadValue(cdlStateDropDowm));
			//driver1.swipe(150,driver1.scrollTo("CDL State").getLocation().getY(), 150, driver1.scrollTo("Profile Picture").getLocation().getY(), 3000);		
			System.out.println("Reading Gender");
			driver1.swipe(startX,startY,startX,endY, 2000);
			profileContent.add(ReadValue(genderDropDown));
			System.out.println("Reading ONE20 Handle");
			driver1.scrollToExact("ONE20 Handle");
			profileContent.add(ReadValue(ONE20HandleTxt));
			driver1.swipe(startX,startY,startX,endY, 2000);
			profileContent.add(ReadValue(employmentTypeDropDown));
			driver1.swipe(startX,startY,startX,endY, 2000);
			profileContent.add(ReadValue(haulAreaDropDown));
			driver1.swipe(startX,startY,startX,endY, 2000);
			profileContent.add(ReadValue(shippingAddressLine1Txt));
			driver1.swipe(startX,startY,startX,endY, 2000);
			profileContent.add(ReadValue(shippingAddressLine2Txt));
			driver1.swipe(startX,startY,startX,endY, 2000);
			profileContent.add(ReadValue(cityTxt));
			driver1.swipe(startX,startY,startX,endY, 2000);
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

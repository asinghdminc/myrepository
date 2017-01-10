package com.pack.screens.iOS;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;


public class IOSProfileInformation extends DefaultGestures {
	private AppiumDriver driver1;


	private By backBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By editBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	private By firstNameTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]");
	private By lastNameTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
	private By phoneNumberTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]");
	private By cdlStateSpinner=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[2]");
	private By cdlStatePicker=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAPicker[1]/UIAPickerWheel[1]");
	private By genderSpinner=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[2]");
	private By genderPicker=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIAPicker[1]/UIAPickerWheel[1]");
	private By ONE20HandleTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIATextField[1]");
	private By employmentTypeSpinner=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[8]/UIAStaticText[2]");
	private By employmentTypeValue=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
	private By haulAreaSpinner=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[9]/UIAStaticText[2]");
	private By haulAreaValue=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
	private By shippingAddressLine1Txt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[10]/UIATextField[1]");
	private By shippingAddressLine2Txt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[11]/UIATextField[1]");
	private By cityTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[12]/UIATextField[1]");
	private By stateSpinner=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[13]/UIAStaticText[2]");
	private By stateSpinnerValue=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[14]/UIAPicker[1]/UIAPickerWheel[1]");
	private By zipCodeTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[14]/UIATextField[1]");
	private By doneButton=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");



	public IOSProfileInformation(AppiumDriver driver, AppiumDriver driver1) {
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
		TapElement(cdlStateSpinner);
		SelectSpinner(cdlStatePicker, CDLState);
		TapElement(genderSpinner);
		SelectSpinner(genderPicker, Gender);
		EnterText(ONE20HandleTxt, ONE20Handle);
		TapElement(employmentTypeSpinner);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TapElement(employmentTypeValue);
		TapElement(doneButton);
		TapElement(haulAreaSpinner);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TapElement(haulAreaValue);
		TapElement(doneButton);
		EnterText(shippingAddressLine1Txt,AddressLine1);
		EnterText(shippingAddressLine2Txt,AddressLine2);
		EnterText(cityTxt,City);
		TapElement(stateSpinner);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SelectSpinner(stateSpinnerValue, State);
		EnterText(zipCodeTxt, Zipcode);
		TapElement(editBtn);

	}

	public ArrayList<String> ReadProfile()
	{
		ArrayList<String> profileContent= new ArrayList<String>();
		try{
			profileContent.add(ReadValue(firstNameTxt));
			profileContent.add(ReadValue(lastNameTxt));
			profileContent.add(ReadValue(phoneNumberTxt));
			profileContent.add(ReadValue(cdlStateSpinner));
			profileContent.add(ReadValue(genderSpinner));
			profileContent.add(ReadValue(ONE20HandleTxt));
			profileContent.add(ReadValue(employmentTypeSpinner));
			profileContent.add(ReadValue(haulAreaSpinner));
			profileContent.add(ReadValue(shippingAddressLine1Txt));
			profileContent.add(ReadValue(shippingAddressLine2Txt));
			profileContent.add(ReadValue(cityTxt));
			profileContent.add(ReadValue(stateSpinner));
			profileContent.add(ReadValue(zipCodeTxt));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return profileContent;

	} 

}

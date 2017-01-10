package com.pack.screens.iOS;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class IOSTruckInformation extends DefaultGestures {
	private AppiumDriver driver1;

	private By backBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By editBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	private By doneButton=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	private By makeDropDown=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]");
	private By makeValue=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
	private By modelTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
	private By licensePlateTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]");
	private By equipmentTypeDropDown=By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[2]");
	private By yearTextBox=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[2]");
	private By yearValue=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[6]/UIAPicker[1]/UIAPickerWheel[1]");
	private By colorDropDown=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[6]/UIAStaticText[2]");
	

	public IOSTruckInformation(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}

	public void TapBackBtn()
	{
		TapElement(backBtn);
	}

	public void UpdateTruckInfo(String Make, String Model, String LicensePlateNumber, String EquipmentType, String Year, String Color)
	{
		TapElement(editBtn);

		TapElement(makeDropDown);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TapElement(makeValue);
		TapElement(doneButton);
		
		EnterText(modelTextBox, Model);
		EnterText(licensePlateTextBox, LicensePlateNumber);

		TapElement(equipmentTypeDropDown);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TapElement(makeValue);
		TapElement(doneButton);

		TapElement(yearTextBox);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		try{
		SelectSpinner(yearValue, Year);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		TapElement(colorDropDown);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		TapElement(makeValue);
		TapElement(doneButton);
		
		try{
			TapElement(doneButton);
			Thread.sleep(5000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public ArrayList<String> ReadTruckInfo()
	{
		ArrayList<String> truckProfile= new ArrayList<String>();
		try {
			truckProfile.add(ReadValue(makeDropDown));
			truckProfile.add(ReadValue(modelTextBox));
			truckProfile.add(ReadValue(licensePlateTextBox));
			truckProfile.add(ReadValue(equipmentTypeDropDown));
			truckProfile.add(ReadValue(yearTextBox));
			truckProfile.add(ReadValue(colorDropDown));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return truckProfile;

	}
}

package com.pack.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class DefaultGestures {

	private AppiumDriver driver1;
	private WebDriverWait wait;
	private TestBaseSetup testBaseSetup=new TestBaseSetup();


	public DefaultGestures(AppiumDriver driver) {
		super();
		this.driver1 = driver;
	}

	//To Tap an Element
	public void TapElement(By screenElement)
	{

		MobileElement element=(MobileElement)driver1.findElement(screenElement);
		element.tap(1, 1);

	}
	//To enter text in search box
	public void  EnterText3(By txtbox, String txt)
	{

		MobileElement element=(MobileElement)driver1.findElement(txtbox);
		if (testBaseSetup.flag.equalsIgnoreCase("android")||testBaseSetup.flag.equalsIgnoreCase("tablet"))
		{
			element.tap(1, 1);
			element.sendKeys(txt);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver1.sendKeyEvent(67);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			//			TouchAction touchAction=new TouchAction(driver1);
			//			touchAction.perform().tap(element);
			element.tap(1, 1);
			driver1.getKeyboard().sendKeys(txt);
		}
		//driver1.hideKeyboard();
	}
	//To enter text in calendar
	public void  EnterText2(By txtbox, String txt)
	{

		MobileElement element=(MobileElement)driver1.findElement(txtbox);
		//				element.tap(1, 1);
		element.setValue(txt);
		driver1.hideKeyboard();
	}
	//To enter text in a textbox
	public void  EnterText(By txtbox, String txt)
	{

		MobileElement element=(MobileElement)driver1.findElement(txtbox);
		if (testBaseSetup.flag.equalsIgnoreCase("android")||testBaseSetup.flag.equalsIgnoreCase("tablet"))
		{
			element.tap(1, 1);
			element.clear();
			do
			{

				element.clear();

			}
			while(!element.getText().isEmpty());
			driver1.getKeyboard().sendKeys(txt);
//			element.sendKeys(txt);
			driver1.hideKeyboard();

		}
		else
		{
			element.tap(1, 1);
			element.clear();
			driver1.getKeyboard().sendKeys(txt);
			//element.setValue(txt);
		}

	}
	//To capture screenshot	
	public void takeScreenShot() {
		String destDir = "screenshots";

		File scrFile = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

		new File(destDir).mkdirs();

		String destFile = dateFormat.format(new Date()) + ".png";

		try {

			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//To read poi information
	public String ReadPOIInfo(By screenElement)
	{
		String content;
		AndroidElement element=(AndroidElement)driver1.findElement(screenElement);
		content=element.getText().toString();
		return content;
	}

	//To read contents of an element
	public String ReadValue(By screenElement)
	{
		String content;
		MobileElement element=(MobileElement)driver1.findElement(screenElement);
		if (testBaseSetup.flag.equalsIgnoreCase("android")||testBaseSetup.flag.equalsIgnoreCase("tablet"))
			content=element.getText().toString();
		else
			content=element.getText().toString();
		return content;
	}
	//To verify element displayed
	public boolean VerifyElementDisplayed(By screenElement)
	{
		MobileElement element=(MobileElement)driver1.findElement(screenElement);
		if (element.isDisplayed()==true)
		{
			System.out.println("In If Wait");
			return true;
		}
		else
		{
			System.out.println("In Else Wait");
			return false;
		}
	}
	//To wait for an element
	public void WaitForElement(By screenElement)
	{
		wait=new WebDriverWait(driver1, 15);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(screenElement));
		}
		catch(Exception e)
		{
		}
	}
	//To select a value in ios spinner
	public void SelectSpinner(By screenElement, String text)
	{
		MobileElement element=(MobileElement)driver1.findElement(screenElement);
		element.setValue(text);
	}
}

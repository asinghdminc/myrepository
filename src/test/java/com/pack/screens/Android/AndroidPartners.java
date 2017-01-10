package com.pack.screens.Android;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class AndroidPartners extends DefaultGestures {

	private AppiumDriver driver1;
	private By backBtn=By.id("img_back_button");
	//private By loveTravelStop=By.id("tv_partner_header");
	//private By pilotFlyingJ=By.xpath("//*android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[0]");
	//private By taPetro=By.xpath("//*android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[0]");
	
	public AndroidPartners(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}

	public void TabBackBtn()
	{
		TapElement(backBtn);
	}
	public ArrayList<String> ReadPartnerApps()
	{
		List<WebElement> element= driver1.findElementsById("tv_partner_header");
		ArrayList<String> partnerapps=new ArrayList<String>();
		System.out.println(element.get(0).getText());
		partnerapps.add(element.get(0).getText());
		partnerapps.add(element.get(1).getText());
		partnerapps.add(element.get(2).getText());
		return partnerapps;
	}
}


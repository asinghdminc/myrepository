package com.pack.screens.Android;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import net.thucydides.core.annotations.Step;

public class AndroidPlanMapView extends DefaultGestures {

	private By searchTxtbox=By.id("com.one20.ota:id/autocomplete_places");
	private By searchBox=By.id("et_search_box");
	private By listViewBtn=By.id("selector");
	private By mapLayerBtn=By.id("iv_layer_btn");
	private By bullsEyeBtn=By.id("iv_gps_btn");
	private By planScreenMap=By.id("ll_home");
	private By searchResult=By.id("tv_suggesstions_below");
	private By navigateBtn=By.id("buttonNavigate");
	private By poiIcon=By.xpath("//android.view.View[@index='45']");
	private By moreInfoBtn=By.id("btnNavigate");
	private By firstPOI=By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@resource-id='com.one20.ota:id/poiTitle']");
	public AndroidPlanMapView(AppiumDriver driver) {
		super(driver);
	}

	public void SearchPOI (String searchtxt)
	{
		WaitForElement(searchBox);
		TapElement(searchBox);
		System.out.println(searchtxt);
		EnterText3(searchTxtbox, searchtxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Step
	public void OpenSearchedPOI()
	{
		TapElement(searchResult);
		WaitForElement(navigateBtn);
	}
	@Step
	public void OpenListView()
	{
		TapElement(listViewBtn);
	}
	@Step
	public void OpenMapLayer()
	{
		TapElement(mapLayerBtn);
	}
	@Step
	public void TapBullsEye()
	{
		TapElement(bullsEyeBtn);
	}
	@Step
	public String VerifyPlanScreen()
	{
		String flag;
		WaitForElement(planScreenMap);
		if (VerifyElementDisplayed(planScreenMap)==true)
		{
			flag="Element Displayed";
		}
		else
		{
			flag="Element not displaed";
		}
		return flag;
	}
	@Step
	public void openPOI2Miles()
	{
		TapElement(listViewBtn);
		WaitForElement(firstPOI);
		TapElement(firstPOI);
	}
	@Step
	public void openPOI()
	{
		WaitForElement(poiIcon);
		TapElement(poiIcon);
		WaitForElement(moreInfoBtn);
		TapElement(moreInfoBtn);
	}
}

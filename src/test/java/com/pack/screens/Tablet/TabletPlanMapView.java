package com.pack.screens.Tablet;

import org.openqa.selenium.By;
import com.pack.base.*;
import io.appium.java_client.AppiumDriver;

public class TabletPlanMapView extends DefaultGestures {

	private By searchTxtbox=By.id("com.one20.ota:id/autocomplete_places");
	private By searchBox=By.id("autocomplete_places");
	private By listViewBtn=By.id("selector_list");
	private By mapLayerBtn=By.id("iv_layer_btn");
	private By bullsEyeBtn=By.id("iv_gps_btn");
	private By planScreenMap=By.id("ll_home");
	private By searchResult=By.id("tv_suggesstions_below");
	private By navigateBtn=By.id("buttonNavigate");
	private By poiIcon=By.xpath("//android.view.View[@index='104']");
	private By firstPOI=By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@resource-id='com.one20.ota:id/poiTitle']");

	public TabletPlanMapView(AppiumDriver driver) {
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
	public void OpenSearchedPOI()
	{
		TapElement(searchResult);
		WaitForElement(navigateBtn);
	}

	public void OpenListView()
	{
		TapElement(listViewBtn);
	}
	public void OpenMapLayer()
	{
		TapElement(mapLayerBtn);
	}
	public void TapBullsEye()
	{
		TapElement(bullsEyeBtn);
	}
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

	public void openPOI() {
		WaitForElement(poiIcon);
		TapElement(poiIcon);
		TapElement(poiIcon);
	}

	public void openPOI2Miles()
	{
		WaitForElement(listViewBtn);
		TapElement(listViewBtn);
		WaitForElement(firstPOI);
		TapElement(firstPOI);
	}
}

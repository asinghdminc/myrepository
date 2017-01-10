package com.pack.screens.iOS;

import org.openqa.selenium.By;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;

public class IOSPlanMapView extends DefaultGestures {

	private By searchTxt=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASearchBar[1]");
	private By searchResult=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	private By listViewBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By mapLayerBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[5]");
	private By bullsEyeBtn=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]");
	private By planScreenMap=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]");
	//private By allowBtn=By.xpath("//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]");
	//private By poiIcon=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	private By poiIcon=By.className("UIATableCell");
	//private By moreInfoBtn=By.id("btnNavigate");
	private By firstPOI=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");


	public IOSPlanMapView(AppiumDriver driver) {
		super(driver);
	}

	public void SearchPOI (String searchtxt)
	{
		EnterText3(searchTxt, searchtxt);
	}
	public void OpenSearchedPOI()
	{
		TapElement(searchResult);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		String flag=null;
		System.out.println("In Verify Plan");
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
		//WaitForElement(listViewBtn);
		TapElement(listViewBtn);
		WaitForElement(poiIcon);
		TapElement(poiIcon);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void openPOI2Miles() {
		TapElement(listViewBtn);
		TapElement(firstPOI);
	}

}
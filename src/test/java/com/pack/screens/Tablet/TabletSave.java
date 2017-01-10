package com.pack.screens.Tablet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;


public class TabletSave extends DefaultGestures {

	private By backBtn= By.id("imageButtonDealsBack");
	private By fiterLink=By.id("tvFilter");
	private By sortDropdown=By.id("selectedSortLayout");
	private By startDateSort=By.id("recentlyAddedSort");
	private By endDateSort=By.id("aboutToExpireSort");
	private By applyButton=By.id("btnApply");
	private By filterOption=By.xpath("//android.widget.RelativeLayout[@index='5']/android.widget.RelativeLayout[@index='0']/android.widget.CheckBox[@resource-id='com.one20.ota:id/checkBoxFilterOption']");
	private By filterCountText=By.id("tvDealsCount");
	
	private DateFormat df=new SimpleDateFormat("MMM dd");
	private Date startDate;

	int count=0;
	
	private AppiumDriver driver1;
	private Date endDate;

	public TabletSave(AppiumDriver driver, AppiumDriver driver1) {
		super(driver);
		this.driver1 = driver1;
	}
	
	public void sortByStartDate()
	{
		WaitForElement(fiterLink);
		TapElement(fiterLink);
		TapElement(sortDropdown);
		TapElement(startDateSort);
		TapElement(applyButton);
	}
	public void sortByEndDate()
	{
		WaitForElement(fiterLink);
		TapElement(fiterLink);
		TapElement(sortDropdown);
		TapElement(endDateSort);
		TapElement(applyButton);
	}
	public void verifySortedByStartDate()
	{
		Dimension size=driver1.manage().window().getSize();
		int startx=(int)(size.getWidth()*0.5);
		int starty=(int)(size.getHeight()*0.7);
		int endy=(int)(size.getHeight()*0.3);
		int flag=0;
		int startyException=(int)(size.getHeight()*0.35);
		
		ArrayList<Date> dateList=new ArrayList<Date>();
		ArrayList<Date> dateListPreSort=new ArrayList<Date>();

		ArrayList<String> allDeals=new ArrayList<String>();

		Set<String> set=new LinkedHashSet<String>();
		
		try
		{
			driver1 .swipe(startx, starty, startx, endy, 2000);
		}
		catch (Exception e)
		{
			driver1.swipe(startx, startyException, startx, endy, 2000);
		}
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<6;j++)
			{
				try
				{
					String poiName=driver1.findElement(By.xpath("//android.widget.GridView[@resource-id='com.one20.ota:id/offersListView_grid_view']/"
							+ "android.widget.LinearLayout[@index='"+j+"']/"
							+ "android.widget.RelativeLayout[@index='0']/"
							+ "android.widget.TextView[@resource-id='com.one20.ota:id/offerDate']")).getText();
					allDeals.add(poiName);
				}
				catch(Exception e)
				{
		
				}
			}
			try
			{
				driver1.swipe(startx, starty, startx, endy, 2000);
			}
			catch(Exception e)
			{
				driver1.swipe(startx, startyException, startx, endy, 2000);
			}
		}
		for(int i=0;i<allDeals.size();i++)
		{
			set.add(allDeals.get(i));
		}
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext())
		{
			String date=iterator.next();
			String [] parts=date.split(" - ");
			String start_date=parts[0];
			try
			{
				startDate=df.parse(start_date);
				dateList.add(startDate);
			}
			catch(Exception e)
			{

			}
		}
		for(int i=0;i<dateList.size();i++)
		{
			dateListPreSort.add(dateList.get(i));
		}
		Collections.sort(dateList);
		Collections.reverse(dateList);
		for(int i=0;i<dateList.size();i++)
		{
			System.out.println(dateList.get(i).toString());
			if (dateList.get(i).equals(dateListPreSort.get(i)))
			{
				flag=1;
			}
			else
			{
				flag=0;
			}
		}
		try
		{
			Assert.assertEquals(1, flag);
		}
		catch(Exception e)
		{
			takeScreenShot();
			Assert.fail("Not Sorted by Start Date");
		}
		finally
		{
			driver1.scrollToExact("Featured Deals");
		}
	}
	public void verifySortedByEndDate()
	{
		Dimension size=driver1.manage().window().getSize();
		int startx=(int)(size.getWidth()*0.5);
		int starty=(int)(size.getHeight()*0.7);
		int endy=(int)(size.getHeight()*0.3);
		int flag=0;
		int startyException=(int)(size.getHeight()*0.35);
		
		ArrayList<Date> dateList=new ArrayList<Date>();
		ArrayList<Date> dateListPreSort=new ArrayList<Date>();

		ArrayList<String> allDeals=new ArrayList<String>();

		Set<String> set=new LinkedHashSet<String>();
		
		try
		{
			driver1 .swipe(startx, starty, startx, endy, 2000);
		}
		catch (Exception e)
		{
			driver1.swipe(startx, startyException, startx, endy, 2000);
		}
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<6;j++)
			{
				try
				{
					String poiName=driver1.findElement(By.xpath("//android.widget.GridView[@resource-id='com.one20.ota:id/offersListView_grid_view']/"
							+ "android.widget.LinearLayout[@index='"+j+"']/"
							+ "android.widget.RelativeLayout[@index='0']/"
							+ "android.widget.TextView[@resource-id='com.one20.ota:id/offerDate']")).getText();
					allDeals.add(poiName);
				}
				catch(Exception e)
				{
				}
			}
			try
			{
				driver1.swipe(startx, starty, startx, endy, 2000);
			}
			catch(Exception e)
			{
				driver1.swipe(startx, startyException, startx, endy, 2000);
			}
		}
		for(int i=0;i<allDeals.size();i++)
		{
			set.add(allDeals.get(i));
		}
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext())
		{
			String date=iterator.next();
			String [] parts=date.split(" - ");
			String end_date=parts[1];
			try
			{
				endDate=df.parse(end_date);
				dateList.add(endDate);
			}
			catch(Exception e)
			{

			}
		}
		for(int i=0;i<dateList.size();i++)
		{
			dateListPreSort.add(dateList.get(i));
		}
		Collections.sort(dateList);
		for(int i=0;i<dateList.size();i++)
		{
			System.out.println(dateList.get(i).toString());
			if (dateList.get(i).equals(dateListPreSort.get(i)))
			{
				flag=1;
			}
			else
			{
				flag=0;
			}
		}
		try
		{
			Assert.assertEquals(1, flag);
		}
		catch(Exception e)
		{
			takeScreenShot();
			Assert.fail("Not Sorted by End Date");
		}
	}

	public void filterDeals() {
		TapElement(fiterLink);
		WaitForElement(filterOption);
		TapElement(filterOption);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count=Integer.parseInt(ReadValue(filterCountText));
		TapElement(applyButton);
		
	}

	public void verifyFiltered() {
		List<WebElement> deals=driver1.findElements(By.id("offerBody"));
		System.out.println(count);
		System.out.println(deals.size());
		
		try
		{
			Assert.assertEquals(count, deals.size());
		}
		catch(Exception e)
		{
			takeScreenShot();
			Assert.fail();
		}
		finally
		{
			driver1.resetApp();
		}
		
	}
}

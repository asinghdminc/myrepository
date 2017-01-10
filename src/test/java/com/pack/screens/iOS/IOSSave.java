package com.pack.screens.iOS;

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
import org.openqa.selenium.WebElement;

import com.pack.base.DefaultGestures;

import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;


public class IOSSave extends DefaultGestures {

	private By fiterLink=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	private By sortDropdown=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
	private By startDateSort=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
	private By endDateSort=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]");
	private By applyButton=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	private By filterOption=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[9]");
	private By filterCountText=By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");

	private DateFormat df=new SimpleDateFormat("MMM dd");
	private Date startDate;
	private Date endDate;

	int count=0;
	private AppiumDriver driver1;


	public IOSSave(AppiumDriver driver, AppiumDriver driver1) {
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
		ArrayList<Date> dateList=new ArrayList<Date>();
		ArrayList<Date> dateListPreSort=new ArrayList<Date>();

		ArrayList<String> allDeals=new ArrayList<String>();

		Set<String> set=new LinkedHashSet<String>();
		int flag=0;
		for(int j=4;j<12;j++)
		{
			String poiName= null;
			try
			{
				poiName=driver1.findElement(By.xpath("//UIAApplication[1]/"
						+ "UIAWindow[1]/"
						+ "UIATableView[1]/"
						+ "UIATableCell["+j+"]/"
						+ "UIAStaticText[3]")).getText();
				allDeals.add(poiName);
			}
			catch(Exception e)
			{
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
			driver1.resetApp();
		}
	}
	public void verifySortedByEndDate()
	{
		ArrayList<Date> dateList=new ArrayList<Date>();
		ArrayList<Date> dateListPreSort=new ArrayList<Date>();

		ArrayList<String> allDeals=new ArrayList<String>();

		Set<String> set=new LinkedHashSet<String>();
		String poiName=null;
		int flag=0;

		for(int j=4;j<12;j++)
		{
			try
			{
				poiName=driver1.findElement(By.xpath("//UIAApplication[1]/"
						+ "UIAWindow[1]/"
						+ "UIATableView[1]/"
						+ "UIATableCell["+j+"]/"
						+ "UIAStaticText[3]")).getText();
				allDeals.add(poiName);
			}
			catch(Exception e)
			{
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
			String end_date=parts[0];
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
		finally
		{
			driver1.resetApp();
		}
	}
	public void filterDeals()
	{
		TapElement(fiterLink);
		TapElement(filterOption);
		String parts[]=ReadValue(filterCountText).split(" ");
		count=Integer.parseInt(parts[0]);
		TapElement(applyButton);
	}
	public void verifyFiltered()
	{
		List <WebElement> deals=driver1.findElements(By.className("UIATableCell"));
		System.out.println(count);
		System.out.println(deals.size());
		try
		{
			Assert.assertEquals(count, deals.size());
		}
		catch(Exception e)
		{
			takeScreenShot();
			Assert.fail("Not Filtered");
		}
	}
}

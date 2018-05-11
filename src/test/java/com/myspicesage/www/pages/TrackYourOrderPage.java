package com.myspicesage.www.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackYourOrderPage {

	@FindBy (id="order") private WebElement uiTrackYourOrderPg_OrderTb;
	@FindBy (id="email") private WebElement uiTrackYourOrderPg_EmailIdTb;
	@FindBy (id="tracking_submit") private WebElement uiTrackYourOrderPg_TrackBtn;
	@FindBy (xpath="//div[@class='contacts-content order-tracking']") private List<WebElement> uiTrackYourOrderPg_ErrorMsg;
	
	public void trackOrderWithoutSignIn()
	{
		//Order Number
		uiTrackYourOrderPg_OrderTb.clear();
		uiTrackYourOrderPg_OrderTb.sendKeys("19847nda");
		
		//Email ID
		uiTrackYourOrderPg_EmailIdTb.clear();
		uiTrackYourOrderPg_EmailIdTb.sendKeys("abcd@def.com");
		
		//Click on Track button
		uiTrackYourOrderPg_TrackBtn.click();
		
	}
	
	public void verifyTrackOrderErrorMessage()
	{
		Assert.assertTrue("Fail, Expected Error message is not displayed",uiTrackYourOrderPg_ErrorMsg.size()>0);
		System.out.println("Pass, Expected Error message is displayed");	
	}
	
	public void verifyTrackOrderDetailsDisplayed()
	{
		Assert.assertTrue("Fail, Order details are not displayed",uiTrackYourOrderPg_ErrorMsg.size()==0);
		System.out.println("Pass, Order details are displayed");	
	}
	
	public void trackOrderWithSignIn()
	{
		//Order Number
		uiTrackYourOrderPg_OrderTb.clear();
		uiTrackYourOrderPg_OrderTb.sendKeys("19847nda");
		
		//Click on Track button
		uiTrackYourOrderPg_TrackBtn.click();
	}
	
	
}

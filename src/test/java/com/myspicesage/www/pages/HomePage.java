package com.myspicesage.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	/*
	oBrowser.findElement(By					//@FindBy
	
	oBrowser.findElement(By.id("lluserid"))	//@FindBy(id="lluserid")

	private WebElement uiUsernameTxBx = oBrowser.findElement(By.id("lluserid"));	//@FindBy(id="lluserid") private WebElement uiUsernameTxBx;
	
	public String uiHomePage_TrackOrder_lnk = "Track Order";
	public String uiHomePage_MyCart_xp = "//a[contains(@href,'cart')]";
	public String uiHomePage_SpicesSeasoningsHerbsTab_xp = "//a[contains(@href='spices-seasonings-herbs.html')]";
	public String uiHomePage_SearchSpice_id = "sli_search_1";
	public String uiHomePage_SearchBtn_id = "//button[contains(.,'search')]";
	public String uiHomePage_nOfCartItems_xp = "//span[@class='fa fa-shopping-cart']/following-sibling::span";
	
	*/
	
	@FindBy(linkText="Track Order") private WebElement uiHomePage_TrackOrder_lnk;
	@FindBy(xpath="//a[contains(@href,'cart')]") private WebElement uiHomePage_MyCart_xp;
	@FindBy(xpath="//ul[@id='simplenav']/li/a[contains(@href,'spices-seasonings-herbs.html')]") private WebElement uiHomePage_SpicesSeasoningsHerbsTab_xp;
	@FindBy(id="sli_search_1") private WebElement uiHomePage_SearchSpice_id;
	@FindBy(xpath="//button[contains(.,'search')]") private WebElement uiHomePage_SearchBtn_id;
	@FindBy(xpath="//div[@id='mini-cart']//p/span[@class='fa fa-shopping-cart']/following-sibling::span") private WebElement uiHomePage_nOfCartItems_xp;
	
	public void searchSpicesAndSeasonings()
	{
		uiHomePage_SearchSpice_id.sendKeys("Chile");
		//oBrowser.findElement(By.id(uiHomePage_SearchSpice_id)).sendKeys("Chile");
		uiHomePage_SearchBtn_id.click();
	}
	
	public void clickTrackOrder()
	{
		uiHomePage_TrackOrder_lnk.click();
	}
	
	public void clickSpicesSeasoningsHerbsTab()
	{
		uiHomePage_SpicesSeasoningsHerbsTab_xp.click();
	}
	
	public void clickOnCart()
	{
		uiHomePage_MyCart_xp.click();
	}

	public int findCartValue()
	{
		String sCartItems = uiHomePage_nOfCartItems_xp.getText().trim();	//(69)
		if(sCartItems.contains(""))
		{
			return 0;
		}
		else
		{
			sCartItems = sCartItems.replaceAll("\\(", "");
			sCartItems = sCartItems.replaceAll("\\)", "");
			
			return Integer.parseInt(sCartItems);
		}
	}

	
	
}

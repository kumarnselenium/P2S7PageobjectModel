package com.myspicesage.www.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SSHPage {

	@FindBy(xpath="//input[contains(@onclick,'whole-spices')]") private WebElement uiSSHPage_WholeSpices;
	@FindBy(xpath="//input[contains(@onclick,'ground-spices')]") private WebElement uiSSHPage_GroundSpices;
	@FindBy(name="super_attribute[182]") private WebElement uiSSHPage_1stItemSelectSize;
	@FindBy(xpath="//button[@title='Add to Cart']") private WebElement uiSSHPage_AddToCart;
	@FindBy(xpath="//input[@type='checkbox']/following-sibling::a[contains(@onclick,'ground-spices')]") private WebElement uiSSHPage_NOfItems;
	@FindBy(xpath="//a[contains(@onclick,'ground-spices')]") private WebElement uiSSHPage_NOfItems1;
	@FindBy(xpath="//label[contains(.,'# items')]/following-sibling::select") private WebElement uiSSHPage_NOfItemsToDisplayOnScreen;
	@FindBy(xpath="//button[@title='Add to Cart']") private List<WebElement> uiSSHPage_TotalAddToCart;
	
	public void addItemtoCart() throws InterruptedException
	{
		Thread.sleep(3000);
		
		//Select Whole Spices Category
		if(!uiSSHPage_WholeSpices.isSelected())
			uiSSHPage_WholeSpices.click();
		
		Thread.sleep(5000);
		
		//1st Item - Select Size
		Select uiSize = new Select(uiSSHPage_1stItemSelectSize);
		if(uiSize.getOptions().size()>1)
		{
			uiSize.selectByIndex(1);
		}
		
		//Click on Add to Cart
		uiSSHPage_AddToCart.click();
	}

	public int findCategeoryNumberOfItems() throws InterruptedException
	{
		Thread.sleep(3000);
		//String sCategoryItems = uiSSHPage_NOfItems.getText().trim().replaceAll("(", "").replaceAll(")","");
		String sCategoryItems = uiSSHPage_NOfItems.getText().trim();	//Ground Spices (69)
		int iStartChar = sCategoryItems.indexOf("(");	// position of (
		
		sCategoryItems = sCategoryItems.substring(iStartChar); //(69)
		
		sCategoryItems = sCategoryItems.replaceAll("\\(", "");
		sCategoryItems = sCategoryItems.replaceAll("\\)", "");
		
		return Integer.parseInt(sCategoryItems);
		
	}
	
	public void validateNofItemsDispalyed() throws InterruptedException
	{
		//Find out number of Ground Spices against its checkbox
		int iExpectedItems = findCategeoryNumberOfItems();
		
		//Select Ground Spices Category
		if(!uiSSHPage_GroundSpices.isSelected())
			uiSSHPage_GroundSpices.click();
		
		Thread.sleep(5000);
		
		//Select maximum number under items to be displayed
		Select uiItemsView = new Select(uiSSHPage_NOfItemsToDisplayOnScreen);
		uiItemsView.selectByIndex(uiItemsView.getOptions().size()-1);
		
		Thread.sleep(3000);
	
		//Find out Total Items displayed
		int iActualItems = uiSSHPage_TotalAddToCart.size();
		
		//Compare iExpectedItems & iActualItems
		Assert.assertTrue("Fail, Expected Number of Items are not matching with Actual", iExpectedItems==iActualItems);
		System.out.println("Pass, Expected Number of Items are matching with Actual");
		//Assert.assertTrue("", uiSSHPage_TotalItems.size()==findCategeoryNumberOfItems());
			
	}
}

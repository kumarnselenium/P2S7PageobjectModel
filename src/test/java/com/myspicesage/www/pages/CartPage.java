package com.myspicesage.www.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

	@FindBy (className="side-cart-close") private WebElement uiCartPage_CloseBtn;
	
	
	public void clickClose()
	{
		uiCartPage_CloseBtn.click();
	}
}

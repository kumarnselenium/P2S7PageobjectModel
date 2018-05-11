package com.myspicesage.www.E2EScenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.myspicesage.www.pages.CartPage;
import com.myspicesage.www.pages.HomePage;
import com.myspicesage.www.pages.SSHPage;

import junit.framework.Assert;

public class TS3_VerifyCartFunctionality {
WebDriver oBrowser;
	
	@Before
	public void openApplication()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/amulyavallamkonda/Documents/Selenium/chromedriver");
		oBrowser = new ChromeDriver();		
		oBrowser.get("https://www.myspicesage.com/");		
		oBrowser.manage().window().maximize();
	}
	
	@Test
	public void validateNOfItems() throws InterruptedException
	{
		HomePage oHomePg = PageFactory.initElements(oBrowser, HomePage.class);
		SSHPage oSSHPg = PageFactory.initElements(oBrowser, SSHPage.class);
		CartPage oCartPg = PageFactory.initElements(oBrowser, CartPage.class);
		
		//before adding an Item to cart - find out the cart value
		int iCartCntBeforeAddToCart = oHomePg.findCartValue();
		
		//Click on SSH tab
		oHomePg.clickSpicesSeasoningsHerbsTab();
		
		//Add an Item to Cart
		oSSHPg.addItemtoCart();
		
		//Close Cart page/section
		oCartPg.clickClose();
		
		//after adding an Item to cart - find out the cart value
		int iCartCntAfterAddToCart = oHomePg.findCartValue();
		
		Assert.assertTrue("Fail, Cart functionality is not working", iCartCntAfterAddToCart>iCartCntBeforeAddToCart);
		System.out.println("Pass, Cart functionality is working as expected");
		
	}
	
	@After
	public void closeApplication()
	{
		//oBrowser.quit();
	}
}

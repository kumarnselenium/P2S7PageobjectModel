package com.myspicesage.www.E2EScenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.myspicesage.www.pages.HomePage;
import com.myspicesage.www.pages.TrackYourOrderPage;

public class TS1_NegativeTrackYourOrder {

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
	public void neagtiveTrackOrder()
	{
		//HomePage oHomePg = new HomePage();
		//TrackYourOrderPage oTrackOrdPg = new TrackYourOrderPage();
		
		HomePage oHomePg = PageFactory.initElements(oBrowser, HomePage.class);
		TrackYourOrderPage oTrackOrdPg= PageFactory.initElements(oBrowser, TrackYourOrderPage.class);
		
		oHomePg.clickTrackOrder();
		oTrackOrdPg.trackOrderWithoutSignIn();
		oTrackOrdPg.verifyTrackOrderErrorMessage();		
	}
	
	@After
	public void closeApplication()
	{
		//oBrowser.quit();
	}
	
}

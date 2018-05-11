package com.myspicesage.www.E2EScenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.myspicesage.www.pages.HomePage;
import com.myspicesage.www.pages.SSHPage;

public class TS2_VerifyNumberOfItems {
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
		/*oBrowser.findElement(By.xpath("//ul[@id='simplenav']/li/a[contains(@href,'spices-seasonings-herbs.html')]")).click();
		System.out.println("Parent: " + oBrowser.findElements(By.xpath("//a[contains(@onclick,'ground-spices')]")).size());
		System.out.println("Child: " + oBrowser.findElements(By.xpath("//a[contains(@onclick,'ground-spices')]/span")).size());
		System.out.println("Child: " + oBrowser.findElement(By.xpath("//a[contains(@onclick,'ground-spices')]")).getText());
		System.out.println("Child: " + oBrowser.findElement(By.xpath("//input[@type='checkbox']/following-sibling::a[contains(@onclick,'ground-spices')]")).getText());*/
		
		oHomePg.clickSpicesSeasoningsHerbsTab();
		oSSHPg.validateNofItemsDispalyed();
	}
	
	@After
	public void closeApplication()
	{
		//oBrowser.quit();
	}
	
}

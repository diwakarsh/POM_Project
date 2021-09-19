package com.automationpractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//*[@class='login']")
	private WebElement signIn;
	
	@FindBy(xpath="//*[@id='contact-link']")
	private WebElement contactUs;
	
	public WebElement getSignin()
	{
		return signIn;
	}
	
	public WebElement getContactUs()
	{
		return contactUs;
	}
	
	
}

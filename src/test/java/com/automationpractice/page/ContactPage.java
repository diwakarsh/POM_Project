package com.automationpractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
WebDriver driver;
	
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//select[@id='id_contact']")
	private WebElement subjectHeading;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//button[@name='submitMessage']")
	private WebElement send;
	
	@FindBy(xpath="//textarea")
	private WebElement message;
	
	public WebElement getSubjectHeading()
	{
		return subjectHeading;
	}
	
	public WebElement getEmailAddress()
	{
		return emailAddress;
	}
	
	public WebElement getSend()
	{
		return send;
	}
	public WebElement getMessage()
	{
		return message;
	}
}

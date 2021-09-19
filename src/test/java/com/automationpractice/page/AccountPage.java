	package com.automationpractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//input[@name='email_create']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//button[@name='SubmitCreate']")
	private WebElement createAccount;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	private WebElement gender;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='address1']")
	private WebElement addressLine1;

	@FindBy(xpath="//input[@id='city']")
	private WebElement city;
	
	@FindBy(xpath="//select[@id='id_state']")
	private WebElement state;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phone;
	
	@FindBy(xpath="//input[@id='postcode']")
	private WebElement postcode;
	
	@FindBy(xpath="//button[@name='submitAccount']")
	private WebElement submitAccount;
	
	@FindBy(xpath="//a[@title='Orders']")
	private WebElement orders;
		
	public WebElement getEmailAddress()
	{
		return emailAddress;
	}
	
	public WebElement getCreateAccount()
	{
		return createAccount;
	}
	
	public WebElement getGender()
	{
		return gender;
	}
	
	public WebElement getFirstName()
	{
		return firstName;
	}
	
	public WebElement getLastName()
	{
		return lastName;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getAddressLine1()
	{
		return addressLine1;
	}
	public WebElement getCity()
	{
		return city;
	}
	
	public WebElement getState()
	{
		return state;
	}
	
	public WebElement getPhone()
	{
		return phone;
	}
	
	public WebElement getZipcode()
	{
		return postcode;
	}
	
	public WebElement getSubmitAccount()
	{
		return submitAccount;
	}
	public WebElement getOrders()
	{
		return orders;
	}
	
}

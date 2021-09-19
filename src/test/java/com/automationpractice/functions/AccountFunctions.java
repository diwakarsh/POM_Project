package com.automationpractice.functions;


import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automationpractice.page.AccountPage;
import com.automationpractice.page.HomePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import GUIUtils.Misc;

public class AccountFunctions
{
	//Navigate to Account Page
	public static void navigateToCreateAccountPage(WebDriver driver,ExtentTest reportMessage,Map<Object,Object>testData) throws IOException
	{
		//String emailAddress=(String) testData.get("EmailAddress");
		 int min = 1;
	      int max = 1000;
	        
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		String emailAddress="Test_"+random_int+"@email.com";
		HomePage hp=new HomePage(driver);
		reportMessage.log(Status.INFO, "Sign in link is clicked",MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
		hp.getSignin().click();
		
		AccountPage ap=new AccountPage(driver);
		ap.getEmailAddress().sendKeys(emailAddress);
		reportMessage.info("Email Address entered as"+emailAddress,MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
		reportMessage.info("Create an Account button is clicked");
		ap.getCreateAccount().click();
	}
	
	//Fill Data in Account age
	
	public static void fillDataInNewAccountPage(WebDriver driver,ExtentTest reportMessage,Map<Object,Object>testData) throws IOException
	{
		String firstName=(String) testData.get("FirstName");
		String lastName=(String) testData.get("LastName");
		String password=(String) testData.get("Password");
		String addressLine1=(String) testData.get("AddressLine1");
		String city=(String) testData.get("City");
		String state=(String) testData.get("State");
		String zipCode=(String) testData.get("ZipCode");
		String phoneNo=(String) testData.get("PhoneNo");
		
		AccountPage ap=new AccountPage(driver);
		ap.getGender().click();
		reportMessage.info("Mr. is selected");
		
		ap.getFirstName().sendKeys(firstName);
		reportMessage.info("First Name is set as "+firstName);
		
		ap.getLastName().sendKeys(lastName);
		reportMessage.info("Last Name is set as "+lastName);
		
		ap.getPassword().sendKeys(password);
		reportMessage.info("Password  set as "+password);
		
		ap.getAddressLine1().sendKeys(addressLine1);
		reportMessage.info("Address Line 1 is set as "+addressLine1);
		
		ap.getCity().sendKeys(city);
		reportMessage.info("City  set as "+city);
		
		Select comboval=new Select(ap.getState());
		comboval.selectByVisibleText(state);
		reportMessage.info("Stateis set as "+state);
		
		ap.getZipcode().sendKeys(zipCode);
		reportMessage.info("Zip Code s set as "+zipCode);
		
		ap.getPhone().sendKeys(phoneNo);
		reportMessage.info("Phone No is set as "+phoneNo);
		
		reportMessage.info("Register is clicked",MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
		ap.getSubmitAccount().click();
		
		if (ap.getOrders().isDisplayed())
			reportMessage.pass("Account Register Successfully", MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
		else
			reportMessage.fail("Account not Register Successfully", MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
		Assert.assertTrue(ap.getOrders().isDisplayed());
	}
}


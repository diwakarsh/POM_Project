package com.automationpractice.functions;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.page.ContactPage;
import com.automationpractice.page.HomePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import GUIUtils.Misc;

public class ContactUsFunctions {

	public static void sendEmailToContact(WebDriver driver,ExtentTest reportMessage,Map<Object,Object>testData) throws IOException
	{
		HomePage hp=new HomePage(driver);
		reportMessage.info("Click on Contact Us Page");
		hp.getContactUs().click();
		
		reportMessage.log(Status.INFO, "Contact Us Page",
				MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
		ContactPage cp=new ContactPage(driver);
		cp.getSubjectHeading().click();
		Select comboVal=new Select(cp.getSubjectHeading());
		comboVal.selectByVisibleText((String)testData.get("SubjectHeading"));
		cp.getSubjectHeading().click();

		cp.getEmailAddress().sendKeys((String)testData.get("EmailAddress"));
		cp.getMessage().sendKeys("This is test Message");
		
		reportMessage.log(Status.INFO, "Contact Us Page-After filling data",
				MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
		cp.getSend().click();
		
	}
}

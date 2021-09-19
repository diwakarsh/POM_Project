package testCases;

import java.io.IOException;
import java.util.Map;
import org.testng.annotations.Test;

import com.automationpractice.functions.ContactUsFunctions;
import com.aventstack.extentreports.ExtentTest;

import GUIBase.Base;
import GUIUtils.Data_Supplier;

public class Contact_US_Scenario extends Base{

	@Test(dataProvider="Data",dataProviderClass = Data_Supplier.class)
	public void ContactUs(Map<Object,Object> dataMap) throws IOException 
	{
	
		reportMessage=report.createTest("Contact US Scenario");
		ExtentTest contactRpt=reportMessage.createNode("Contact US");
		ContactUsFunctions.sendEmailToContact(driver, contactRpt, dataMap);
	}	
}

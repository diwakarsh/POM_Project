package testCases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.automationpractice.functions.AccountFunctions;
import com.aventstack.extentreports.ExtentTest;

import GUIBase.Base;
import GUIUtils.Data_Supplier;

public class RegisterNewAccount extends Base
{
	@Test(dataProvider="Data",dataProviderClass = Data_Supplier.class)
	public void CreateAccount(Map<Object,Object> dataMap) throws IOException 
	{
	
		reportMessage=report.createTest("Register New Account");
		ExtentTest signInReport= reportMessage.createNode("HomePage");
		AccountFunctions.navigateToCreateAccountPage(driver, signInReport, dataMap);
		
		ExtentTest accountReport= reportMessage.createNode("New Account");
		AccountFunctions.fillDataInNewAccountPage(driver, accountReport, dataMap);
	}	
}

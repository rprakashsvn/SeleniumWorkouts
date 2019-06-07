package testScripts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import dataProviders.DataInputProvider;
import generics.HRMSExecutionMethods;
import pages.LoginPage;

public class HRMS extends HRMSExecutionMethods
{
	String[][] data = DataInputProvider.getSheet("User_Details");

	@Test
	public void hrms()
	{	
		System.out.println(data.length);
		for (int i=0; i<=data.length; i++ )
		{
			for(int j=0;j<data[i].length;j++)
			{
				System.out.println(data[i][j]+""+i);
				System.out.println(data[i][j]+""+j);
			}
			System.out.println(data[0][0]);
			System.out.println(data[0][1]);
		}
		
		new LoginPage(driver)
		.enterUsername(data[0][0])
		.enterPassword(data[0][1]);
		
		/*enterByIdValue("UserName", "vsuresh");
		enterByIdValue("Password", "suresh2809");
		clickLogin();
		clickSubmit();
		selectDropDown();
		clickSubmit();*/
	}
}

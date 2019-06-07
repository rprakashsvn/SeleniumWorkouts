package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import generics.HRMSExecutionMethods;

public class LoginPage extends HRMSExecutionMethods
{
	public LoginPage(RemoteWebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPage enterUsername(String data)
	{
		enterByIdValue("UserName", data);
		return this;
	}
	
	public LoginPage enterPassword(String data)
	{
		enterByIdValue("Password", data);
		return this;
	}
}



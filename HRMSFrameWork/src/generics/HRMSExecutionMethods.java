package generics;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

public class HRMSExecutionMethods extends GenericFunctions
{
	public String browserName = "chrome"; 
	public String dataSheetName ="User_Details";
	
	@Before
	public void beforeTest()
	{
		loadBrowser(browserName);
	}
}

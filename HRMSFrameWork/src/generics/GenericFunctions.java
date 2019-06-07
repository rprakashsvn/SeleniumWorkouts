package generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class GenericFunctions implements GenericMethods{
		
	protected static Properties prop;
	public RemoteWebDriver driver;
	String hubValue,portValue,urlValue;
	
	public GenericFunctions() 
	{
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File("./src/main/resources/HRMS_config.properties"))); 
			hubValue = prop.getProperty("HUB");
			portValue = prop.getProperty("PORT");
			urlValue = prop.getProperty("URL");
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void loadObjects()
	{
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/HRMS_object.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void loadBrowser(String browser)
	{
		try {
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(urlValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterByIdValue(String idValue, String data) {
		// TODO Auto-generated method stub
			try {
				driver.findElement(By.id(idValue)).clear();
				driver.findElement(By.id(idValue)).sendKeys(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Exception Occurred");
			}
			
	}
	

	public void enterByPassWord(String password, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Occurred");
		}
	}

	public void clickLogin() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//input[@name='signin']")).click();
	}

	public void clickSubmit() {
		// TODO Auto-generated method stub
		driver.findElement(By.id("submit")).click();
	}

	public void selectDropDown() {
		// TODO Auto-generated method stub
		WebElement list = driver.findElementById("Organisation_Id");
		Select dropdown = new Select(list); 
		dropdown.selectByIndex(1);
	}

	public String dataProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	public void enterByUserName(String username, String data) {
		// TODO Auto-generated method stub
		
	}

	
	


}

package testScripts;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HRMSTestCases 
{	
	static int i;
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Login application		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.240.14.20:7104/HRMS/");
		driver.findElementById("UserName").sendKeys("vsuresh");
		driver.findElementById("Password").sendKeys("suresh2809");
		driver.findElementByXPath("//input[@name='signin']").click();
		driver.findElementById("submit").click();
		
		//Drop Down
		WebElement list = driver.findElementById("Organisation_Id");
		Select dropdown = new Select(list); 
		dropdown.selectByIndex(1);
		
		driver.findElementById("submit").click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		WebElement  leaveList = driver.findElementByXPath("(//span[@class='caret'])[1]");
		leaveList.click();
		driver.findElementByLinkText("Leave Request").click();
		driver.findElementByXPath("(//div[@id='typebutton'])/label[2]").click();
		driver.findElementByXPath("(//span[@class='k-icon k-i-calendar'])[1]").click();
		Thread.sleep(2000);
		WebElement  fromDate = driver.findElement(By.xpath(".//*[@class='k-widget k-calendar']/div/a[3]/span"));
		if(fromDate.isEnabled())
		{
			for (i=1;;i++)
			{
				fromDate.click();
				System.out.println("Button Clicked");
				if(i==2)
				{
				break;
				}
			}
			
			WebElement table = driver.findElement(By.tagName("table"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println(rows.size());
			List<WebElement> columns = table.findElements(By.tagName("td"));
			System.out.println(columns.size());
			System.out.println(rows.get(0).getText());
			System.out.println(columns.get(0).getText());
			
			for(WebElement cell : columns )
			{
				if(cell.getText().equalsIgnoreCase("30"))
				{
				System.out.println(cell.getText());
				cell.findElement(By.linkText("30")).click();					
				}
			}
		}			
			driver.findElementByXPath("(//span[@class='k-icon k-i-calendar'])[2]").click();
			Thread.sleep(2000); // waiting for 20 seconds 
			
			WebElement toDate = driver.findElement(By.xpath(".//*[@class='k-widget k-calendar']/div/a[3]/span"));
			if(toDate.isEnabled())
			{
				for (i=1;;i++)
				{
					fromDate.click();
					System.out.println(" Button is Clicked ");
					if(i==2)
					{
					break;
					}
				}
			}
			
			WebElement table = driver.findElement(By.tagName("table"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println(rows.size());
			List<WebElement> columns = table.findElements(By.tagName("td"));
			System.out.println(columns.size());
			for(WebElement cell : columns)
			{
				if(cell.getText().equalsIgnoreCase("31"))
				{
					System.out.println(cell.getText().equalsIgnoreCase("31"));
					cell.findElement(By.linkText("31")).click();
				}
			}		
		}
	}	
}


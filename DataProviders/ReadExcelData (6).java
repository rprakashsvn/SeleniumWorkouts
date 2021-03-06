package DataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider 
{
	public static File resultFile = new File("C:\\Program Files\\sw\\Automation\\Selenium\\TestData\\RegistrationDetails.xlsx");
	public static DataFormatter formatter = new DataFormatter();
	public WebDriver driver;
	public static String SheetName = "Registrations";

	@BeforeTest(enabled = true)
	public void LaunchBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\sw\\Drivers\\chromedriver_2.46.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.stqatools.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "readExcelFile", enabled = true)
	public void Registration(String Name, String FathersName, String address, String PersonalAddress, String PinCode) throws IOException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("studentname")).sendKeys(Name);
		driver.findElement(By.id("studentname")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("fathername")).sendKeys(FathersName);
		driver.findElement(By.id("fathername")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("paddress")).sendKeys(address);
		driver.findElement(By.id("paddress")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("personaladdress")).sendKeys(PersonalAddress);
		driver.findElement(By.id("personaladdress")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("pincode")).sendKeys(PinCode);
		driver.findElement(By.id("pincode")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@SuppressWarnings("resource")
	@DataProvider
	public String[][] readExcelFile() throws InvalidFormatException, IOException 
	{
		FileInputStream loadExcelFile = new FileInputStream(resultFile);
		XSSFWorkbook workBook = new XSSFWorkbook(loadExcelFile);
		XSSFSheet sheet = workBook.getSheet(SheetName);

		int RowNum = sheet.getPhysicalNumberOfRows();
		int ColNum = sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println("No Of PhysicalNumberOfRows : " + sheet.getPhysicalNumberOfRows());
		System.out.println("No Of PhysicalNumberOfCell : " + sheet.getRow(0).getPhysicalNumberOfCells());
	
		String[][] XLData = new String[RowNum - 1][ColNum];

		for (int i = 0; i <= RowNum - 1; i++) 
		{
			XSSFRow row = sheet.getRow(i + 1);
			for (int j = 0; j <= ColNum; j++) 
			{
				if (row == null) 
				{
					XLData[i][j] = "";
				} 
				else 
				{
					XSSFCell cell = row.getCell(j);
					if (cell == null) 
					{
						XLData[i][j] = "";
					} 
					else 
					{
						String value = formatter.formatCellValue(cell);
						XLData[i][j] = value.trim();
						System.out.print(XLData[i][j]);
					}
				}
			}
		}
		return XLData;
	}
}
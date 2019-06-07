package DataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class ReadExcelData2 
{
	public String filePath = "C:\\Program Files\\sw\\Automation\\Selenium\\TestData\\TrackerList.xlsx";
	public WebDriver driver;
	public String[][] XLData;
	
	@BeforeTest(enabled = true)
	public void LaunchBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\sw\\Drivers\\chromedriver_2.46.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.stqatools.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "ReadExcelFileData", enabled = true)
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


	@SuppressWarnings({ "resource" })
	@DataProvider
	public String[][] ReadExcelFileData() throws Exception 
	{
		try 
		{
			File loadFile = new File(filePath);
			FileInputStream readFile = new FileInputStream(loadFile);
			String fileName = loadFile.getName();
			System.out.println(fileName);
			XSSFWorkbook workBook = new XSSFWorkbook(readFile);
			XSSFSheet sheet = workBook.getSheet("ResultList");

			// Row Count
			int rowCount = sheet.getLastRowNum() + 1;
			System.out.println("rowCount : " + rowCount);

			// Cell Count for each Rows
			XSSFRow row = sheet.getRow(0);

			// columnCount
			int coulmnCount = row.getLastCellNum();
			System.out.println("coulmnCount : " + coulmnCount);

			XLData = new String[rowCount][coulmnCount];

			int startRowIndex = 1;
			int startColIndex = 0;

			try 
			{
				for (int i = startRowIndex; i < rowCount; i++) 
				{
					XSSFRow rows = sheet.getRow(i);
					for (int j = startColIndex; j < coulmnCount; j++) 
					{
						if (rows == null) 
						{
							XLData[i][j] = "";
						} 
						else 
						{
							XSSFCell cell = rows.getCell(j);
							if (cell == null) 
							{
								XLData[i][j] = "";
							} 
							else 
							{
								DataFormatter formatter = new DataFormatter();
								String value = formatter.formatCellValue(cell);
								XLData[i][j] = value.trim();
								System.out.print(XLData[i][j] + " ");
							}
						}
					}
					System.out.println(" | ");
				}
				System.out.println();
			} 
			catch (ArrayIndexOutOfBoundsException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (ArrayIndexOutOfBoundsException e) 
		{
			e.printStackTrace();
		}
		return XLData;
	}
}

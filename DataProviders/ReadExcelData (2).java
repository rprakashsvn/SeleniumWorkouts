package DataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDataProviders 
{
	String FilePath = "C:\\Program Files\\sw\\Automation\\myMSC New UI\\TestData\\TestData.xlsx";
	String sheetName = "LoginDetails";
	WebDriver driver;
	
	@Test(dataProvider = "ReadExcelData", enabled = true)
	public void getData(String Username, String Password)
	{
		System.out.println(Username + " " + Password);

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\sw\\Drivers\\chromedriver_2.46.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.stqatools.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("studentname")).sendKeys(Username);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("fathername")).sendKeys(Password);
	}
	
	@SuppressWarnings("resource")
	@Test
	public void ReadExcelData() throws Exception 
	{
		File loadExcelFile = new File(FilePath);
		FileInputStream readExcel = new FileInputStream(loadExcelFile);
		XSSFWorkbook workBook = new XSSFWorkbook(readExcel);
		XSSFSheet sheet = workBook.getSheetAt(0);

		// Row Count
		int rowCount = sheet.getLastRowNum()+1;
		System.out.println("Total Rows : " + rowCount);

		// Col Count
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Total Cols : " + colCount);

		String[][] XLData = new String[rowCount][colCount];
		int startRow = 1;
		int startCols = 0;

		for (int i = startRow; i < rowCount; i++) 
		{
			XSSFRow row = sheet.getRow(i);
			for (int j = startCols; j < colCount; j++) 
			{
				XSSFCell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String value = formatter.formatCellValue(cell);
				XLData[i][j] = value.trim();
				System.out.print(XLData[i][j]+ " ");
			}
			System.out.println(" ");
		}
		//return XLData;
	}
}

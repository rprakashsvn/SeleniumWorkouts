package DataProviders;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ReadExcelData 
{
	public String filePath = "C:\\Program Files\\sw\\Automation\\myMSC New UI\\TestData\\TestData.xlsx";
	public WebDriver driver;

	@SuppressWarnings({ "resource" })
	@Test
	public void ReadExcelFileData() throws Exception 
	{
		try 
		{
			File loadFile = new File(filePath);
			FileInputStream readFile = new FileInputStream(loadFile);
			String fileName = loadFile.getName();
			System.out.println(fileName);
			XSSFWorkbook workBook = new XSSFWorkbook(readFile);
			XSSFSheet sheet = workBook.getSheet("LoginDetails");

			// Row Count
			int rowCount = sheet.getLastRowNum() + 1;
			int rowMinusHeader = rowCount - 1;
			System.out.println("rowCount : " + rowCount + " " + "rowMinusHeader : " + rowMinusHeader);

			// Cell Count for each Rows
			XSSFRow row = sheet.getRow(0);

			// columnCount
			int coulmnCount = row.getLastCellNum();
			System.out.println("coulmnCount : " + coulmnCount);

			String[][] XLData = new String[rowCount][coulmnCount];

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
	}
}

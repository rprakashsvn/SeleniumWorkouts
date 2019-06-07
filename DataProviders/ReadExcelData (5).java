package ReadExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData 
{

	public static void main(String[] args) throws Exception 
	{
		ReadExcelData DataProviderObject = new ReadExcelData();
		DataProviderObject.DataProvider();
	}

	@SuppressWarnings("resource")
	public Object[][] DataProvider() 
	{
		try 
		{
			File src = new File("C:\\Program Files\\sw\\Prakash\\ReadExcelData\\src\\RataProvider\\InuptData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheetAt(0);

			// get the number of rows
			int rowCount = sheet.getLastRowNum();
			System.out.println("Row Count : " + rowCount);

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			System.out.println("Column Count : " + columnCount);

			// System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return DataProvider(SheetName);
	}
}

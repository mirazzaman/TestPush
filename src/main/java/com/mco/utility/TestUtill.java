package com.mco.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mco.base.TestBase;

public class TestUtill extends TestBase{
	public static final long IMPLICITLY_WAIT_TIME = 10;
	public static final long PAGE_LOADE_TIME = 10;
	public static String TEST_DATA_SHEET_PATH = "/Users/khosruzzaman/FrameWork/MulticartAutomationSuit/DataSheet.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static FileInputStream fis;
	

	public static Object[][] getTestData(String sheetName) {
		try {
			fis = new FileInputStream(TEST_DATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		}catch (IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
		System.out.println(sheet.getLastRowNum()+ " ROW's and ==========="+sheet.getRow(0).getLastCellNum()+" COLUMN's");
		for(int i =0; i<sheet.getLastRowNum(); i++) {
			for(int j = 0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]= sheet.getRow(i+1).getCell(j).toString(); // i+1 cell--0
				System.out.println(data[i][j]+"  ");
			}
		}
		return data;

	}
	public static void takeScreenShoot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String curentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(curentDir+"/Screen_Shoots/"+System.currentTimeMillis()+".png"));
	}
	public static void expliciteWait(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICITLY_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
		
	
}
}

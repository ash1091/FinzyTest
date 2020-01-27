package sampletestcases;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import pageobjects.GoogleSearchPage;
import pageresources.Basetest;

public class LandingPage extends Basetest {

	public void launch() throws IOException {
		driver = initializebroswer();
		driver.get("https://www.google.com");
	}

	@Test(dataProvider = "find")
	public void f(String Text) throws InterruptedException {
		
		GoogleSearchPage GP = new GoogleSearchPage(driver);
GP.googlesearch()GP.LaunchGoogle();
		int total = GP.googlesearch().size();
		System.out.println(total);
		for (int i = 0; i < total; i++) {
			System.out.println(GP.googlesearch().get(i).getText());
			if (GP.googlesearch().get(i).getText().equalsIgnoreCase("finzy loan")) {
				GP.googlesearch().get(i).click();
			} else if (GP.googlesearch().get(i).getText().equalsIgnoreCase("finzy investment")) {
				GP.googlesearch().get(i).click();
			} else if (GP.googlesearch().get(i).getText().equalsIgnoreCase("finzy login")) {
				GP.googlesearch().get(i).click();
			}
			String second_link = GP.googlesearch().get(0).getAttribute("href");
			driver.navigate().to(second_link);
			break;

		}
	}

	public String[][] getTableArray(String xlFilePath, String sheetName, String tableName) {
		String[][] tabArray = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol
					+ ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;

			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			System.out.println("error in getTableArray()");
		}

		return (tabArray);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider(name = "find")
	public Object[][] dp() {
		Object[][] obj = getTableArray("C:\\Users\\ASHIVEN KUMAR\\Desktop\\Weinvest Interview\\DataDriven.xls", "Data",
				"begin");
		return obj;

	};

	
}

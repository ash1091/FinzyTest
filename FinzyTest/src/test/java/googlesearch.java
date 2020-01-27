import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class googlesearch {
	WebDriver driver;

	@Test(dataProvider = "find")
	public void f(String text) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(text);
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"));
		/*
		 * driver.findElement(By.xpath(
		 * "//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		 * driver.findElement(By.xpath(
		 * "//ul[@role='listbox']//li/descendant::div[@class='sbtc]"));
		 */

		System.out.println("total number of suggestions" + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equalsIgnoreCase("Finzy loan")) {
				list.get(i).click();
				driver.findElement(By.xpath("//div[@class='g']//div//div//div[@class='rc']//div[@class='r']")).click();
break;
			}

			if (list.get(i).getText().equalsIgnoreCase("Finzy investment")) {
				list.get(i).click();
				driver.findElement(
						By.xpath("//h3[contains(text(),'Alternative Investment opportunities in India | Lo')]"))
						.click();
				break;
			}

			else if (list.get(i).getText().equalsIgnoreCase("Finzy login")) {
				list.get(i).click();
				driver.findElement(
						By.xpath("//h3[contains(text(),'finzy: Low Interest Personal Loans | Get easy loan')]"))
						.click();
break;
			}
		}

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://www.google.com");
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider(name = "find")
	public Object[][] dp() {
		Object[][] obj = getTableArray("C:\\Users\\ASHIVEN KUMAR\\Desktop\\Finzy\\DataDriven.xls", "Data", "begin");
		return obj;

	};

	@BeforeClass
	public void beforeClass() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\ASHIVEN KUMAR\\eclipse-workspace\\FinzySearch\\datadriven.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		System.out.print(browser);
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ASHIVEN KUMAR\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		if (browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "F:\\Selenium Related Stuffs/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	}

	@AfterClass
	public void afterClass() {
		driver.close();
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
}

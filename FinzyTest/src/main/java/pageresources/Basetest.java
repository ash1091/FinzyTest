package pageresources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Basetest {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializebroswer() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ASHIVEN KUMAR\\git\\FinzyTest\\FinzyTest\\datadriven.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		System.out.print(browser);
		if(browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHIVEN KUMAR\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}		
				
		if (browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "F:\\Selenium Related Stuffs/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
			
						
		}
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				return driver;
				
			}
	
	
	}
	
		



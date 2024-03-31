package Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;


public class Utilities {
	

	public static WebDriver driver;
	public  String excelFile;
	public int excelSheet;
		 
	
	public static void browserLaunch(String browser, String url) {
		
		if(browser.equals("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches",
			Arrays.asList("disable-popup-blocking"));
			
			driver = new ChromeDriver();
			}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if (browser.equals("safari")) {
			driver = new SafariDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	public void click(WebElement element) {
		element.click();
	}
	
	public void sendkeys(WebElement ele, String value) {
		new Actions(driver).moveToElement(ele).click().sendKeys(value).perform();
	}
	
	public String[][] readExcel(String excelFile, int  excelSheet) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook(excelFile);  
		XSSFSheet sheet = book.getSheetAt(excelSheet); 
		 
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("rowcount is ==  "+rowcount+"  "+ "columncount is =" +columncount);
		
		String[][] data = new String[rowcount][columncount];
		
		for(int i=1; i<=rowcount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0; j<columncount; j++) {
				
				XSSFCell cell = row.getCell(j);
				if(cell.getCellType()==CellType.STRING)
				{
					data[i-1][j]=cell.getStringCellValue();
				}
				else if(cell.getCellType()==CellType.NUMERIC)
				{
					data[i-1][j]=NumberToTextConverter.toText(cell.getNumericCellValue());
				}
				System.out.println(data[i-1][j]);
				
			}
		}
		book.close();
		return data;
	}
	
	 public static void mouseWheel(int size) throws AWTException {
	        Robot ro = new Robot();
	        ro.setAutoDelay(1000);
	        ro.mouseWheel(size);
	    }
	 
	 public void switchWindows(String url) {
		 String MainWindow=driver.getWindowHandle();
		    
		    for (String Eachwindow : driver.getWindowHandles()) 
		    {
				String Runtime_Title=driver.switchTo().window(Eachwindow).getCurrentUrl();
				if(Runtime_Title.contains(url))
				{
					break;
				}
			}
	 }
	
	 public void switchToAlert() {
		 Alert alert= driver.switchTo().alert();
	 }
}
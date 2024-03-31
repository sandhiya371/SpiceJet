package Base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utility.Utilities;

public class ProjectSpecifications extends Utilities{
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void launchBrowser(String browser, String url) {
		browserLaunch(browser,url);
	}
	
	@DataProvider(name = "readExcel")
	public String[][] getExceldata() throws IOException {
		String[][] data = readExcel(excelFile, excelSheet);
		return data;
	}

	@AfterMethod
	public void closeDriver(){
		driver.close();
	}
}

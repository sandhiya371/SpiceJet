package SpiceJectTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecifications;
import SpiceJetPages.HomePage;
import SpiceJetPages.LoginPage;
import Utility.Utilities;



public class LoginTest extends ProjectSpecifications{
	HomePage homePage;
	LoginPage loginPage;
	Utilities utility= new Utilities();
	
	@BeforeTest
	public void setup() {
		excelFile = "C:\\Users\\donna\\OneDrive\\Desktop\\Browsers for testing\\workspace\\SpiceJet\\src\\test\\java\\Resources\\TestData.xlsx";
		excelSheet = 0;
	}
	
	
	
	@Test(dataProvider = "readExcel")
	public void SignUpTest(String mobileNumber, String Password) throws InterruptedException {
		
		homePage = new HomePage(driver);
		click(homePage.loginBtn);
		Thread.sleep(3000);
		switchWindows("https://spiceclub.spicejet.com/");
		Thread.sleep(3000);
		loginPage= new LoginPage(driver);
		
		loginPage.login(mobileNumber, Password);
	}

}

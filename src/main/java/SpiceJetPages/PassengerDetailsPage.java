package SpiceJetPages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.ProjectSpecifications;
import Utility.Utilities;

public class PassengerDetailsPage extends ProjectSpecifications{
	
	 Utilities utility=new Utilities();

	@FindBy(xpath="(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[1]")
	public WebElement titileDropDown;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	public WebElement firstNameTextField;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	public WebElement lastNameTextField;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	public WebElement contactNumberTextField;
	
	@FindBy(xpath="(//input[@type='text'])[4]")
	public WebElement emailTextField;
	
	@FindBy(xpath="(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[3]")
	public WebElement countrySelectionDropdown;
	
	@FindBy(xpath="(//input[@type='text'])[5]")
	public WebElement cityTextField;
	
	@FindBy(xpath="(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[4]")
	public WebElement passengerTitleDropdown;
	
	@FindBy(xpath="(//input[@type='text'])[6]")
	public WebElement passengerfirstNameTextField;	
	
	@FindBy(xpath="(//input[@type='text'])[7]")
	public WebElement passengerlastNameTextField;
	
	@FindBy(xpath="(//input[@type='text'])[8]")
	public WebElement passengercontactNumberTextField;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-6ity3w r-d9fdf6 r-9qu9m4 r-ah5dr5 r-1otgn73']")
	public WebElement continueBtn;
	
	/*public PassengerDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}*/
	
	public PassengerDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void contactDetails(String fName, String lName, String contact, String emailId, String city) throws InterruptedException {
		//new Select(titileDropDown).selectByIndex(1);
		click(titileDropDown);
		click(driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1habvwh r-1loqt21 r-1777fci r-1inuy60 r-1yt7n81 r-1otgn73'])[1]")));
		click(firstNameTextField);
		sendkeys(firstNameTextField, fName);
		click(lastNameTextField);
		sendkeys(lastNameTextField, lName);
		click(contactNumberTextField);
		new Actions(driver).click(contactNumberTextField).sendKeys(contact+Keys.TAB).perform();;
		click(emailTextField);
		new Actions(driver).click(emailTextField).sendKeys(emailId+Keys.TAB).perform();
		click(cityTextField);
		click(countrySelectionDropdown);
		click(driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-qsz3a2 r-poiln3 r-n6v787 r-1e081e0 r-oyd9sg'])[101]")));
		new Actions(driver).click(cityTextField).sendKeys(city+Keys.TAB).perform();
		
	}
	
	public void passengersDetails(String fName, String lName, String contactNumbetr) throws AWTException {

		click(passengerTitleDropdown);
		click(driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1habvwh r-1loqt21 r-mabqd8 r-1777fci r-1yt7n81 r-1otgn73'])[1]")));
										//css-1dbjc4n r-1niwhzg r-1p0dtai r-1d2f490 r-1udh08x r-u8s1d r-zchlnj r-ipm5af
		click(passengerfirstNameTextField);
		sendkeys(passengerfirstNameTextField, fName);
		click(passengerlastNameTextField);
		sendkeys(passengerlastNameTextField, lName);
		click(passengercontactNumberTextField);
		sendkeys(passengercontactNumberTextField, contactNumbetr);
	}
	
	public void clickContinuBtn() {
		click(continueBtn);
	}
	
}

package SpiceJetPages;

import Utility.Utilities;

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

public class SignUpPage extends ProjectSpecifications {
	
	Utilities utility = new Utilities();
    @FindBy(xpath = "//select[contains(@class,'form-control form-select ')]")
    public WebElement genderDropdown;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement firstNameTextField;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement lastNameTextField;

    @FindBy(xpath = "(//input[contains(@type,'text')])[3]")
    public WebElement dobField;

    @FindBy(xpath = "//input[contains(@class,' form-control')]")
    public WebElement mobileNoField;

    @FindBy(xpath = "//input[@type='text'][contains(@id,'id')]")
    public WebElement emailTextField;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement passwordTextField;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement confirmPasswordTextField;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkbox;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement submitBtn;


    public SignUpPage(WebDriver driver){
    	PageFactory.initElements(driver, this);
		this.driver=driver;
       
    }

    public void signUp(String fNmae, String lName, String Dob,String mobileNo, String emailId, String PSWD, String CPSWD) throws InterruptedException, AWTException{

    	Thread.sleep(5000);
    	utility.click(genderDropdown);
    	new Select(genderDropdown).selectByIndex(1);
    	utility.sendkeys(firstNameTextField,fNmae);
        Thread.sleep(1000);
        utility.sendkeys(lastNameTextField,lName);
        Thread.sleep(1000);
        new Actions(driver).click(dobField).sendKeys(Dob).sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        new Actions(driver).click(mobileNoField).sendKeys(mobileNo+Keys.ENTER).perform();
        Thread.sleep(1000);
        new Actions(driver).click(emailTextField).sendKeys(emailId+Keys.TAB).perform();
        Thread.sleep(2000);
        utility.sendkeys(passwordTextField,PSWD);
        Thread.sleep(1000);
        utility.sendkeys(confirmPasswordTextField,CPSWD);
        Thread.sleep(1000);
        Thread.sleep(1000);	
        checkbox.click();
        Thread.sleep(1000);
        utility.click(submitBtn);

    }
}

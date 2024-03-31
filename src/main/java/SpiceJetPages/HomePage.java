package SpiceJetPages;

import Utility.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utilities {

    @FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-ubezar']")
    public WebElement loginBtn;

    @FindBy(xpath = "(//div[@dir='auto'])[48]")
    public WebElement signUpBtn;

    public HomePage(WebDriver driver) {
    	
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}


	public LoginPage clickLoginBtn(){
        click(loginBtn);
        return new LoginPage(driver);
    }


	public SignUpPage clickSignUpBtn(){
        click(signUpBtn);
        return new SignUpPage(driver);
    }
}

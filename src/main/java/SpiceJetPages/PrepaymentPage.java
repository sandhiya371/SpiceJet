package SpiceJetPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.ProjectSpecifications;

public class PrepaymentPage extends ProjectSpecifications{
	
	@FindBy(xpath = "//input[@placeholder='Enter Card Number Here']")
	public WebElement cardNumberField;
	
	@FindBy(xpath = "//input[@id='name_on_card']")
	public WebElement cardHolderName;
	
	@FindBy(xpath = "//input[@id='card_exp_month']")
	public WebElement expMonthField;
	
	@FindBy(xpath = "//input[@id='card_exp_year']")
	public WebElement cardExpYearField;
	
	@FindBy(xpath = "//input[@id='security_code']")
	public WebElement cardCvvField;
	
	@FindBy(xpath = "//div[@data-testid='common-proceed-to-pay']")
	public WebElement paymentBtn;
	
	public PrepaymentPage(WebDriver name) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void cardDetails(String cardNo, String name, String month, String year, String cvv) {

		try {


			driver.switchTo().frame(cardNumberField);
			System.out.println("switched to frame");
			cardNumberField.click();
			sendkeys(cardNumberField, cardNo);

			driver.switchTo().frame(2);
			cardHolderName.click();
			sendkeys(cardHolderName, name);

			driver.switchTo().frame(3);
			expMonthField.click();
			sendkeys(expMonthField, month);

			driver.switchTo().frame(4);
			cardExpYearField.click();
			sendkeys(cardExpYearField, year);

			driver.switchTo().frame(5);
			cardCvvField.click();
			sendkeys(cardCvvField, cvv);

			driver.switchTo().defaultContent();

			click(paymentBtn);

		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}

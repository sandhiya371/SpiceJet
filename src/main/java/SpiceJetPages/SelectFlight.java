package SpiceJetPages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.ProjectSpecifications;
import Utility.Utilities;

public class SelectFlight extends ProjectSpecifications{
	Utilities utilities = new Utilities();
	@FindBy(xpath = "//div[contains(@data-testid,'continue-search-page-cta')]")
	public WebElement continueBtn;
	
	@FindBy(xpath = "(//div[@data-testid='spicesaver-flight-select-radio-button-0'])[1]")
	public WebElement flights;
	
	public SelectFlight(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void selectFlight() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		utilities.click(continueBtn);
	}
	
}

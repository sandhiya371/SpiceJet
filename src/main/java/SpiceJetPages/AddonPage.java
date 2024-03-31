package SpiceJetPages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.ProjectSpecifications;

public class AddonPage extends ProjectSpecifications{

	@FindBy(xpath="(//div[@class='css-1dbjc4n r-1niwhzg r-1p0dtai r-1d2f490 r-1udh08x r-u8s1d r-zchlnj r-ipm5af'])[3]")
	public WebElement continueBtn;
	
	public AddonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void addonScreenActions() throws AWTException, InterruptedException {

		Thread.sleep(4000);
		new Actions(driver).moveToElement(continueBtn).click(continueBtn).perform();
		Thread.sleep(1000);
		
		if (driver.getCurrentUrl().equals("https://www.spicejet.com/booking/addons")) {
			new Actions(driver).moveToElement(continueBtn).click(continueBtn).perform();
			try {
				new Actions(driver).moveToElement(continueBtn).click(continueBtn).perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
}

package SpiceJetPages;
import Utility.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.ProjectSpecifications;

import java.util.List;

public class SelectingTypeOfTripPage extends ProjectSpecifications {
	
	Utilities utility= new Utilities();
    @FindBy(xpath = "(//input[contains(@type,'text')])[1]")
    public WebElement origin;

    @FindBy(xpath = "(//input[contains(@type,'text')])[2]")
    public WebElement  selectDestination;

    @FindBy(xpath = "(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[1]")
    public WebElement  startDate;

    @FindBy(xpath = "(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[1]")
    public WebElement endDate;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[2]")
    public WebElement roundTripRadioBtn;

    @FindBy(xpath = "(//div[contains(.,'Search Flight')])[9]")
    public WebElement searchFlightBtn;

    public SelectingTypeOfTripPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void selectRequiredDate(String monthYear,String date) throws InterruptedException {
        WebElement el = driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']"));
        List<WebElement> requiredMonth = el.findElements(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
        
        for (WebElement expectedMonth: requiredMonth) {
            if(expectedMonth.getText().trim().equals(monthYear.trim())){
                List<WebElement> reqDate = driver.findElements(By.xpath("//div//div//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41']"));
                for (WebElement d:reqDate) {
                    if(d.getText().trim().equals(date.trim())){
                        d.click();
                        break;
                    }
                    reqDate = driver.findElements(By.xpath("//div//div//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41']"));
                }
                break;
            }
            
            System.out.println("========"+expectedMonth.getText()+"     "+ monthYear);
            WebElement NextButton=driver.findElement(By.xpath("(//div[@data-testid='undefined-calendar-picker']//div)[1]"));
            NextButton.click();
            Thread.sleep(2000);

        }

    }
    public void oneWayTrip(String from, String Destination, String date, String month) throws InterruptedException {

        new Actions(driver).click(origin).sendKeys(from).sendKeys(Keys.ENTER).perform();
        new Actions(driver).click(selectDestination).sendKeys(Destination).sendKeys(Keys.ENTER).perform();
        selectRequiredDate(month,date);
        Thread.sleep(3000);
        utility.click(searchFlightBtn);
        

    }

    public void roundTrip(String from, String Destination, String startDate,String returnDate, String month) throws InterruptedException{
    	
    	utility.click(roundTripRadioBtn);
    	Thread.sleep(2000);
        new Actions(driver).click(origin).sendKeys(from).sendKeys(Keys.ENTER).perform();
        new Actions(driver).click(selectDestination).sendKeys(Destination).sendKeys(Keys.ENTER).perform();
        selectRequiredDate(month,startDate);
        Thread.sleep(3000);
        selectRequiredDate(month,returnDate);
        utility.click(searchFlightBtn);
        
    }
}

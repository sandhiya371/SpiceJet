package SpiceJectTest;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.ProjectSpecifications;
import SpiceJetPages.AddonPage;
import SpiceJetPages.HomePage;
import SpiceJetPages.PassengerDetailsPage;
import SpiceJetPages.PrepaymentPage;
import SpiceJetPages.SelectFlight;
import SpiceJetPages.SelectingTypeOfTripPage;
import Utility.Utilities;

public class PassengersDetailsTest extends ProjectSpecifications {

	HomePage HomePage;
	AddonPage addonPage;
	SelectingTypeOfTripPage bookTicket;
	SelectFlight selectFlight;
	PassengerDetailsPage passengerDetailsPage;
	PrepaymentPage payment;

	@Test
	public void bookOneWayTickect() throws InterruptedException, AWTException {
		bookTicket = new SelectingTypeOfTripPage(driver);
		bookTicket.oneWayTrip("Delhi", "Hyderabed", "28", "March 2024");
		
		selectFlight = new SelectFlight(driver);
		selectFlight.selectFlight();
		switchWindows("https://www.spicejet.com/booking");
	
		passengerDetailsPage= new PassengerDetailsPage(driver);
		passengerDetailsPage.contactDetails("Test", "Test", "9553645937", "test@mailinator.com", "India");
		passengerDetailsPage.passengersDetails("Test", "Test", "9553645937");
		passengerDetailsPage.clickContinuBtn();
		
		switchWindows("https://www.spicejet.com/booking/addons");
		
		addonPage = new AddonPage(driver);	
		
		Thread.sleep(5000);
		addonPage.addonScreenActions();
		
		Thread.sleep(2000);

		switchWindows("https://www.spicejet.com/booking/prepayment");
		payment= new PrepaymentPage(driver);

		payment.cardDetails("123456789021", "Patience Carney", "06", "2026", "125");


		
	}
}

package SpiceJectTest;

import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.ProjectSpecifications;
import SpiceJetPages.HomePage;
import SpiceJetPages.SelectFlight;
import SpiceJetPages.SelectingTypeOfTripPage;

public class SelectFlightTest extends ProjectSpecifications{
		
	HomePage HomePage;
	SelectFlight selectFlight;
	SelectingTypeOfTripPage bookTicket;
	Object excelSheet;
	Object excelFile;
	
	
	@Test
	public void bookOneWayTickect() throws InterruptedException, AWTException {
		bookTicket = new SelectingTypeOfTripPage(driver);
		bookTicket.oneWayTrip("Delhi", "Hyderabed", "28", "March 2024");
		Thread.sleep(5000);
		selectFlight = new SelectFlight(driver);
		selectFlight.selectFlight();
		
	}
}

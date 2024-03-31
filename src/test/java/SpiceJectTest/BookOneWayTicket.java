package SpiceJectTest;

import org.testng.annotations.Test;

import Base.ProjectSpecifications;
import SpiceJetPages.HomePage;
import SpiceJetPages.SelectingTypeOfTripPage;

public class BookOneWayTicket extends ProjectSpecifications{
	
	HomePage HomePage;
	SelectingTypeOfTripPage book;
	
	@Test
	public void bookOneWayTicket() throws InterruptedException {
		book = new SelectingTypeOfTripPage(driver);
		book.oneWayTrip("Delhi", "Hyderabad", "28", "March 2024");
	}


}

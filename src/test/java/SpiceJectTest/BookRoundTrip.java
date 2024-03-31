package SpiceJectTest;

import org.testng.annotations.Test;

import Base.ProjectSpecifications;
import SpiceJetPages.HomePage;
import SpiceJetPages.SelectingTypeOfTripPage;

public class BookRundTrip extends ProjectSpecifications{

	HomePage HomePage;
	SelectingTypeOfTripPage book;
	

	@Test
	public void bookOneWayTicket() throws InterruptedException {
		book = new SelectingTypeOfTripPage(driver);
		book.roundTrip("Hyderabad", "Delhi", "27", "29", "March 2024");
		
	}
}

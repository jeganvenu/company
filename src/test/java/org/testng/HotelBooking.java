package org.testng;

import java.awt.AWTException;
import java.io.IOException;

import org.mvn.BaseClass;
import org.pom.BookHotelPage;
import org.pom.BookingConfirmationPage;
import org.pom.CancelBookingPage;
import org.pom.LoginPage;
import org.pom.SearchHotelPage;
import org.pom.SelectHotelPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HotelBooking extends BaseClass{
	
	@BeforeClass
	private void beforeClass() {
		chromeLaunch();
		getUrl("https://adactinhotelapp.com/index.php");
		maximize();

	}
	
	@AfterClass
	private void afterClass() {
		closeBrowser();

	}
	
	@Test
	private void bookHotel() throws IOException, InterruptedException, AWTException {
		
		LoginPage loginpage = new LoginPage();
		loginpage.login();
		
		SearchHotelPage searchHotelPage = new SearchHotelPage();
		searchHotelPage.verifySearchHotel();
		searchHotelPage.searchhotel(2, 1, 3, 1, 2, 3);
		
		SelectHotelPage selectHotelPage = new SelectHotelPage();
		selectHotelPage.verifySelectHotel();
		selectHotelPage.selectHotel();
		
		BookHotelPage bookHotelPage = new BookHotelPage();
		bookHotelPage.verifyBookHotel();
		bookHotelPage.bookHotel();
		
		Thread.sleep(6000);
		
		BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
		bookingConfirmationPage.bookingConfirmation();
		
		CancelBookingPage cancelBookingPage = new CancelBookingPage();
		cancelBookingPage.cancelBooking();
		cancelBookingPage.verifyBookingCancelled();
		
	}

}

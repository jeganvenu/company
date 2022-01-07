package org.pomexecution;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mvn.BaseClass;
import org.openqa.selenium.WebDriver;
import org.pom.BookHotelPage;
import org.pom.BookingConfirmationPage;
import org.pom.CancelBookingPage;
import org.pom.LoginPage;
import org.pom.SearchHotelPage;
import org.pom.SelectHotelPage;

public class PomExecution extends BaseClass{
	
static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
    chromeLaunch();
	getUrl("https://adactinhotelapp.com/index.php");
	maximize();
	}
	
	@Test
	public void booking() throws IOException, AWTException, InterruptedException {
		
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

package org.pom;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;
import org.mvn.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBookingPage extends BaseClass{
	
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement lnkItinerry;
	
	@FindBy(id="order_id_text")
	private WebElement orderid;
	
	@FindBy(id="search_hotel_id")
	private WebElement btngo;
	
	@FindBy(xpath="//input[contains(@name,'btn_id_')]")
	private WebElement btncancel;

	public WebElement getLnkItinerry() {
		return lnkItinerry;
	}

	public WebElement getOrderid() {
		return orderid;
	}

	public WebElement getBtngo() {
		return btngo;
	}

	public WebElement getBtncancel() {
		return btncancel;
	}
	
	public void verifyBookingCancelled() {
		WebElement txtcancel = findElementById("search_result_error");
		String cancel = getText(txtcancel);
		System.out.println(cancel);
		Assert.assertEquals("order id cancel or not", "The booking has been cancelled.", cancel);
		
	}
	
	public void cancelBooking() throws IOException, AWTException, InterruptedException {
		click(lnkItinerry);
		sendKeys(orderid, getData("hotel", 1, 8));
		click(btngo);
		click(btncancel);
		keyenter();
		Thread.sleep(3000);
		

	}

}

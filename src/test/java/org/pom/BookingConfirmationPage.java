package org.pom;

import java.io.FileOutputStream;
import java.io.IOException;

import org.mvn.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmationPage extends BaseClass{
	
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")
	private WebElement txtorderid;

	public WebElement getTxtorderid() {
		return txtorderid;
	}
	
	public void bookingConfirmation() throws IOException {
		
		String orderid = getAttributeValue(txtorderid);
		
		createCell(1, 8, orderid);
	
		
	}

}

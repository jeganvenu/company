package org.pom;

import java.io.IOException;

import org.junit.Assert;
import org.mvn.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass{
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement txtfirst;
	
	@FindBy(id="last_name")
	private WebElement txtlast;
	
	@FindBy(id="address")
	private WebElement txtaddress;
	
	@FindBy(id="cc_num")
	private WebElement txtcardno;
	
	@FindBy(id="cc_type")
	private WebElement dwncardtype;
	
	@FindBy(id="cc_exp_month")
	private WebElement dwnmonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement dwnyear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtcvv;
	
	@FindBy(id="book_now")
	private WebElement btnbook;

	public WebElement getTxtfirst() {
		return txtfirst;
	}

	public WebElement getTxtlast() {
		return txtlast;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getTxtcardno() {
		return txtcardno;
	}

	public WebElement getDwncardtype() {
		return dwncardtype;
	}

	public WebElement getDwnmonth() {
		return dwnmonth;
	}

	public WebElement getDwnyear() {
		return dwnyear;
	}

	public WebElement getTxtcvv() {
		return txtcvv;
	}

	public WebElement getBtnbook() {
		return btnbook;
	}
	
	public void verifyBookHotel() {
		WebElement txtbookhotel = findElementByXpath("//td[contains(text(),'Book A Hotel')]");
		String text3 = getText(txtbookhotel);
		Assert.assertEquals("verify booh hotel", "Book A Hotel", text3);
	}
	
	public void bookHotel() throws IOException {
		
		sendKeys(txtfirst, getData("hotel", 1, 2));
		sendKeys(txtlast, getData("hotel", 1, 3));
		sendKeys(txtaddress, getData("hotel", 1, 4));
		sendKeys(txtcardno, getData("hotel", 1, 5));
		selectOptionsByIndex(dwncardtype, 1);
		selectOptionsByIndex(dwnmonth, 5);
		selectOptionsByIndex(dwnyear, 3);
		sendKeys(txtcvv, getData("hotel", 1, 6));
		click(btnbook);
		
		

	}


}

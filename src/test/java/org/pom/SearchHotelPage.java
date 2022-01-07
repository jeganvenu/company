package org.pom;

import org.junit.Assert;
import org.mvn.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass{
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement dwnlocation;
	
	@FindBy(id="hotels")
	private WebElement dwnhotels;
	
	@FindBy(id="room_type")
	private WebElement dwnroomtype;
	
	@FindBy(id="room_nos")
	private WebElement dwnnoofrooms;
	
	@FindBy(id="adult_room")
	private WebElement dwnadultperroom;
	
	@FindBy(id="child_room")
	private WebElement dwnchildperroom;
	
	@FindBy(id="Submit")
	private WebElement btnsearch;

	public WebElement getDwnlocation() {
		return dwnlocation;
	}

	public WebElement getDwnhotels() {
		return dwnhotels;
	}

	public WebElement getDwnroomtype() {
		return dwnroomtype;
	}

	public WebElement getDwnnoofrooms() {
		return dwnnoofrooms;
	}

	public WebElement getDwnadultperroom() {
		return dwnadultperroom;
	}

	public WebElement getDwnchildperroom() {
		return dwnchildperroom;
	}

	public WebElement getBtnsearch() {
		return btnsearch;
	}
	
	public void verifySearchHotel() {
		WebElement txtsearchhotel = findElementByXpath("//td[contains(@class,'login_title')]");
		String text = getText(txtsearchhotel);
		Assert.assertEquals("verify search hotel", "Search Hotel (Fields marked with Red asterix (*) are mandatory)", text);
	}
	
	public void searchhotel(int location,int hotel,int roomtype,int noofroom,int adultperroom,int childperroom) {
		
		selectOptionsByIndex(dwnlocation, location);
		selectOptionsByIndex(dwnhotels, hotel);
		selectOptionsByIndex(dwnroomtype, roomtype);
		selectOptionsByIndex(dwnnoofrooms, noofroom);
		selectOptionsByIndex(dwnadultperroom, adultperroom);
		selectOptionsByIndex(dwnchildperroom, childperroom);
		click(btnsearch);

	}
	
	

}

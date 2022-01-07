package org.pom;

import org.junit.Assert;
import org.mvn.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass{
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement btnselect;
	
	@FindBy(id="continue")
	private WebElement btncontinue;

	public WebElement getBtnselect() {
		return btnselect;
	}

	public WebElement getBtncontinue() {
		return btncontinue;
	}

	public void verifySelectHotel() {
		WebElement txtselecthotel = findElementByXpath("//td[contains(text(),'Select Hotel')]");
		String text2 = getText(txtselecthotel);
		System.out.println(text2);
		Assert.assertEquals("verify select hotel", "Select Hotel", text2);

	}
	
	public void selectHotel() {
		
		click(btnselect);
		click(btncontinue);
		
	}
}

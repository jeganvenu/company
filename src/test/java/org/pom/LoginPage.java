package org.pom;

import java.io.IOException;

import org.mvn.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="username")
	private WebElement txtusername;
	
	@FindBy(id ="password")
	private WebElement txtpassword;
	
	@FindBy(id ="login")
	private WebElement btnlogin;

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}
	
	public void login() throws IOException{
		
		sendKeys(txtusername, getData("hotel", 1, 0));
		sendKeys(txtpassword, getData("hotel", 1, 1));
		click(btnlogin);

	}
	

}

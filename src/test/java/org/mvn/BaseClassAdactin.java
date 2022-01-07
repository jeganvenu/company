package org.mvn;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class BaseClassAdactin {
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass li = new BaseClass();
		li.chromeLaunch();
		li.getUrl("https://adactinhotelapp.com/index.php");
		li.maximize();
		
		WebElement txtuser = li.findElementById("username");
		String name = li.getData("hotel", 1, 0);
		li.sendKeys(txtuser, name);
		
		WebElement txtpass = li.findElementById("password");
		String pass = li.getData("hotel", 1, 1);
		li.sendKeys(txtpass, pass);
		
		WebElement btnlogin = li.findElementById("login");
		li.click(btnlogin);
		
		WebElement dwnloc = li.findElementById("location");
		li.selectOptionsByIndex(dwnloc, 2);
		
		WebElement dwnhotel = li.findElementById("hotels");
		li.selectOptionsByIndex(dwnhotel, 1);
		
		WebElement dwnroom = li.findElementById("room_type");
		li.selectOptionsByIndex(dwnroom, 0);
		
		WebElement dwnnoofroom = li.findElementById("room_nos");
		li.selectOptionsByIndex(dwnnoofroom, 5);
		
		WebElement dwnadult = li.findElementById("adult_room");
		li.selectOptionsByIndex(dwnadult, 2);
		
		WebElement dwnchild = li.findElementById("child_room");
		li.selectOptionsByIndex(dwnchild, 1);
		
		WebElement btnsubmit = li.findElementById("Submit");
		li.click(btnsubmit);
		
		Thread.sleep(3000);
		
		WebElement btnselect = li.findElementById("radiobutton_2");
		li.click(btnselect);
		
		WebElement btncontinue = li.findElementById("continue");
		li.click(btncontinue);
		
		Thread.sleep(3000);
		
		WebElement txtfirst = li.findElementById("first_name");
		String first = li.getData("hotel", 1, 2);
		li.sendKeys(txtfirst, first);
		
		WebElement txtlast = li.findElementById("last_name");
		String last = li.getData("hotel", 1, 3);
		li.sendKeys(txtlast, last);
		
		WebElement txtaddress = li.findElementById("address");
		String address = li.getData("hotel", 1, 4);
		li.sendKeys(txtaddress, address);
		
		WebElement txtcard = li.findElementById("cc_num");
		String card = li.getData("hotel", 1, 5);
		li.sendKeys(txtcard, card);
		
		WebElement cardtype = li.findElementById("cc_type");
		li.selectOptionsByIndex(cardtype, 1);
		
		WebElement dwnmonth = li.findElementById("cc_exp_month");
		li.selectOptionsByIndex(dwnmonth, 5);
		
		WebElement dwnyear = li.findElementById("cc_exp_year");
		li.selectOptionsByIndex(dwnyear, 5);
		
		WebElement txtcvv = li.findElementById("cc_cvv");
		String cvv = li.getData("hotel", 1, 6);
		li.sendKeys(txtcvv, card);
		
		WebElement btnbook = li.findElementById("book_now");
		li.click(btnbook);
		
		Thread.sleep(10000);
		
		WebElement txtfinal = li.findElementById("order_no");
		String text = li.getAttributeValue(txtfinal);
		System.out.println(text);
		
		WebElement btnlogout = li.findElementById("logout");
		li.click(btnlogout);
		
	}
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

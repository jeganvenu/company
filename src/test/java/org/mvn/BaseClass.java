package org.mvn;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	Actions actions; 
	
	public static void getUrl(String url) {
		driver.get(url);	
	}
	public static void closeBrowser() {
		driver.close();
	}
	public static void chromeLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public void createExcel() throws IOException {
		//File file = new File("C:\\Users\\jegan\\eclipse-workspace\\Company\\target");
		FileInputStream Stream = new FileInputStream("C:\\Users\\jegan\\eclipse-workspace\\Company\\target\\test.xlsx");
		Workbook workbook = new XSSFWorkbook(Stream);
		Sheet createSheet = workbook.createSheet("test");
		Row createRow = createSheet.createRow(0);
		Cell createCell = createRow.createCell(0);
	
	}
	
	public void createCell(int rows,int cells,String string) throws IOException {
		File file = new File("C:\\Users\\jegan\\eclipse-workspace\\Company\\target\\demo.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("hotel");
		Row row = sheet.getRow(rows);
		Cell cell = row.createCell(cells);
		cell.setCellValue(string);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);

	}
	
	public void keyenter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		

	}

	public static void maximize() {
		driver.manage().window().maximize();
	}
	public void sendKeys(WebElement element,String data) {
		element.sendKeys(data);
	}
	public void click(WebElement element) {
		element.click();
	}
	public WebElement findElementById(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}
	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name("attributevalue"));
		return element;
	}
	public WebElement findElementByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		return element;

	}
	public void type(WebElement element,String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].setAttribute('value',"+data+"", element);
	}
	public void mouseOver(WebElement element) {
		 actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void dragAndDrop(WebElement element1,WebElement element2) {
		 actions = new Actions(driver);
		actions.dragAndDrop(element1,element2).perform();
	}
	public void rightClick(WebElement element) {
		actions.contextClick(element);
	}
	public void doubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void simpleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void confirmAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public void promtAlert(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
		alert.accept();
	}
	public void navigateTo(String Url) {
		driver.navigate().to("Url");
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public void navigateForward() {
		driver.navigate().forward();
	}
	public void refresh() {
		driver.navigate().refresh();
	}
	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className("attributeValue"));
        return element;
	}
	public String getText(WebElement element) {
		String data1 = element.getText();
        return data1;
	}
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public String getAttibuteValue(WebElement element,String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}
	public String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	public void selectOptionsByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectOptionsByText(WebElement element,String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}
	public void selectByValue(WebElement element,String data) {
		Select select = new Select(element);
		select.selectByValue(data);
	}
	public TakesScreenshot takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		Object screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
        return screenshot;
	}
	public String parentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	public Set<String> childWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	public void switchFrameByIndex(int index) {
		driver.switchTo().frame(0);
	}
	public void switchFrameByName(String name) {
		driver.switchTo().frame(name);
	}
	public void switchFrameByWebElementRef(WebElement element) {
	      driver.switchTo().frame(element);
	}
	public void defaultFrame() {
		driver.switchTo().defaultContent();
	}
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	public void deselectByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.deselectByIndex(0);
	}
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	public boolean multiOptions(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	public String getData(String SheetName,int rownum,int cellnum) throws IOException {
		
		String data = null;
		File file = new File("C:\\Users\\jegan\\eclipse-workspace\\Company\\target\\demo.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int type = cell.getCellType();
		if (type==1) {
		  data = cell.getStringCellValue();
		}
		if (type==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				data = dateFormat.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l =(long)numericCellValue;
				data = String.valueOf(l);
			}
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

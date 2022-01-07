package org.mvn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Date {
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		WebElement dwnskills = driver.findElement(By.id("Skills"));
		Select select = new Select(dwnskills);
		
		List<WebElement> options = select.getOptions();
		
		File file = new File("C:\\Users\\jegan\\eclipse-workspace\\Company\\target\\base.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("demo1");
		
		for (int i = 0; i < options.size(); i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			
			WebElement element = options.get(i);
			String text = element.getText();
			cell.setCellValue(text);
			System.out.println(text);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		System.out.println("Done");
	}	
}

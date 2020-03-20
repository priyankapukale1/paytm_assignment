package com.genericlib;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonUtilities extends Driver {
	
	//Highlight the element

	public static void elementHighlighter(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) (getDriver());
		js.executeScript("arguments[0].style.border='3px solid BLUE';", getDriver().findElement(locator));
	}

	// Enter Text

	public static void enterValue(By locator, String val) {
		elementHighlighter(locator);
		getDriver().findElement(locator).sendKeys(val);
	}

	// click
	public static void performClick(By locator) {
		elementHighlighter(locator);
		getDriver().findElement(locator).click();
	}

	
	//Switch to Alert
	public static Alert switchToAlert(){
		Alert alt = getDriver().switchTo().alert();
		return alt;
	}
	
	//Normal Wait
	public static void normalWait(int time){
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Wait for Page load
	public static void waitForPageLoad(int time){
		getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	//Wait till element found
	public static void waitForElement(int time, By locator){
	elementHighlighter(locator);
	WebDriverWait wait = new WebDriverWait(getDriver(), time);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	


	//Get the data from the excel sheet

	public static String getTestData(String sheetName,int rowNo,int cellNo) throws Exception{
		FileInputStream  fis = new FileInputStream("src/test/resources/ProjectTestData/TestData.xlsx");
		Workbook  wb = WorkbookFactory.create(fis);
		Sheet  sh  = wb.getSheet(sheetName);
		Row  rw = sh.getRow(rowNo);
		String val  = rw.getCell(cellNo).getStringCellValue();
		return val;
	}
	
	
	//Quit Browser
	
	public static void quitBrowser(){
		getDriver().quit();
	}
	
	public static void CloseBrowser(){
		getDriver().close();
	}
	
}
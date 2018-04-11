package Actions;

import java.io.IOException;

import java.util.List;
import TestBase.TestBase;
import ExcelReader.ExcelXlsx;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action extends TestBase {

	public static void BrowserLanch() throws IOException, InterruptedException {
		ExcelXlsx.Connection("Configaration.xlsx", "Configaration");
		selectBrowser(ExcelXlsx.getData("b1"));
		mandatoryWait(5);
		navigate(ExcelXlsx.getData("b2"));
		ExcelXlsx.closeExcel();
	}

	public static WebElement getLocator(String keyWordType, String keyWordtValue)
			throws Exception {

		if (keyWordType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("class")) {
			return driver.findElement(By.className(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("tag")) {
			return driver.findElement(By.tagName(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("link")) {
			return driver.findElement(By.linkText(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("partiallink")) {
			return driver.findElement(By.partialLinkText(keyWordtValue));
		} else if (keyWordType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(keyWordtValue));
		} else
			log.info("Unknown element loacatorType  : "
					+ keyWordtValue);
			throw new Exception("Unknown element loacatorType  : "
					+ keyWordtValue);
		
		
	}

	public static List<WebElement> getLocators(String keyWordType,
			String keyWordValue) throws Exception {

		if (keyWordType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("class")) {
			return driver.findElements(By.className(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("tag")) {
			return driver.findElements(By.tagName(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("link")) {
			return driver.findElements(By.linkText(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("partiallink")) {
			return driver.findElements(By.partialLinkText(keyWordValue));
		} else if (keyWordType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(keyWordValue));
		} else
			log.info("Unknown element loacatorType  :"
					+ keyWordValue);
			throw new Exception("Unknown element loacatorType  :"
					+ keyWordValue);
		

	}

	public static void selectDropDown(String ElementName, String keywordType, String keywordvalue, 
			String value) throws Exception {

		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			Select s = new Select(getLocator(keywordType, keywordvalue));
			s.selectByValue(value);
			log.info("Selected : "+value+" : From dropdown  : " + ElementName);
			System.out.println("Selected : "+value+" : From dropdown  : " + ElementName);

		} else {
			log.info(" Unable to locate the element : " + ElementName);
			System.out.println(" Unable to locate the element : " + ElementName);
		}
	}

	public static void selectDropDown(String ElementName,String keywordType, String keywordvalue,
			int index) throws Exception {

		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			Select s = new Select(getLocator(keywordType, keywordvalue));
			s.selectByIndex(index);
			log.info("Selected : "+index+" : From dropdown  : " + ElementName);
			System.out.println("Selected : "+index+" : From dropdown  : " + ElementName);
		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}

	}

	public static void actionDropDown(String ElementName,String keywordType, String keywordvalue,
			String text) throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			Actions a = new Actions(driver);
			a.click(getLocator(keywordType, keywordvalue)).build().perform();
			a.sendKeys(text).build().perform();
			a.sendKeys(Keys.ENTER).build().perform();
			log.info("Selected : "+text+" : From dropdown  : " + ElementName);
			System.out.println("Selected : "+text+" : From dropdown  : " + ElementName);

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}

	}

	public static void actionClick(String ElementName,String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			Actions a = new Actions(driver);
			a.click(getLocator(keywordType, keywordvalue)).build().perform();
			log.info("Clicked on : "+ElementName+" : Element successfully ");
			System.out.println("Clicked on : "+ElementName+" : Element successfully ");

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}
	}

	public static void actionSendKeys(String ElementName,String keywordType, String keywordvalue,
			String text) throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			Actions a = new Actions(driver);
			a.click(getLocator(keywordType, keywordvalue)).build().perform();
			a.sendKeys(text).build().perform();
			log.info("Entered : " + text+ " : text in : "+ElementName+" : textbox Successfully ");
			System.out.println("Entered : " + text+ " : text in : "+ElementName+" : textbox Successfully ");

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}
	}

	public static void javaScriptClick(String ElementName,String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("Arguments[0].click();",
					getLocator(keywordType, keywordvalue));
			log.info("Clicked on : "+ElementName+" : Element successfully ");
			System.out.println("Clicked on : "+ElementName+" : Element successfully ");

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}

	}

	public static void click(String ElementName,String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			getLocator(keywordType, keywordvalue).click();
			log.info("Clicked on : "+ElementName+" : Element successfully ");
			System.out.println("Clicked on : "+ElementName+" : Element successfully ");

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}

	}

	public static void checkbox(String ElementName,String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			getLocator(keywordType, keywordvalue).click();
			log.info("Clicked on : "+ElementName+" : checkbox successfully ");
			System.out.println("Clicked on : "+ElementName+" : checkbox successfully ");

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}

	}

	public static void button(String ElementName,String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			getLocator(keywordType, keywordvalue).click();
			log.info("Clicked on : "+ElementName+" : button successfully ");
			System.out.println("Clicked on : "+ElementName+" : button successfully ");

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}

	}

	public static void link(String ElementName,String keywordType, String keywordvalue)
			throws Exception {

		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			getLocator(keywordType, keywordvalue).click();
			log.info("Clicked on : "+ElementName+" : link successfully ");
			System.out.println("Clicked on : "+ElementName+" : link successfully ");

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}

	}

	public static void textbox(String ElementName,String keywordType, String keywordvalue,
			String text) throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			getLocator(keywordType, keywordvalue).sendKeys(text);
			log.info("Entered : " + text+ " : text in : "+ElementName+" : textbox Successfully ");
			System.out.println("Entered : " + text+ " : text in : "+ElementName+" : textbox Successfully ");

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}

	}

	public static void toggle(String ElementName,String keywordType, String keywordvalue)
			throws Exception {
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			getLocator(keywordType, keywordvalue).click();
			log.info("Clicked on : "+ElementName+" : toggle successfully ");
			System.out.println("Clicked on : "+ElementName+" : toggle successfully ");

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}

	}

	public static String getElementText(String ElementName,String keywordType, String keywordvalue
			) throws Exception {
		String S = null;
		if (getLocator(keywordType, keywordvalue).isDisplayed()) {
			log.info("Identified element successfully : "+ ElementName);
			System.out.println("Identified element successfully : "+ ElementName);
			S= getLocator(keywordType, keywordvalue).getText();
			log.info("Text of the Element : "+ElementName+ " : is  : "+ S);
			System.out.println("Text of the Element : "+ElementName+ " : is  : "+ S);

		} else {
			log.info("Unable to locate the element : " + ElementName);
			System.out.println("Unable to locate the element : " + ElementName);
		}
		return S;
	}
	 
	public static void scrollByVisibleElement(String ElementName,String keywordType, String keywordvalue) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", getLocator(keywordType, keywordType));
		if (getLocator(keywordType, keywordType).isDisplayed()) {
			log.info("Page scrolled to Element Visible : "+ ElementName);
			System.out.println("Page scrolled to Element Visible : "+ ElementName);
				}
		else {
			log.info("Unable to scroll page for element visible : " + ElementName);
			System.out.println("Unable to scroll page for element visible : " + ElementName);
		}
	}
	
	public static void explecitWatiForPageLoad(String keywordType, String keywordvalue, int sec) {
		try {
			System.out.println("ExplecitWati for : " + getPageTittle()
					+ " page loading : " + sec +" Seconds");
			log.info("ExplecitWati for : " + getPageTittle()
					+ " page loading : " + sec +" Seconds");
			long startTime = System.currentTimeMillis();
			WebDriverWait wait = new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf(getLocator(keywordType, keywordvalue)));
			long totalTime = System.currentTimeMillis() - startTime;
			if (getLocator(keywordType, keywordvalue).isDisplayed()) {
				System.out.println("But " + getPageTittle() + " : page loaded compleatly in : " + totalTime+ " milliSeconds");
				log.info("But " + getPageTittle() + ": page loaded compleatly in : " + totalTime + " milliSeconds");				
			}
		} catch (Throwable error) {
			System.out.println("Timeout for :" + getPageTittle() + " : page load in " + sec +" Seconds");
			log.info("Timeout for :" + getPageTittle() + " : page load in " + sec +" Seconds");
		}
	}
	public static void explecitWatiForElement(String ElementName ,String keywordType, String keywordvalue, int sec) {
		try {
			System.out.println("ExplecitWati for : " + ElementName
					+ ": element loading : " + sec +" Seconds");
			log.info("ExplecitWati for : " + ElementName
					+ " element loading : " + sec +" Seconds");
			long startTime = System.currentTimeMillis();
			WebDriverWait wait = new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf(getLocator(keywordType, keywordvalue)));
			long totalTime = System.currentTimeMillis() - startTime;
			if (getLocator(keywordType, keywordvalue).isDisplayed()) {
				System.out.println("But " + ElementName + " : element loaded compleatly in : " + totalTime+ " milliSeconds");
				log.info("But " + ElementName + ": element loaded compleatly in : " + totalTime+ " milliSeconds");				
			}
		} catch (Throwable error) {
			System.out.println("Timeout for: " + ElementName + " : Element visible in" + sec +" Seconds");
		log.info("Timeout for: " + ElementName + " : Element visible in" + sec +" Seconds");
		}
	}

	
}

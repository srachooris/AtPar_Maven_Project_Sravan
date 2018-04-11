package TestBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestBase {
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestBase.class); 
	

	public static WebDriver selectBrowser(String browser) {
		log.info("Selected Browser is : " + browser);

		if (browser.toLowerCase().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(browser.toUpperCase()+ " : Browser selected ");
			System.out.println(browser + " : Browser opend successfully");
			log.info(browser.toUpperCase() + " : Browser opend successfully");
			driver.manage().window().maximize();
			System.out.println("Maximized " + browser.toUpperCase() + " :Browser");
			log.info("Maximized " + browser.toUpperCase() + ": Browser");
			return driver;
		} else if (browser.toLowerCase().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println(browser.toUpperCase()+ ": Selected ");
			System.out.println(browser.toUpperCase() + " : Browser opend successfully");
			log.info(browser.toUpperCase() + ":Browser opend successfully");
			driver.manage().window().maximize();
			System.out.println("Maximized " + browser.toUpperCase() + " : Browser");
			log.info("Maximized " + browser.toUpperCase() + ": Browser");
			return driver;
		} else if (browser.toLowerCase().equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\BrowserDrivers\\ie.exe");
			driver = new InternetExplorerDriver();
			System.out.println(browser.toUpperCase()+ ": Selected ");
			System.out.println(browser.toUpperCase() + " : Browser opend successfully");
			log.info(browser + ":Browser opend successfully");
			driver.manage().window().maximize();
			System.out.println("Maximized " + browser.toUpperCase() + " : Browser");
			log.info("Maximized " + browser.toUpperCase() + ": Browser");
			return driver;
		}
		return driver;

	}

	public static String getPageTittle() {	
		return driver.getTitle();
	}

	public static void implicitWaitForPageLoad(int sec) {
		System.out.println("ImplicitWait for : " + getPageTittle() + " page loading : "
				+ sec +" Seconds");
		log.info("ImplicitWait for :" + getPageTittle() + ": page loading "
				+ sec + " Seconds");
		try {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		} catch (Throwable error) {
			System.out.println("Timeout for: " + getPageTittle() + ": page load in" + sec +" Seconds");
			log.info("Timeout for" + getPageTittle() + "page load in" + sec +" Seconds");
		}
	}
	
	public static void implicitWaitForElement(String ElementName,int sec) {
		
		System.out.println("ImplicitWait for : " + ElementName + " : Element visible : "
				+ sec +" Seconds");
		log.info("ImplicitWait for :" + ElementName + ": Element visible : "
				+ sec + " Seconds");
		try {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
			} catch (Throwable error) {
			System.out.println("Timeout for: " + ElementName + " : Element visible in" + sec +" Seconds");
			log.info("Timeout for: " + ElementName + " : Element visible in" + sec +" Seconds");
		}
	}
	
	

	public static void mandatoryWait(int sec) throws InterruptedException {
			Thread.sleep(sec * 1000);	
	}

	public static String displayDateTime() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		return s.format(d);
	}

	public static String currentTime() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
		return s.format(d);
	}
	
	
	
	
	
	
	
	

	public static String currentDate() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		return s.format(d);
	}

	public static WebDriver navigate(String url) {
		driver.navigate().to(url);
		System.out.println("Browser navigated :  " + url + "  Successfully");
		return driver;
		
	}

	public static void closeBrowser() {
		driver.close();
		System.out.println("Browser closed successfully");
	}

	public static void quitBrowser() {
		driver.quit();
		System.out.println("Browser quit successfully");
	}
	public static void tabKey(int count) throws Exception{
		Robot robot = new Robot();  
		for(int i=1;i<=count;i++){
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}		
	}
	public static void enterKey(int count) throws Exception{
		Robot robot = new Robot();  
		for(int i=1;i<=count;i++){
			robot.keyPress(KeyEvent.VK_ENTER);	
			robot.keyRelease(KeyEvent.VK_ENTER);
		}		
	}
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	public static void pasteString() throws AWTException{
		 Robot robot = new Robot();
			
         robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         
	}
	
	public static void uploadFile(String fileLocation) {
        try {
        	setClipboardData(fileLocation); 
        	pasteString();
            log.info("File uploaded successfully : " + fileLocation);
            System.out.println("File uploaded successfully : " + fileLocation);
        } catch (Exception e) {
        	 log.info("Fail to  upload file : " + fileLocation);
             System.out.println("Fail to  upload file : " + fileLocation);
        }
	}
	
	
	
	public static void scrollHorizontal(int scrollValue) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+scrollValue+",0)");	
			log.info("Page scrolled by horizental : "+ scrollValue);
			System.out.println("Page scrolled by horizental : "+ scrollValue);
		
	}
	public static void scrollVertical(int scrollValue) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+scrollValue+")");
			
			log.info("Page scrolled by right horizental : "+ scrollValue);
			System.out.println("Unable to locate the element : " + scrollValue);
		
	}
	
	public static void scrollPageDown() throws Exception{
		Robot robot = new Robot();  
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		log.info("Page scrolled  up compleate");
		System.out.println("Page scrolled  up compleate");	
}
	
	public static void scrollPageUp() throws Exception{
		Robot robot = new Robot();  
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			log.info("Page scrolled  up compleate");
			System.out.println("Page scrolled  up compleate");	
	}

	public void onStart(ITestContext Result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult Result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext Result) {
		// TODO Auto-generated method stub
		
	}
	
	
}
	

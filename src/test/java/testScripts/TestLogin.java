package testScripts;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Actions.Action;
import ExcelReader.ExcelXlsx;
import TestBase.*;

@Listeners(CustomListener.Listener.class)	
public class TestLogin extends ExcelXlsx {

	@BeforeTest
	public void setUp() throws IOException, InterruptedException {
	//	Action.ExecutionStarts();
		Action.BrowserLanch();
		Action.mandatoryWait(3);
	}

	@Test(description = "Creating an Org ID with the test data mentioned in the sheet OrgGroupCreation")
	public void createOrgGroupID() throws Exception
	{
		log.info("Initiated Org Group ID creation method at: " + TestBase.displayDateTime());
		
		Connection("DataSetup_User_Org_Profile.xlsx", "LoginPage_LoginTab");
		
		Action.explecitWatiForElement(getData("D10"), getData("E10"), getData("F10"),30); //checking whether User ID field is visible or not
		
		Action.textbox(getData("D10"), getData("E10"), getData("F10"), getData("G10"));
		Action.textbox(getData("D11"), getData("E11"), getData("F11"), getData("G11"));
		System.out.println("\n Entered Credentials");
		
	Action.implicitWaitForElement(getData("F14"), 10);

	System.out.println("\n Waiting");
		Action.button(getData("D14"),getData("E14"), getData("F14"));
		
	log.info("Log in successful with Admin Credentials");
	}
	
		

	/*@AfterTest
	public void clsApp() {
	//	Action.ExecutionEnd();
		Action.closeBrowser();
	}
	*/
}

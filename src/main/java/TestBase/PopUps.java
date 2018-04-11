package TestBase;

import org.openqa.selenium.Alert;

public class PopUps extends TestBase {
	static Alert alert = driver.switchTo().alert();

	static String alertTitle = alert.getText();

	public static void alertBoxAccept() {
		log.info("Alert appeared with the title is:" + alertTitle);
		System.out.println("Alert appeared with the title is:" + alertTitle);

		alert.accept();
		System.out.println("Alert Accepted");
		log.info("Alert Accepted");

	}

	public static void alertBoxDismiss() {
		log.info("Alert appeared with the title is:" + alertTitle);
		System.out.println("Alert appeared with the title is:" + alertTitle);

		alert.dismiss();
		System.out.println("Alert Dismissed");
		log.info("Alert Dismissed");
	}

	public static void alertEnteringText(String inputText) {
		log.info("Alert appeared with the title is:" + alertTitle);
		System.out.println("Alert appeared with the title is:" + alertTitle);
		alert.sendKeys(inputText);
		System.out.println("Entered the text in the Prompt Popup");
		log.info("Entered the text in the Prompt Popup");
		alert.accept();
	}

}

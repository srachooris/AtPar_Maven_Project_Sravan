package TestBase;

import java.util.Set;

public class ManageWindow extends TestBase {

	static Set<String> NoOFWindows = driver.getWindowHandles();

	public static void closeAllChildWindows(String ParentTitle) {
		for (String EachWindow : NoOFWindows) {

			if (!EachWindow.equals(ParentTitle)) {
				driver.switchTo().window(EachWindow).close();
			}

		}
		driver.switchTo().window(ParentTitle);
		log.info("Closed all child windows");
		System.out.println("Closed all child windows");
	}

	public static void closeAllWindowsExceptParentAndChild(String ParentTitle, String ChildTitle) {
		for (String EachWindow : NoOFWindows) {

			if (!EachWindow.equals(ParentTitle)) {

				if (EachWindow.equals(ChildTitle)) {
					continue;
				}
				driver.switchTo().window(EachWindow).close();
			}

		}
		driver.switchTo().window(ChildTitle);
		log.info("Closed all windows except Parent and Child");
		System.out.println("Closed all windows except Parent and Child");
	}

	public static void navigateToParentWindow(String ParentTitle) {
		driver.switchTo().window(ParentTitle);
		log.info("Navigated to parentWindow : " + ParentTitle);
		System.out.println("Navigated to parentWindow : " + ParentTitle);

	}

	public static void navigateToChildWindow(String ChildTitle) {
		driver.switchTo().window(ChildTitle);
		log.info("Navigated to childWindow : " + ChildTitle);
		System.out.println("Navigated to childWindow : " + ChildTitle);
	}

}

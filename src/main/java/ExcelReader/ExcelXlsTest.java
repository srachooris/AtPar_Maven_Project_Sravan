package ExcelReader;

import java.io.IOException;

public class ExcelXlsTest {
	public static void main(String[] args) throws IOException {
		ExcelXls.Conncetion("Book123.xls", "Sheet1");

		ExcelXls.getData("W82");
		ExcelXls.closeExcel();

	}
}

package ExcelReader;

import java.io.IOException;

public class ExcelTest {
	public static void main(String[] args) throws IOException {
		ExcelXlsx.Connection("Configaration.xlsx", "Configaration");

		ExcelXlsx.getData("b1");
	//	ExcelXlsx.Sheet("Sheet2");
		ExcelXlsx.getData("b2");

		ExcelXlsx.closeExcel();

	}
}

package ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TestBase.TestBase;

public class ExcelXlsx {
	public static Logger log = Logger.getLogger(TestBase.class); 

	static String path = System.getProperty("user.dir")
			+ "\\TestData\\"; 
	static File file;
	static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static FileOutputStream fos;

	public static void Connection(String excelName, String sheetName)
			throws IOException {
		try {
			log.info("Opened Excel : " + excelName);
			System.out.println("Opened Excel : " + excelName);
			file = new File(path + excelName);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Connection(String excelName, int sheetNum)
			throws IOException {
		try {
			log.info("Opened Excel : " + excelName);
			System.out.println("Opened Excel : " + excelName);
			file = new File(path + excelName);

			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheetNum);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getData(String cellvalue) {
		String result;
		String[] a = (cellvalue).split("");
		if (a.length == 3) {
			a[1] = cellvalue.substring(1, 3);
			a[0] = cellvalue.substring(0, 1);
		}
		int pars = (Integer.parseInt(a[1]) - 1);
		result = new DataFormatter().formatCellValue(sheet.getRow(pars)
				.getCell(alphaNumeric.alpha(a[0].toUpperCase())));
		return result.trim();

	}

	public static void getData(int rowNo, int colNo) {
		try {
			System.out.println(sheet.getRow(rowNo).getCell(colNo)
					.getStringCellValue());
		} catch (Exception error) {
			error.printStackTrace();
			log.info("getData Fail Due to Null Data in Excel");
			System.out.println("getData Fail Due to Null Data in Excel");
		}
	}

	public static void setData(int rowNo, int colNo, String text)
			throws IOException {

		sheet.getRow(rowNo).createCell(colNo).setCellValue(text);
		fos = new FileOutputStream(file);
		wb.write(fos);

	}

	public static void rowCount() {
		int count = sheet.getRow(0).getLastCellNum();
		System.out.println(count);
	}

	public static void coloumCount() {
		int count = sheet.getColumnWidth(0);
		System.out.println(count);
	}

	public static void Sheet(String sheetname) throws IOException {
		try {
			sheet = wb.getSheet(sheetname);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void closeExcel() throws IOException {
		log.info("Closed  Excel");
		System.out.println("Closed  Excel");
		wb.close();

	}

	public static void saveExcel() throws IOException {
		try {
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

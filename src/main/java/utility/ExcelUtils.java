package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	// private static XSSFSheet ExcelWSheet;
	private static HSSFSheet ExcelWSheet;
	// private static XSSFWorkbook ExcelWBook;
	private static HSSFWorkbook ExcelWBook;
	// private static XSSFCell Cell;
	public static HSSFCell valueCell;
	public static HSSFCell keyCell;
	// private static XSSFRow Row;
	private static HSSFRow Row;
	public static Properties prop;
	public static HSSFCell lastCell;

	public static Map<String, Map<String, String>> setMapData() throws IOException {
		//"C://Users//Vijay//git//New_Test//New_Car_insurance//New_Insurance//src//main//resources//data//TestData.xls"
		//"D://Desk8//selenium//eclipse-workspace//New_Insurance//src//main//resources//data//TestData.xls"
		String path = "C://Users//shree//Downloads//PolicybossCar//src//main//resources//data//TestData.xls";
		FileInputStream ExcelFile = new FileInputStream(path);
		ExcelWBook = new HSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheetAt(0);
		//int lastRow = ExcelWSheet.getLastRowNum();
		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();
		Map<String, String> dataMap = new HashMap<String, String>();

		for (int i = 0; i <= 21; i++) {
			Row = ExcelWSheet.getRow(i);
			valueCell = Row.getCell(1);
			keyCell = Row.getCell(0);

			String value = valueCell.getStringCellValue().trim();
			String key = keyCell.getStringCellValue().trim();

			dataMap.put(key, value);
			excelFileMap.put("DataSheet", dataMap);

		}
		return excelFileMap;

	}

	public static String getMapData(String key) throws IOException {
		Map<String, String> m = setMapData().get("DataSheet");
		String value = m.get(key);
		return value;
	}

	public static void writeToExcel(Map<Integer, Map<Integer, List<String>>> qmap) throws Exception {
		String path = "C://Users//shree//Downloads//PolicybossCar//src//main//resources//data//TestData.xls";
		File file = new File(path);
		FileInputStream ExcelFile = new FileInputStream(file);
		ExcelWBook = new HSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheetAt(0);
		int rowCount = ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum();
		// int rowCount = 18;
		// Get the first row from the sheet
		//HSSFRow row = ExcelWSheet.getRow(0);
		// Create a new row and append it at last of sheet
		//HSSFRow newRow = ExcelWSheet.createRow(rowCount + 1);
		// Create a loop over the cell of newly created Row
		int qmapsize = qmap.size();
		// ExcelWSheet.shiftRows(18, 30,-1);
		// ExcelWSheet.
		for (int x = 22; x <= rowCount; x++) {
			HSSFRow removingRow = ExcelWSheet.getRow(x);
			if (removingRow != null) {
				ExcelWSheet.removeRow(removingRow);
			}

		}

		System.out.println("qmap size is " + qmapsize);
		for (int j = 0; j < qmapsize; j++) {
			// Fill data in row
			qmapsize = qmap.size();
			int createRowv = 22;
			for (Integer insdetails : qmap.keySet()) {
				if (!(insdetails == qmapsize - 1)) {
					Map<Integer, List<String>> qmapvalue = qmap.get(insdetails);
					List<String> qstringvalue = qmapvalue.get(insdetails);
					System.out.println("Key = " + insdetails + ", Value = " + "Insurance Co : " + qstringvalue.get(0)
							+ " Premium value is :  " + qstringvalue.get(1) + " No of Insurer is: "
							+ qstringvalue.get(2));
					// Create a new row and append it at last of sheet
					HSSFRow newRow1 = ExcelWSheet.createRow(createRowv);
					HSSFCell cell = newRow1.createCell(0);
					cell.setCellValue("Insurance Co : " + qstringvalue.get(0) + ":  " + "Premium value is "
							+ qstringvalue.get(1) + ":  " + qstringvalue.get(2));
					j++;
					rowCount++;
					createRowv++;
				} else {
					Map<Integer, List<String>> qmapvalue = qmap.get(insdetails);
					List<String> qstringvalue = qmapvalue.get(insdetails);
					// System.out.println("Key = " + insdetails + ", Value = " + "Insurance Co :
					// "+qstringvalue.get(0)+": "+qstringvalue.get(1)+": "+"Premium value is
					// "+qstringvalue.get(2));
					System.out.println("Key = " + insdetails + "  Crn value is :  " + qstringvalue.get(0)
							+ "  Make Model is " + qstringvalue.get(1) + " Rto is  :" + qstringvalue.get(2)
							+ "  No of insurer is :  " + qstringvalue.get(3));
					// Create a new row and append it at last of sheet
					HSSFRow newRow1 = ExcelWSheet.createRow(createRowv);
					HSSFCell cell = newRow1.createCell(0);
					cell.setCellValue("Crn value is :" + qstringvalue.get(0) + " Make Model is " + qstringvalue.get(1)
							+ "  Rto is  :" + qstringvalue.get(2) + "  No of insurer is :" + qstringvalue.get(3));
				}

			}

		}

		// Close input stream
		ExcelFile.close();
		// Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		// write data in the excel file
		ExcelWBook.write(outputStream);
		// close output stream
		outputStream.close();
	}

}

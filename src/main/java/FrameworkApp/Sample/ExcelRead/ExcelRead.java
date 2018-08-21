package FrameworkApp.Sample.ExcelRead;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import FrameworkApp.Sample.Common.Initilization;

public class ExcelRead {

	public static org.apache.poi.ss.usermodel.Sheet sh;
	public static org.apache.poi.ss.usermodel.Cell c;
	public static File f;
	public static FileInputStream fis;
	public static FileOutputStream fio;
	public static Workbook wb;

	public static Object[][] getData(String path, String filename, String Sheet)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		f = new File(Initilization.path + Initilization.filename);
		fis = new FileInputStream(f);
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(Initilization.Sheet);
		String readdata[][] = null;
		int row = sh.getLastRowNum();
		Row r = sh.getRow(0);
		int column = r.getLastCellNum();
		readdata = new String[row][column];
		int ci, cj;
		ci = 0;
		for (int i = 1; i <= row; ci++, i++) {
			cj = 0;
			for (int j = 0; j < column; cj++, j++) {

				readdata[ci][cj] = getCellData(i, j);
			}
		}

		return readdata;
	}

	public static String getCellData(int rowNum, int colNum) {
		c = sh.getRow(rowNum).getCell(colNum);

		if (c == null || c.getCellType() == c.CELL_TYPE_BLANK) {
			return "";
		} else {
			String CellData = c.getStringCellValue();
			return CellData;
		}
	}

	public void writeData(String path, String filename, String Sheet, String[] dataToWrite) throws IOException {
		sh = wb.getSheet(Initilization.Sheet);

		int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();

		Row r = sh.getRow(0);
		// Row neRow = sh.createRow(rowCount + 1);
		for (int k = 0; k < r.getLastCellNum(); k++) {
			c = r.createCell(k);
			c.setCellValue(dataToWrite[k]);
			fis.close();
			fio = new FileOutputStream(Initilization.path + Initilization.filename);
			wb.write(fio);
			fio.close();
		}
	}
}

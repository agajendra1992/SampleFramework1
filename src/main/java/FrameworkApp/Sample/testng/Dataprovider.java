package FrameworkApp.Sample.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import FrameworkApp.Sample.Common.Initilization;
import FrameworkApp.Sample.ExcelRead.ExcelRead;


public class Dataprovider {
	@DataProvider
public static Object[][] login() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] readdata = ExcelRead.getData(Initilization.path, Initilization.filename, Initilization.Sheet);
	return readdata;
	}
}

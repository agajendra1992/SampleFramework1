package FrameworkApp.Sample;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import FrameworkApp.Sample.Common.Common;
import FrameworkApp.Sample.Common.Initilization;
import FrameworkApp.Sample.ExcelRead.ExcelRead;
import FrameworkApp.Sample.PageObject.LoginObject;
import FrameworkApp.Sample.testng.Dataprovider;

public class LoginScript {
	private static final Logger logger = Logger.getLogger(LoginScript.class.getName());

	@Test(dataProvider = "login", dataProviderClass = Dataprovider.class)

	public void loginapp(String InputType, String user, String pwd, String ManaualStep, String Expected) throws InterruptedException, IOException {

		if (InputType.contains("N")) {

			logger.info("TestCase:" + ManaualStep);
			new LoginObject().LoginObject(user, pwd);
			new LoginObject().Loginbutton().click();
			new Common().scriptpause(10);
			new Common().waitElementTobevisible(new LoginObject().LoginErrorMessgae(), 10);

			if (Expected.trim().toUpperCase().equals(new LoginObject().LoginErrorMessgae().getText().trim().toUpperCase())) {
				logger.assertLog(true, Expected);
				String[] dataToWrite = { "PASS" };

				new ExcelRead().writeData(Initilization.path, Initilization.filename, Initilization.Sheet, dataToWrite);
			} else {
				logger.assertLog(false, Expected);
				String[] dataToWrite = { "FAIL" };
/*				new ExcelRead().writeData(Initilization.path, Initilization.filename, Initilization.Sheet, dataToWrite);
*/			}

		} else {
			new LoginObject().LoginObject(user, pwd);
			new LoginObject().Loginbutton().click();
			new Common().scriptpause(10);
			new LoginObject().waitElementTobevisible(new LoginObject().LoginSuccesMessage(), 5);

			logger.info("TestCase" + ManaualStep);

			if (Expected.trim().toUpperCase().equals(new LoginObject().LoginSuccesMessage().getText().trim().toUpperCase())) {
				logger.assertLog(true, Expected);
				String[] dataToWrite = { "PASS" };

/*				new ExcelRead().writeData(Initilization.path, Initilization.filename, Initilization.Sheet, dataToWrite);
*/
			} else {
				logger.assertLog(false, Expected);
				String[] dataToWrite = { "FAIL" };
/**/			}
		}

	}
}

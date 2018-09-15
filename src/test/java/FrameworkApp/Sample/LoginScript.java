package FrameworkApp.Sample;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import FrameworkApp.Sample.Common.Common;
import FrameworkApp.Sample.PageObject.LoginObject;
import FrameworkApp.Sample.Report.ReportUtil;
import FrameworkApp.Sample.testng.Dataprovider;

public class LoginScript {
	private static final Logger logger = Logger.getLogger(LoginScript.class.getName());

	@Test(dataProvider = "login", dataProviderClass = Dataprovider.class)

	public void loginapp(String InputType, String user, String pwd, String ManaualStep, String Expected) throws InterruptedException, IOException {
		ReportUtil.startSuite("LoginSuite");

		if (InputType.contains("N")) {

			logger.info("TestCase:" + ManaualStep);
			new LoginObject().LoginObject(user, pwd);
			new LoginObject().Loginbutton().click();
			new Common().scriptpause(10);
			new Common().waitElementTobevisible(new LoginObject().LoginErrorMessgae(), 10);

			if (Expected.trim().toUpperCase().equals(new LoginObject().LoginErrorMessgae().getText().trim().toUpperCase())) {
				logger.assertLog(true, Expected);

				new ReportUtil().addKeyword(ManaualStep, Expected, "Pass", null);
				ReportUtil.addTestCase("Login Validation", Common.now("dd.MMMM.yyyy hh.mm.ss aaa"), Common.now("dd.MMMM.yyyy hh.mm.ss aaa"), "PASS");

			} else {
				logger.assertLog(false, Expected);
				new ReportUtil().addKeyword(ManaualStep, Expected, "Fail", null);
				ReportUtil.addTestCase("Login Validation", Common.now("dd.MMMM.yyyy hh.mm.ss aaa"), Common.now("dd.MMMM.yyyy hh.mm.ss aaa"), "FAIL");

			}

		} else {
			new LoginObject().LoginObject(user, pwd);
			new LoginObject().Loginbutton().click();
			new Common().scriptpause(10);
			new LoginObject().waitElementTobevisible(new LoginObject().LoginSuccesMessage(), 5);

			logger.info("TestCase" + ManaualStep);

			if (Expected.trim().toUpperCase().equals(new LoginObject().LoginSuccesMessage().getText().trim().toUpperCase())) {
				logger.assertLog(true, Expected);
				new ReportUtil().addKeyword(ManaualStep, Expected, "Pass", null);
				ReportUtil.addTestCase("Login Validation", Common.now("dd.MMMM.yyyy hh.mm.ss aaa"), Common.now("dd.MMMM.yyyy hh.mm.ss aaa"), "PASS");

			} else {
				logger.assertLog(false, Expected);
				new ReportUtil().addKeyword(ManaualStep, Expected, "Fail", null);
				ReportUtil.addTestCase("Login Validation", Common.now("dd.MMMM.yyyy hh.mm.ss aaa"), Common.now("dd.MMMM.yyyy hh.mm.ss aaa"), "FAIL");

			}
		}

	}
}

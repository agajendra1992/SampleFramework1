package FrameworkApp.Sample;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import FrameworkApp.Sample.Common.Common;
import FrameworkApp.Sample.PageObject.LoginObject;
import FrameworkApp.Sample.testng.Dataprovider;

public class LoginScript {
	private static final Logger logger = Logger.getLogger(LoginScript.class.getName());

	@Test(dataProvider = "login", dataProviderClass = Dataprovider.class)

	public void loginapp(String user, String pwd) {
		new Common().loadlog();

		logger.info("Login Validation Started");
		new LoginObject().LoginObject(user, pwd);
		logger.info("Login Validation Ended");
	}
}

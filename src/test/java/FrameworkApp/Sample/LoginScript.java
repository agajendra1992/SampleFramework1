package FrameworkApp.Sample;

import org.testng.annotations.Test;

import FrameworkApp.Sample.PageObject.LoginObject;
import FrameworkApp.Sample.testng.Dataprovider;

public class LoginScript {

	@Test(dataProvider = "login", dataProviderClass = Dataprovider.class)

	public void loginapp(String user, String pwd) {
		new LoginObject().LoginObject(user, pwd);

	}
}

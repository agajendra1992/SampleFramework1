package FrameworkApp.Sample;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import FrameworkApp.Sample.Common.Common;
import FrameworkApp.Sample.log.Log;

public class LaunchApplication {

	@BeforeSuite
	public void launchapp() {
		Log.startTestCase("TEST CASE STARTED");
		DOMConfigurator.configure("log4j.xml");
		// c.closoalltbrowser();
		new Common().launchbrowser("chrome");
		Reporter.log("Browser is Launched");
		Log.info("Browser is Launched");
		new Common().windowmaximize();
		Log.info("Browser is Maximized");
		new Common().geturl();
		Log.info("Url is Loaded in Browser");

	}

	public void Login() {
		Log.info("Infor Application ");
	}

	@AfterSuite
	public void clsbrowser() {
		Log.info("Browser is Closed");
		new Common().closocurrentbrowser();
		Log.endTestCase("END TEST CASES");
	}

}

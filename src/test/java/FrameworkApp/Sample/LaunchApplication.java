package FrameworkApp.Sample;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import FrameworkApp.Sample.Common.Common;
import FrameworkApp.Sample.log.Log;

public class LaunchApplication {
	private static final Logger logger = Logger.getLogger(LaunchApplication.class.getName());

	@BeforeSuite
	public void launchapp() {
		new Common().loadlog();
		Log.startTestCase("TEST CASE STARTED");
		// c.closoalltbrowser();
		new Common().launchbrowser("chrome");
		logger.info("Browser is Launched");
		new Common().windowmaximize();
		logger.info("Browser is Maximized");
		new Common().geturl();
		logger.info("Url is Loaded in Browser");

	}

	@AfterSuite
	public void clsbrowser() {
		logger.info("Browser is Closed");
		new Common().closocurrentbrowser();
		Log.endTestCase("END TEST CASES");
	}

}

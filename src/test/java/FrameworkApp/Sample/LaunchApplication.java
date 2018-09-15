package FrameworkApp.Sample;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import FrameworkApp.Sample.Common.Common;
import FrameworkApp.Sample.Report.ReportUtil;
import FrameworkApp.Sample.log.Log;

public class LaunchApplication {
	private static final Logger logger = Logger.getLogger(LaunchApplication.class.getName());

	@BeforeSuite
	public void launchapp() {
		String startTime = Common.now("dd.MMMM.yyyy hh.mm.ss aaa");
		ReportUtil.startTesting(System.getProperty("user.dir") + "//src/main/java/FrameworkApp/Sample/Report//index.html", startTime, "Test", "1.5");
		new Common().loadlog();
		Log.startTestCase("TEST CASE STARTED");
		// new Common().closoalltbrowser();
		new Common().launchbrowser("chrome");
		Reporter.log("Browser is Launched");
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
		ReportUtil.endSuite();
		ReportUtil.updateEndTime(Common.now("dd.MMMM.yyyy hh.mm.ss aaa"));
	
		Log.endTestCase("END TEST CASES");
		}

}

package FrameworkApp.Sample.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Initilization {

	public static WebDriver driver;
	public static WebElement ele;
	public static String path = System.getProperty("user.dir") + "/src/main/java/FrameworkApp/Sample/Data/";
	public static String filename = "Actitime.xlsx";
	public static String Sheet = "Login";
	public static String chromewebDriverValue = System.getProperty("user.dir")
			+ "/target/tmp_webdrivers/chromedriver-windows-32bit.exe";
	public static String iewebDriverValue = System.getProperty("user.dir")
			+ "/target/tmp_webdrivers/internetexplorerdriver-windows-32bit.exe";
	public static String firefoxwebDriverValue = System.getProperty("user.dir")
			+ "/target/tmp_webdrivers/geckodriver-windows-32bit.exe";
	public static String url = "http://192.168.0.5:8080/login.do";

}

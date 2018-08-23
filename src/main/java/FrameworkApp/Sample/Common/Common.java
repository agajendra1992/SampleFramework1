package FrameworkApp.Sample.Common;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	private static final Logger logger = Logger.getLogger(Common.class.getName());

	public void launchbrowser(String Browser) {
		if (Browser.equalsIgnoreCase("Firefox") || ((Browser.equalsIgnoreCase("FF")))) {
			System.setProperty("webdriver.gecko.driver", Initilization.firefoxwebDriverValue);
			Initilization.driver = new FirefoxDriver();
		}

		else if (Browser.equalsIgnoreCase("chrome") || ((Browser.equalsIgnoreCase("CHROME")))) {
			System.setProperty("webdriver.chrome.driver", Initilization.chromewebDriverValue);
			Initilization.driver = new ChromeDriver();
		}

		else if (Browser.equalsIgnoreCase("InternetExplorer") || ((Browser.equalsIgnoreCase("IE")))) {
			System.setProperty("webdriver.ie.driver", Initilization.iewebDriverValue);
			Initilization.driver = new InternetExplorerDriver();
		} else {
			System.out.println("Given Browser " + Browser + "not available to run");
		}
	}

	public void windowmaximize() {
		Initilization.driver.manage().window().maximize();
	}

	public void geturl() {
		Initilization.driver.get(Initilization.url);
	}

	public void waitPageload(int i) {
		Initilization.driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}

	public WebElement waitElementTobeLoad(WebElement ele, int i1) {
		WebDriverWait wait = new WebDriverWait(Initilization.driver, i1);
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public WebElement waitElementTobevisible(WebElement ele, int i1) {
		WebDriverWait wait = new WebDriverWait(Initilization.driver, i1);
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public Select Selectdropdown() {
		Select select = new Select(Initilization.ele);
		return select;
	}

	public Actions Mousehover() {
		Actions action = new Actions(Initilization.driver);
		return action;
	}

	public void closocurrentbrowser() {
		Initilization.driver.close();
	}

	public void closoalltbrowser() {
		Initilization.driver.quit();
	}

	public void loadlog() {
		String log4jConfPath = System.getProperty("user.dir") + "\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public void scriptpause(int i) throws InterruptedException {
	Thread.sleep(i);
}
}

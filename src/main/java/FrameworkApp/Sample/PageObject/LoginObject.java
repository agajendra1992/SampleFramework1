package FrameworkApp.Sample.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import FrameworkApp.Sample.Common.Common;
import FrameworkApp.Sample.Common.Initilization;

public class LoginObject extends Common {

	public void LoginObject(String username, String password) {
		Initilization.driver.findElement(By.id("username")).clear();
		Initilization.driver.findElement(By.id("username")).sendKeys(username);
		Initilization.driver.findElement(By.name("pwd")).clear();
		Initilization.driver.findElement(By.name("pwd")).sendKeys(password);

	}

	public WebElement LoginErrorMessgae() {

		return Initilization.driver.findElement(By.xpath("//span[contains(.,'Username or Password is invalid. Please try again.')]"));
	}

	public WebElement LoginSuccesMessage() {
		return Initilization.driver.findElement(By.linkText("Logout"));

	}

	public WebElement Loginbutton() {
		return Initilization.driver.findElement(By.id("loginButton"));
	}
}

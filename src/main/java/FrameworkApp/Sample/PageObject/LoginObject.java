package FrameworkApp.Sample.PageObject;

import org.openqa.selenium.By;

import FrameworkApp.Sample.Common.Common;
import FrameworkApp.Sample.Common.Initilization;

public class LoginObject extends Common {

	public void LoginObject(String username, String password) {
		Initilization.driver.findElement(By.id("username")).clear();
		Initilization.driver.findElement(By.id("username")).sendKeys(username);
		Initilization.driver.findElement(By.name("pwd")).clear();
		Initilization.driver.findElement(By.name("pwd")).sendKeys(password);
		Initilization.driver.findElement(By.id("loginButton")).click();

	}

}

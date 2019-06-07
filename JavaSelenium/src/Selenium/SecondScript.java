package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SecondScript {

	public static void main(String[] args) {

		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://www.bing.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("Bing")) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Title Not Matched");
		}
	}
}

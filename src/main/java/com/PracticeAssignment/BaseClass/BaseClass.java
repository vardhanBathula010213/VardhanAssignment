package com.PracticeAssignment.BaseClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.PracticeAssignment.Utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Logger logger;
	public static WebDriver driver;
	public String AssignmentTestDataPath = "src\\test\\resources\\TestData\\AssignmentTestData\\Login.json";
	
	public void setup() {
		logger = Logger.getLogger("PracticeAssignment");
		PropertyConfigurator.configure("log4j.properties");
	}

	public void initilization() throws Exception {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.get(Utilities.getStringDataFromJsonArray(AssignmentTestDataPath, "LoginPagetestData", "url"));
	}
}
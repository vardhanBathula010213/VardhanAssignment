package com.PractiseAssignment.Hooks;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.PracticeAssignment.BaseClass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		// validate if scenario has failed
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}

	@Before
	public void browserLaunch() throws Exception {
		initilization();	
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
	
}

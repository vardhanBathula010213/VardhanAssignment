package com.PractiseAssignments.TestRunners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		features= {"src\\test\\resources\\Features"},
		glue= {"com.PracticeAssignment.StepDefinitions","com.PractiseAssignment.Hooks"},
		plugin= {"pretty:target/cucumber_pretty.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false,
		monochrome=true,
		publish = true,
		tags = "@login"
		)

public class RunnerClass {

}

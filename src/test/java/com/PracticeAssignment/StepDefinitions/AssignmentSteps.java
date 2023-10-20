package com.PracticeAssignment.StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.PracticeAssignment.BaseClass.BaseClass;
import com.PracticeAssignment.PageObjects.AssignementPageObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.cucumber.java.en.*;

public class AssignmentSteps extends BaseClass{
	AssignementPageObject assignementPageObject = new AssignementPageObject();
	
	@Given("User is on dynamic web page")
	public void navigatingIntoDynamicTablePage() {
		setup();
		assignementPageObject.verificationOfPageTitle();
		logger.info("User is on dynamic web page");
	}
	
	@When("User able to upload data and refresh the table")
	public void insertTableData() {
		try {
			assignementPageObject.clickOnTableDataBtn();
			assignementPageObject.insertTableData();
			assignementPageObject.clickOnRefreshTableBtn();
			logger.info("User uploaded the data");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
    @Then("User able to verify table data")
	public void verificationOfInsertedTableData() {
    	assignementPageObject.verificationOfData();
    	logger.info("User verified the table data");
    }
}
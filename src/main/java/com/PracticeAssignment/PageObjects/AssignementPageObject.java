package com.PracticeAssignment.PageObjects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.PracticeAssignment.BaseClass.BaseClass;
import com.PracticeAssignment.Utilities.Utilities;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.Assert;

public class AssignementPageObject extends BaseClass{
	
	final String PageTitle = "//h1[text()=\"Dynamic HTML TABLE Tag\"]";
	final String TableDataBtn = "//summary[text()=\"Table Data\"]";
	final String TableDataTextArea = "//textarea[@id=\"jsondata\"]";
	final String RefreshTableBtn = "//button[@id=\"refreshtable\"]";
	public static String path = "src\\test\\resources\\TestData\\AssignmentTestData\\TableData.json";
	
	@FindBy(xpath = PageTitle)
	WebElement pageTitle;
	
	@FindBy(xpath = TableDataBtn)
	WebElement tableDataBtn;
	
	@FindBy(xpath = TableDataTextArea)
	WebElement tableDataTextArea;
	
	@FindBy(xpath = RefreshTableBtn)
	WebElement refreshTableBtn;
	
	public AssignementPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	public void verificationOfPageTitle() {
		try {
			String actualPageTitle = Utilities.getStringDataFromJsonArray(AssignmentTestDataPath, "LoginPagetestData", "pageTitle");
			String expectedPageTitle = pageTitle.getText();
			Assert.assertEquals(expectedPageTitle, actualPageTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnTableDataBtn() throws InterruptedException {
		tableDataBtn.click();
	}
	
	public void insertTableData() {
		tableDataTextArea.sendKeys(Keys.CONTROL+ "a");
		tableDataTextArea.sendKeys(Keys.DELETE);
		String path1 = new File(path).getAbsolutePath();
		String jsonData = readJSONFromFile(path1);
		tableDataTextArea.sendKeys(jsonData);
	}
	
	 public static String readJSONFromFile(String filePath) {
	        String jsonData = "";
	        try {
	            jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return jsonData;
	    }
	 
	public void clickOnRefreshTableBtn(){
		refreshTableBtn.click();
	}

	public void verificationOfData(){
	try {
		WebElement table = driver.findElement(By.id("dynamictable"));
	    String tableData = table.getText();
		String path1 = new File(path).getAbsolutePath();
     ObjectMapper objectMapper = new ObjectMapper();
     List<Map<String, Object>> jsonData;
		jsonData = objectMapper.readValue(new File(path), new TypeReference<List<Map<String, Object>>>() {});
		 for (Map<String, Object> entry : jsonData) {
	         String name = (String) entry.get("name");
	    	 boolean nameExist = tableData.contains(name);
	         Assert.assertEquals(true, nameExist);
	         String age = entry.get("age").toString();
	         boolean ageExist = tableData.contains(age);
	         Assert.assertEquals(true, ageExist);
	         String gender = (String) entry.get("gender");
	         boolean genderExist = tableData.contains(gender);
	         Assert.assertEquals(true, genderExist);
	     }
	} catch (Exception e) {
		e.printStackTrace();
	} 
	}
}
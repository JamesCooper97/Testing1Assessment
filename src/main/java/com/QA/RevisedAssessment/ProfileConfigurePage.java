package com.QA.RevisedAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileConfigurePage {
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/table/tbody/tr[1]/td[3]/input")
	private WebElement name;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form")
	private WebElement saveForm;
	
	public void changeName(String keys) {
		name.clear();
		name.sendKeys(keys);
	}
	
	public void submitForm() {
		saveForm.submit();
	}
}

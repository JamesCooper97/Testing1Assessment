package com.QA.RevisedAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	@FindBy(xpath="//*[@id=\"j_username\"]")
	private WebElement user;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	
	@FindBy(id = "remember_me")
	private WebElement box;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/div/form")
	private WebElement form;
	
	public void inputUser(String keys) {
		user.sendKeys(keys);
	}
	
	public void inputPassword(String keys) {
		password.sendKeys(keys);
	}
	
	public void tickBox() {
		box.click();
	}
	
	public void submitForm() {
		form.submit();
	}
}

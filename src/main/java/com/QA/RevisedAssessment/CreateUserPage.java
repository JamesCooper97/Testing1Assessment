package com.QA.RevisedAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullName;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form")
	private WebElement createUserButton;
	
	public void addUsername(String keys) {
		username.sendKeys(keys);
	}
	
	public void addPassword(String keys) {
		password.sendKeys(keys);
	}
	
	public void addConfirmPassword(String keys) {
		confirmPassword.sendKeys(keys);
	}
	
	public void addFullName(String keys) {
		fullName.sendKeys(keys);
	}
	
	public void clickCreateUser() {
		createUserButton.submit();;
	}
}

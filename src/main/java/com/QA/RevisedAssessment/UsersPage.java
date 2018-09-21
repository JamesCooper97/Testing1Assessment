package com.QA.RevisedAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class UsersPage {
	@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[3]/td[4]/a[2]")
	private WebElement delete;
	
	public void clickUser(WebElement user) {
		user.click();
	}
	
	public void deleteUser() {
		delete.click();
	}
	
}

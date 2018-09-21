package com.QA.RevisedAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configure;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[2]")
	private WebElement id;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/h1")
	private WebElement name;
	
	public void clickConfigure() {
		configure.click();
	}
	
	public String getId(WebDriver driver) {
		String username = id.getText().substring(17);
		return username;
	}
	
	public String getName(WebDriver driver) {
		String Name = name.getText();
		return Name;
	}

}

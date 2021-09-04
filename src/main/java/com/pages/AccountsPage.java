package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;

	// 1. Locators
	private By accountsections = By.cssSelector("div#center_column span");

	// 2. Constructor

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Actions

	public int getAccountSectionCount() {

		return driver.findElements(accountsections).size();
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public List<String> getAccountSectionsList() {
		List<String> accountList = new ArrayList<String>();
		List<WebElement> accountHeaderLsit = driver.findElements(accountsections);
		for (WebElement e : accountHeaderLsit) {
			String text = e.getText();
			System.out.println(text);
			accountList.add(text);
		}
		return accountList;
	}

}

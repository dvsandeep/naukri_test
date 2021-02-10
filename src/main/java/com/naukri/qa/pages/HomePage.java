/**
 * 
 */
package com.naukri.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.base.TestBase;

public class HomePage extends TestBase {

	HomePage homepage;
	UpdatePage update;

	// Home Page Elements
	
	@FindBy(xpath="//div[starts-with(@title, 'vinay')]")
	WebElement usernamelabel;

	@FindBy(xpath = "//div[text()='UPDATE PROFILE']")
	WebElement UpdateButton;
	
	@FindBy(xpath="//button[contains (text(), 'SEARCH')]")
	WebElement SearchButton;

	public HomePage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	// HomePage class methods

	public String homepageconfrimation() {
		return driver.getTitle();
	}

	public UpdatePage updateprofile_button() throws Exception {
		UpdateButton.click();
		return new UpdatePage();
	}

}

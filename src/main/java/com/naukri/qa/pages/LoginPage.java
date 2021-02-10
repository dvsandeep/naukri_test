/**
 * 
 */
package com.naukri.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.base.TestBase;

/**
 * @author vinay
 *
 */
public class LoginPage extends TestBase{
	
	

	HomePage homepage;
	
	
	//Page Factory - OR
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement Login;
	
	@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//div[@id='root']/div/div/a/img")
	WebElement logo;
	
	@FindBy(xpath="//input[@placeholder='Skills, Designations, Companies']")
	WebElement skills;
	
	@FindBy(xpath="//input[@name='location']")
	WebElement location;
	
	@FindBy(xpath="//div[@class='search-btn']/button")
	WebElement SearchButton;
	
	
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public String validateloginpagetitle()
	{
		return driver.getTitle();
	}

	public void login()
	{
		Login.click();
	
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean NaukriImageTest()
	{
		return logo.isDisplayed();
	}
	
	
	/**
	 * 
	 * @param un
	 * @param pwd
	 * @return
	 * @throws Exception
	 */

	
	public HomePage loginnaukri(String un, String pwd) throws Exception
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		
		return new HomePage();
	}
	
	public void SearchSkills()
	{
		skills.sendKeys("selenium webdriver");
		location.sendKeys("Hyderabad");
		SearchButton.click();
	}

	
}



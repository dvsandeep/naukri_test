package com.naukri.qa.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.HomePage;
import com.naukri.qa.pages.LoginPage;
import com.naukri.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil util;

	public LoginPageTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {

		initialization();
		loginpage = new LoginPage();
		util = new TestUtil();
		util.switch_window();

		// util.switch_window();
		// util.handlenotification();
		// return loginpage;
	}

	@Test(priority = 1, enabled= false)
	public void loginpage() throws Exception {
		String title = loginpage.validateloginpagetitle();
		Assert.assertEquals(title, "Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com");
	}

	@Test(priority = 2, enabled=false)
	public void logotest() {
		boolean flag = loginpage.NaukriImageTest();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void search() throws Exception {
		loginpage.SearchSkills();
		//util.handlenotification();
	}

	@Test(priority = 4, enabled= false)
	public void loginTest() throws Exception {
		loginpage.login();
		homepage = loginpage.loginnaukri(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		// return new HomePage();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

package com.naukri.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.HomePage;
import com.naukri.qa.pages.LoginPage;
import com.naukri.qa.pages.UpdatePage;
import com.naukri.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	UpdatePage update;
	TestUtil util;

	public HomePageTest() throws Exception {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		loginpage = new LoginPage();
		util = new TestUtil();
		util.switch_window();
		loginpage.login();
		homepage = new HomePage();
		homepage = loginpage.loginnaukri(prop.getProperty("username"), prop.getProperty("password"));
		update = homepage.updateprofile_button();

	}

//	@Test(priority=1)
//	public void login() throws Exception
//	{
//		loginpage.login();
//		homepage=new HomePage();
//		homepage=loginpage.loginnaukri(prop.getProperty("username"), prop.getProperty("password"));
//		update=homepage.updateprofile_button();
//	}


	@Test(priority = 1)
	public void verifyhomepagelogo() throws Exception {
		homepage.homepageconfrimation();
		String pagetitle = homepage.homepageconfrimation();
		System.out.println(pagetitle);
		Assert.assertEquals(pagetitle, "Home | Mynaukri");
		}
	
	
//	@AfterMethod
//	public void teardown()
//	{
//		driver.quit();
//	}

}

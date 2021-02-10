/**
 * 
 */
package com.naukri.qa.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.LoginPage;

/**
 * @author vinay
 *
 */
public class TestUtil extends TestBase {

	LoginPage loginpage;
	
	public TestUtil() throws Exception {
		super();
	}

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 50;


	public LoginPage switch_window() {
		
		//System.out.println(driver.getCurrentUrl());
		
		String parentWindowID = driver.getWindowHandle();
       //System.out.println(parentWindowID);

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

	//String childWindowID;

		while (it.hasNext()) {
		String childWindowID = it.next().toString();
			System.out.println(childWindowID);

		if (!parentWindowID.equals(childWindowID)) {
				driver.switchTo().window(childWindowID);
				driver.close();
				//driver.switchTo().window(parentWindowID);
			}

			driver.switchTo().window(parentWindowID);
		}
		return loginpage;
	}
  



	public void handlenotification() throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		new ChromeDriver(options);

	}

	}

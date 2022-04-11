package com.mco.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mco.base.TestBase;
import com.mco.pages.HomePage;
import com.mco.pages.LoginPage;



public class LoginPageTest extends TestBase{
	
	static LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod(groups = "Main Functionality")
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@Test (priority = 1, groups = "UI Elements")
	public void loginPageTitleTest() {
		String title = loginPage.validatePageTitle();
		System.out.println("Object Found :"+title);
		Assert.assertEquals(title, "WildFire Cart", "Title of \"WildFire Cart\" Didnot found");
	}

	@Test (priority = 2, groups = "UI Elements")
	public void loginLogoTest() {
		boolean logo = loginPage.validateLoginLogoImage();
		if(logo==true) {
			System.out.println("Login Logo Image Available");
		}else {
			System.out.println("BINGO!!!!! ===>>> Login Logo Image Not Available");
		}
		Assert.assertEquals(logo, true);
	}
	
	@Test(priority = 3, groups = "INPUT Functionality")
	public static void loginTest() {
		loginPage.validatLogin(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.validatePageTitle();	
	}
	
	@Test(priority = 4, groups = "INPUT Functionality")
	public void curentUserNameTest() throws InterruptedException {
		//LoginPageTest.loginPage.validatLogin(prop.getProperty("username"), prop.getProperty("password"));
		loginTest();
		loginPage.validCurentUserName();
	}
	

	@AfterMethod(groups = "Main Functionality")
	public void tearDown() {
		loginPage.closeBrowser();
	}
	
}

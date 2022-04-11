package com.mco.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mco.base.TestBase;
import com.mco.pages.HomePage;
import com.mco.pages.LoginPage;


public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;


	@BeforeMethod(groups = " Main Functionality")
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}

	@Test(priority = 1, groups = "UI Elements")
	public void pageTitleTest() {
		// homePage.validatePageTitle();
		String title = homePage.validatePageTitle();
		Assert.assertEquals(title, "WildFire Cart", "Title of \"WildFire Cart\"is Not Available");
	}

	@Test(priority = 2, groups = "UI Elements")
	public void loginSourceButtonTest() {
		boolean loginSource = homePage.validateLoginSourstButton();
		Assert.assertEquals(loginSource, true);

	}

	@Test(priority = 3, groups = "LINK Elements")
	public void aboutUsLinkTest() {
		boolean aboutUs = homePage.validateAbotUsLink();
		Assert.assertEquals(aboutUs, true, "About Us is not Appear");
	}

	@Test(priority = 4, groups = "LINK Elements")
	public void contactUsLinkTest() {
		boolean contactUs = homePage.validateContactUsLink();
		Assert.assertEquals(contactUs, true, "Contact us Not appear");
	}

	@Test(priority = 5, groups = "LINK Elements")
	public void viewCartLinkTest() {
		boolean cartLink = homePage.validateViewCartLink();
		Assert.assertEquals(cartLink, true, "Cart Not appear");
	}

	@Test(priority = 6, groups = "List Items Elements")
	public void curencyListTest() {
		String currencyList = homePage.verifyCurrencyLists();
	}


	@AfterMethod(groups = " Main Functionality")
	public void tearDown() {
		homePage.closeBrowser();
	}

}

package com.mco.tests;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mco.base.TestBase;
import com.mco.pages.HomePage;
import com.mco.pages.LoginPage;
import com.mco.pages.RegistrationPage;
import com.mco.utility.TestUtill;



public class RegisterationPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtill testUtill;
	static RegistrationPage registrationPage;
	static String sheetName = "Reg1";
	public RegisterationPageTest() {
		super();
	}


	@BeforeMethod(groups = "Main Functionality")
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		testUtill = new TestUtill();
		registrationPage = new RegistrationPage();
		
	}
	@Test(priority = 1, groups = "UI Eelemnts")
	public void pageTitleTest() {
		String title = homePage.validatePageTitle();
		Assert.assertEquals(title, "WildFire Cart", "Title of \"WildFire Cart\" Did not found");
	}

	@DataProvider
	public Object[][] getMCOTestData(){
		Object[][] data = TestUtill.getTestData(sheetName);
		return data;
		
	}
	@Test(priority = 2, groups = "Test Data", dataProvider = "getMCOTestData")
	public void newUserRegistrationsTest(String email,String userName, String password, 
			String confirmPassword, String firstName, String lastName, String address) {
		
		registrationPage.validateNewUserRegistration(email, userName, password, 
				confirmPassword, firstName, lastName, address);
		
		registrationPage.validatCurentUserName();
		
	}
	
	
	@AfterMethod(groups = "Main Functionality")
	public void closeBrowser() {
		registrationPage.quiteBrowser();
	}
	
	
}

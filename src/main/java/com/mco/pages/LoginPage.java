package com.mco.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mco.base.TestBase;

public class LoginPage extends TestBase {
	//PAGE FACTORY OBJECT REPOSITORY
	
	@FindBy(xpath = "//button[@id='dLabellogin']")
	WebElement login_source_button;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement user_name;

	@FindBy(xpath = "//input[@id='password']")
	WebElement pass_word;

	@FindBy(xpath = "//button[@id='jqLogin']")
	WebElement login_Button;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='dLabel']/span")
	WebElement current_User_Name;

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement login_Image;

	//Initialized the page factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatePageTitle() {
		String title = driver.getTitle();
		System.out.println("Title of the Page is : "+title);
		return title;
	}
	public boolean validateLoginLogoImage() {
		return login_Image.isDisplayed();
	}
	public HomePage validatLogin(String un, String pas) {
		login_source_button.click();
		user_name.sendKeys(un);
		pass_word.sendKeys(pas);
		login_Button.click();
		return new HomePage();
	}
	public String validCurentUserName() {
		String visible_user = current_User_Name.getText();
		System.err.println("Curent User Name Is: "+visible_user);
		return visible_user;
	}
	public void closeBrowser() {
		driver.quit();
	}
}

package com.mco.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mco.base.TestBase;

public class HomePage extends TestBase {
	// PAGE FACTORY OBJECT'S REPOSITORY

	@FindBy(xpath = "//button[@id='dLabellogin']")
	WebElement login_Source_Button;

	@FindBy(linkText = "About Us")
	WebElement about_Us_Link;

	@FindBy(linkText = "Contact Us")
	WebElement contact_Us_Link;

	@FindBy(linkText = "View Cart")
	WebElement View_Cart_Link;

	@FindBy(xpath = "//select[@class='topsearch_fld']")
	WebElement currency_List;

	// PAGE FACTORY INITIALIZATION
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		String title = driver.getTitle();
		System.out.println("The Page Title is : "+title);
		return title;
	}

	public boolean validateLoginSourstButton() {
		// System.out.println("Name Of the Button is : "
		// +login_Source_Button.getText());
		return login_Source_Button.isDisplayed();
	}

	public boolean validateAbotUsLink() {
		System.out.println("Name Of the Object is : " + about_Us_Link.getText());
//		boolean validateAboutUs = about_Us_Link.isDisplayed();
		return about_Us_Link.isDisplayed();
	}

	public boolean validateContactUsLink() {
		System.out.println("Name Of the Object is : " + contact_Us_Link.getText());
		//boolean validateContactUs = contact_Us_Link.isDisplayed();
		return contact_Us_Link.isDisplayed();
	}

	public boolean validateViewCartLink() {
		System.out.println("Name Of the Object is : " + View_Cart_Link.getText());
		//boolean validateViewCart = View_Cart_Link.isDisplayed();
		return View_Cart_Link.isDisplayed();
	}

	public String verifyCurrencyLists() {
		// Select select = new
		// Select(driver.findElement(By.xpath("//select[@class='topsearch_fld']")));

		Select select = new Select(currency_List);
		System.out.println("Available Currency Type is : ");
		
		System.out.println("Total Items founds : "+currency_List.getSize());
		for (int i = 0; i <= 9; i++) {
			String allCurency = select.getOptions().get(i).getText();
			System.out.println(i + " " + allCurency);
		}
		return currency_List.getText();
	}

	public void closeBrowser() {
		driver.quit();
	}
}

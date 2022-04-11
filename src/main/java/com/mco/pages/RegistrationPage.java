package com.mco.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mco.base.TestBase;
import com.mco.utility.TestUtill;

public class RegistrationPage extends TestBase {
	//PAGE FACTORY OBJECT'S RIPOSITORY 
	
		@FindBy(xpath="//*[@id='dLabellogin']")
		WebElement login_Source_Button;
		
		
		@FindBy(xpath ="//*[@id='jqSignup']")
		WebElement register_Button;
		
		@FindBy(xpath ="//*[@id=\'txtEmail\']")
		WebElement email_Box ;
		
		@FindBy(xpath ="//*[@id=\'txtUserName\']")
		WebElement user_Name ;
		
		@FindBy(xpath ="//*[@id=\'txtPassword\']")
		WebElement password_Box ;
		
		@FindBy(xpath ="//*[@id=\'txtCnfPassword\']")
		WebElement conf_Password;
		
		@FindBy(xpath ="//*[@id=\'txtFirstName\']")
		WebElement first_Name;
		
		@FindBy(xpath ="//*[@id=\'txtLastName\']")
		WebElement last_Name;
		
		@FindBy(xpath ="//*[@name='custom_field_1']")
		WebElement address_Box;
		
		@FindBy(xpath ="//*[@id=\'btnRegister\']")
		WebElement btn_Register;
		
		@CacheLookup
		@FindBy(xpath ="//*[@id='dLabel']/span")
		WebElement current_User_Name;
		
		// Initializing the page FACTORY:
		public RegistrationPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		//ACTIONS

		public void validateNewUserRegistration(String email,String userName, String password, 
				String confirmPassword, String firstName, String lastName, String address) {
				login_Source_Button.click();
				register_Button.click();
				email_Box.sendKeys(email);
				user_Name.sendKeys(userName);
				password_Box.sendKeys(password);
				conf_Password.sendKeys(password);
				first_Name.sendKeys(firstName);
				last_Name.sendKeys(lastName);
				address_Box.sendKeys(address);
				btn_Register.click();
				driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);
			}
		
		public void validatCurentUserName() {
			String curent_Name = current_User_Name.getText();
			System.out.println("Curent User Name is : " + curent_Name);
			
		}
		
		public void quiteBrowser() {
			driver.quit();
		}


}

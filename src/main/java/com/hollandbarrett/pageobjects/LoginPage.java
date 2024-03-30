package com.hollandbarrett.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;



public class LoginPage extends Action{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Web Elements 
	
	//email
	@FindBy(xpath="//input[@id='username']")
	WebElement userName;
	
	//password
	@FindBy(xpath="//input[@id='password']")
	WebElement passWord;
	
	//signinbutton
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement signInButton;
	
	// error message
		@FindBy(id="error-element-password")
		WebElement errorMessage;
	
	
	// signup link 
	
	@FindBy(xpath="//a[contains(text(),'Sign up')]")
	WebElement signupLink;
	
	//Methods
	// Method to perform signIn action
	public AccountPage validLogin(String email, String password) {
        enterText(userName,email);
        enterText(passWord,password);
        clickOnElement(signInButton);
        return new AccountPage(driver);
    }
	
	
	// Method to click signIn link
	public SignupPage signupLink() {
		clickOnElement(signupLink);
		return new SignupPage(driver);
	}
	
	// Method to get current page url
	public String getCurrentUrl() {
		String loginPageUrl = driver.getCurrentUrl();
		return loginPageUrl;
	}
	
	// Method to get error message text
    public String getErrorMessage() {
        return errorMessage.getText();
    }

}

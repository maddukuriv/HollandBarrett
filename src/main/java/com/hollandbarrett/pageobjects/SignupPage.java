package com.hollandbarrett.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;



public class SignupPage extends Action{
	WebDriver driver;
	
	public SignupPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Web Elements by page factory method
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailId;
	
	@FindBy(xpath="//input[@id='confirmEmail']")
	WebElement confirmEmailId;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement createPassword;
	
	@FindBy(xpath="//input[@name='terms']")
	WebElement conditionsCheckBox;
	
	@FindBy(xpath="//span[normalize-space()='Create an account']")
	WebElement createAccountButton;
	
	@FindBy(xpath="//h4[contains(text(),'Please verify your email')]")
	WebElement welcomeMessageElement;
	

	
	public void enterFirstname(String firstname) {
        firstName.sendKeys(firstname);
    }
	
	public void enterLastName(String lastname) {
        lastName.sendKeys(lastname);
    }
	
	
	public void enterEmail(String email) {
        emailId.sendKeys(email);
    }
	
	public void confirmEmail(String confirmEmail) {
        confirmEmailId.sendKeys(confirmEmail);
    }

    public void enterPassword(String password) {
        createPassword.sendKeys(password);
    }

    public void clickCheckBox() {
    	conditionsCheckBox.click();
    }

    public void clickCreateButton() {
    	createAccountButton.click();
    }
    
    public String getCurrentUrl() {
		String signupPageUrl = driver.getCurrentUrl();
		return signupPageUrl;
		
		
	}
    
    public String getWelcomeMessage() {
    	getText(welcomeMessageElement);
    	return getWelcomeMessage();
    }

}



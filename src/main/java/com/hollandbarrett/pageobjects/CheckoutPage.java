package com.hollandbarrett.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;

public class CheckoutPage extends Action{
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		
		//initialization
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement signInButton;
	
@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]/div[1]/div[2]/label[1]")
WebElement clickAndCollectButton;

@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]")
WebElement deliveryButton;

@FindBy(xpath="//button[contains(text(),'Continue to delivery options')]")
WebElement deliveryOptionsButton;

@FindBy(xpath="//input[@id='NEXT_DAY_DELIVERY']")
WebElement nextDayButton;

@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/button[1]")
WebElement locationLink;

@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
WebElement postcodeBox;

@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/div[2]/button[1]")
WebElement selectStoreButton;


	
@FindBy(xpath="//input[@id='phoneNumber']")
WebElement mobilenoBox;

@FindBy(xpath="//button[contains(text(),'Enter details')]")
WebElement enterDetailsButton;

@FindBy(xpath="//button[contains(text(),'Continue to payment')]")
WebElement continueToPaymentButton;

	public LoginPage clickOnSignIn() {
		clickOnElement(signInButton);
		return new LoginPage(driver);
	}
	
	public void clickOnCollectButton() {
		clickOnElement(clickAndCollectButton);
	}
	public void clickOndeliveryButton() {
		clickOnElement(deliveryButton);
	}
	public void clickOndeliveryOptionsButton() {
		clickOnElement(deliveryOptionsButton);
	}
	public void clickOnNextdayButton() {
		clickOnElement(nextDayButton);
	}
	public void enterPostcode(String postcode) {
        postcodeBox.sendKeys(postcode);
    }
	
	public void clickOnStore() {
		clickOnElement(selectStoreButton);
	}
	
	public void clickOnLocation() {
		clickOnElement(locationLink);
	}
		
		
	public void enterMobileno(String mobileno) {
        mobilenoBox.sendKeys(mobileno);
    }
	
	public void clickEnterDetails() {
		clickOnElement(enterDetailsButton);
	}
	
	public PaymentPage clickOnPayment() {
		clickOnElement(continueToPaymentButton);
		return new PaymentPage(driver);
	}

}

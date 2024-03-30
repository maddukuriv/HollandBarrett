package com.hollandbarrett.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;

public class PaymentPage extends Action {
	
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		
		//initialization
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='card-simple-v5-accordion-head']")
	WebElement cardPaymentButton;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span[1]/iframe[1]")
	WebElement cardNumberInput;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/span[1]")
	WebElement expiryDateInput;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/span[1]")
	WebElement cvvInput;
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
	WebElement payButton;
	
	
	public void clickOnCardPayment() {
		clickOnElement(cardPaymentButton);
	}
	
	
	public void switchToCardDetailsFrame() {
        driver.switchTo().frame("cardDetailsFrame"); // Replace "cardDetailsFrame" with the actual iframe ID or name
    }
	
	
	// Method to enter card number
    public void enterCardNumber(String cardNumber) {
        switchToCardDetailsFrame(); // Switch to the card details iframe
        cardNumberInput.sendKeys(cardNumber);
    }

    // Method to enter expiry date
    public void enterExpiryDate(String expiryDate) {
        switchToCardDetailsFrame(); // Switch to the card details iframe
        expiryDateInput.sendKeys(expiryDate);
    }

    // Method to enter CVV
    public void enterCVV(String cvv) {
        switchToCardDetailsFrame(); // Switch to the card details iframe
        cvvInput.sendKeys(cvv);
    }
	
/*
    public void enterCardno(String cardno) {
        cardnoBox.sendKeys(cardno);
    }
	
	public void ExpiryDate(String expiryno) {
        cardExpiryBox.sendKeys(expiryno);
    }
	
	public void enterSecurityno(String securityno) {
        securityCodeBox.sendKeys(securityno);
    }*/
	
	public void clickOnPay() {
		clickOnElement(payButton);
		
	}

}

package com.hollandbarrett.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;



public class CartPage extends Action {
WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nextbtn")
	WebElement nextButton;
	
	@FindBy(xpath="//body/div[@id='__next']/div[2]/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/div[5]/div[1]/span[1]")
	WebElement getTotal;
	
	@FindBy(xpath="//body/div[@id='__next']/div[2]/div[2]/div[3]/div[2]/div[2]/div[2]/div[3]/button[1]")
	WebElement checkoutButton;
	

	public void nextButton() {
		clickOnElement(nextButton);
		
	}
	
	public String getCurrentUrl() {
		String cartPageUrl = driver.getCurrentUrl();
		return cartPageUrl;
		
		
	}
	
	public String getTotalItems() {
		String totalItems = getAttributeValue(getTotal, null);
		return totalItems;
	}
	
	public CheckoutPage clickOnCheckout() {
		clickOnElement(checkoutButton);
		return new CheckoutPage(driver);
		
	}





	

}


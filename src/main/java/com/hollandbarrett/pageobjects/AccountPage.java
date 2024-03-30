package com.hollandbarrett.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;



public class AccountPage extends Action {
	WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h3[contains(text(),'My orders')]")
	WebElement myOrdersLink;
	
	@FindBy(xpath="//h3[contains(text(),'My favourites')]")
	WebElement myFavouritesLink;
	
	public String getAccountPageUrl() {
		String accountPageUrl = driver.getCurrentUrl();
		return accountPageUrl;
	}
	
	public CartPage clickMyOrders() {
		clickOnElement(myOrdersLink);
		return new CartPage(driver);
	}
	
	public FavouritesPage clickMyFavourites() {
		clickOnElement(myFavouritesLink);
		return new FavouritesPage(driver);
	}

	

}

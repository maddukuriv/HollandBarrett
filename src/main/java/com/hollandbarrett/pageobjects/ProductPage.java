package com.hollandbarrett.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;

public class ProductPage extends Action{
WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// add to cart button
	@FindBy(xpath="(//button[@type='button'][normalize-space()='Add to basket'])[2]")
	WebElement addTocartButton;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/p[1]")
	WebElement addToCartMessage;
	
	
	@FindBy(xpath="//a[@class='MiniBasket-module_button__sf-GI']")
	WebElement viewCart;
	
	
	
	public void clickAddToCart() {
        clickOnElement(addTocartButton);
		
    }
	
	public boolean validateAddToCart() {
		return isDisplayed(addToCartMessage);
	}
	
	public CartPage clickBasket() {
		clickOnElement(viewCart);
		return new CartPage(driver);
	}

}


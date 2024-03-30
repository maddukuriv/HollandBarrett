package com.hollandbarrett.pageobjects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;



public class SearchResultPage extends Action{
	
WebDriver driver;
	
	public SearchResultPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		//initialization
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Web Elements by page factory method
	
	
	
	@FindBy(css=".ProductCard-module_link__rImhN")
	WebElement productResult;
	
	
	
	
	public boolean isProductAvailable() {
		return isDisplayed(productResult);
		
	}
	
	
	public ProductPage clickOnProduct() {
		clickOnElement(productResult);
		return new ProductPage(driver);
	}

	
	
	
}

package com.hollandbarrett.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;



public class PromotionPage extends Action {
WebDriver driver;
	
	public PromotionPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		//initialization
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String getCurrentUrl() {
		String promotionPageUrl = driver.getCurrentUrl();
		return promotionPageUrl;
		
		
	}

}




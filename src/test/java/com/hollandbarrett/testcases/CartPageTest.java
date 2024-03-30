package com.hollandbarrett.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hollandbarrett.base.BaseClass;
import com.hollandbarrett.pageobjects.HomePage;
import com.hollandbarrett.pageobjects.CartPage;
import com.hollandbarrett.pageobjects.ProductPage;
import com.hollandbarrett.pageobjects.SearchResultPage;

public class CartPageTest extends BaseClass{
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private ProductPage productPage;
	private CartPage cartPage;
	
	@BeforeMethod(alwaysRun=true)
	public void setupHomePage() {
        
		homePage = new HomePage(driver);
        homePage.acceptCookies(); // Accept cookies if present
    }
	
	@Test
	public void testOrdersPage() throws InterruptedException {
		searchResultPage = homePage.searchProduct("vitamin c 1500mg 120");
		productPage = searchResultPage.clickOnProduct();
		productPage.clickAddToCart();
		cartPage = productPage.clickBasket();
		
		System.out.println(cartPage.getTotalItems());
	}
	
	
	
	


}

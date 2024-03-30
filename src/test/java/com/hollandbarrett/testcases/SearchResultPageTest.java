package com.hollandbarrett.testcases;



import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hollandbarrett.base.BaseClass;
import com.hollandbarrett.pageobjects.HomePage;
import com.hollandbarrett.pageobjects.SearchResultPage;



public class SearchResultPageTest extends BaseClass{
	private HomePage homePage;
	
	
	
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(alwaysRun=true)
	public void setupHomePage() {
        
		homePage = new HomePage(driver);
        homePage.acceptCookies(); // Accept cookies if present
    }
 
	@Test
    public void testProductAvailability() {
		
	    searchResultPage = homePage.searchProduct("vitamin c 1500mg 120");
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		
		
	}
	
		

	

}

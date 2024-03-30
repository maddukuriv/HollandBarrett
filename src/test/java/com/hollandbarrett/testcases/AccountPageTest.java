package com.hollandbarrett.testcases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.hollandbarrett.base.BaseClass;
import com.hollandbarrett.pageobjects.AccountPage;
import com.hollandbarrett.pageobjects.FavouritesPage;
import com.hollandbarrett.pageobjects.HomePage;
import com.hollandbarrett.pageobjects.LoginPage;
import com.hollandbarrett.pageobjects.CartPage;



public class AccountPageTest extends BaseClass{
	private HomePage homePage;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CartPage ordersPage;
	private FavouritesPage favouritesPage;
	
	@BeforeMethod
	public void setupHomePage() {
        homePage = new HomePage(driver);
        homePage.acceptCookies(); // Accept cookies if present
    }
	
	@Test
	public void testMyOrdersIcon() throws InterruptedException {
		 homePage.clickSignInLink();
	     loginPage = homePage.clickSignInLink();
		 accountPage = loginPage.validLogin(username, password);
		 Thread.sleep(5000);
		 ordersPage = accountPage.clickMyOrders();
		 String actualUrl = ordersPage.getCurrentUrl();
		 String expectedUrl="https://www.hollandandbarrett.com/my-account/orders";
		 AssertJUnit.assertEquals(actualUrl, expectedUrl);
		
	}
	@Test
	public void testMyFavouritesIcon() {
		homePage.clickSignInLink();
		loginPage = homePage.clickSignInLink();
		accountPage = loginPage.validLogin(username, password);
		favouritesPage = accountPage.clickMyFavourites();
		String actualUrl = favouritesPage.getCurrentUrl();
		String expectedUrl="https://www.hollandandbarrett.com/my-account/favourites";
		AssertJUnit.assertEquals(actualUrl, expectedUrl);
		
	}

}


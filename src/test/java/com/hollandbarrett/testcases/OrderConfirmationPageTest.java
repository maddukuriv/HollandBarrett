package com.hollandbarrett.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hollandbarrett.base.BaseClass;
import com.hollandbarrett.pageobjects.CartPage;
import com.hollandbarrett.pageobjects.CheckoutPage;
import com.hollandbarrett.pageobjects.HomePage;
import com.hollandbarrett.pageobjects.LoginPage;
import com.hollandbarrett.pageobjects.PaymentPage;
import com.hollandbarrett.pageobjects.ProductPage;
import com.hollandbarrett.pageobjects.SearchResultPage;

public class OrderConfirmationPageTest extends BaseClass {
	
	
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private ProductPage productPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private LoginPage loginPage;
	private PaymentPage paymentPage;
	
	@BeforeMethod(alwaysRun=true)
	public void setupHomePage() {
        
		homePage = new HomePage(driver);
        homePage.acceptCookies(); // Accept cookies if present
    }
	
	@Test 
	public void testDelivery() throws InterruptedException {
		searchResultPage = homePage.searchProduct("vitamin c 1500mg 120");
		productPage = searchResultPage.clickOnProduct();
		productPage.clickAddToCart();
		cartPage = productPage.clickBasket();
		checkoutPage = cartPage.clickOnCheckout();
		loginPage = checkoutPage.clickOnSignIn();
		loginPage.validLogin(username, password);
		checkoutPage.clickOndeliveryButton();
		checkoutPage.clickOndeliveryOptionsButton();
		Thread.sleep(5000);
		checkoutPage.clickOnNextdayButton();
		paymentPage = checkoutPage.clickOnPayment();	
		paymentPage.clickOnCardPayment();
		Thread.sleep(10000);
		paymentPage.enterCardNumber("5373820965522054");
		paymentPage.enterExpiryDate("1025");
		paymentPage.enterCVV("123");
		paymentPage.clickOnPay();
		
	}

	@Test 
	public void testClickAndCollect() throws InterruptedException {
		searchResultPage = homePage.searchProduct("vitamin c 1500mg 120");
		productPage = searchResultPage.clickOnProduct();
		productPage.clickAddToCart();
		cartPage = productPage.clickBasket();
		checkoutPage = cartPage.clickOnCheckout();
		loginPage = checkoutPage.clickOnSignIn();
		loginPage.validLogin(username, password);
		checkoutPage.clickOnCollectButton();
		Thread.sleep(5000);
		checkoutPage.clickOnStore();
		checkoutPage.enterMobileno("7448557174");
		paymentPage = checkoutPage.clickOnPayment();
		paymentPage.clickOnCardPayment();
		Thread.sleep(10000);
		paymentPage.enterCardNumber("5373820965522054");
		paymentPage.enterExpiryDate("1025");
		paymentPage.enterCVV("123");
		paymentPage.clickOnPay();
		
	}
}

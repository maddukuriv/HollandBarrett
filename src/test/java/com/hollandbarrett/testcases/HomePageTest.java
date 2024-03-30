package com.hollandbarrett.testcases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hollandbarrett.base.BaseClass;
import com.hollandbarrett.pageobjects.BarcodePage;
import com.hollandbarrett.pageobjects.CbdPage;
import com.hollandbarrett.pageobjects.CbdoilPage;
import com.hollandbarrett.pageobjects.HelpPage;
import com.hollandbarrett.pageobjects.HomePage;
import com.hollandbarrett.pageobjects.LoginPage;
import com.hollandbarrett.pageobjects.CartPage;
import com.hollandbarrett.pageobjects.PromotionPage;
import com.hollandbarrett.pageobjects.SignupPage;
import com.hollandbarrett.pageobjects.StoresPage;
import com.hollandbarrett.pageobjects.VitaminsPage;


public class HomePageTest extends BaseClass{
	private HomePage homePage;
	private LoginPage loginPage;
	private PromotionPage promotionPage;
	private BarcodePage barcodePage;
	private HelpPage helpPage;
	private StoresPage storesPage;
	private SignupPage signupPage;
	private VitaminsPage vitaminsPage;
	private CbdoilPage cbdoilPage;
	private CbdPage cbdPage;
	private CartPage cartPage;
	
	@BeforeMethod(alwaysRun=true)
	public void setupHomePage() {
        homePage = new HomePage(driver);
        homePage.acceptCookies(); // Accept cookies if present
    }
	

	@Test(groups={"Smoke"})
	public void testPromotionLink() {
		promotionPage=homePage.clickShopNowLink();
		String actualUrl = promotionPage.getCurrentUrl();
		String expectedUrl="https://www.hollandandbarrett.com/shop/offers/buy-one-get-one-1-2-price/";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(groups={"Smoke"})
	public void testReedemInStoreLink() {
		barcodePage = homePage.clickReedemInStoreLink();
		String actualUrl = barcodePage.getCurrentUrl();
		String expectedUrl="https://www.hollandandbarrett.com/info/redeem-in-store/";
		Assert.assertEquals(actualUrl, expectedUrl);
		}
	
	@Test(groups={"Smoke"})
	public void testFindStoreLink() {
		storesPage = homePage.clickFindStoreLink();
		String actualUrl = storesPage.getCurrentUrl();
		String expectedUrl="https://www.hollandandbarrett.com/stores/";
		Assert.assertEquals(actualUrl, expectedUrl);
		}
	
	@Test(groups={"Smoke"})
	public void testHelpLink() {
		helpPage = homePage.clickHelpLink();
		String actualUrl = helpPage.getCurrentUrl();
		String expectedUrl="https://help.hollandandbarrett.com/hc/en-gb";
		Assert.assertEquals(actualUrl, expectedUrl);
		}
	
	
	@Test(groups={"Smoke"})
	public void testHomePageTitle() {
		String actualTitle = homePage.getPageTitle();
		Assert.assertEquals(actualTitle, "Holland & Barrett - UK's Leading Health & Wellbeing Store");
	}
	
	@Test(groups={"Smoke"})
	public void testLogoPresence() throws Throwable {
		boolean result = homePage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups={"Smoke"})
    public void testHoverOverSignInLink() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInLink();
        loginPage = homePage.clickSignInLink();
        String actualUrl = loginPage.getCurrentUrl();
		String expectedPartialUrl="https://auth.hollandandbarrett.com/u/login";
		Assert.assertTrue(actualUrl.contains(expectedPartialUrl), "Actual URL does not contain the expected partial URL");
    }
	
	@Test(groups={"Smoke"})
    public void testHoverOverSignInLinkAndClickCreateAccount() {
		 HomePage homePage = new HomePage(driver);
		signupPage =  homePage.hoverOverSignInAndClickCreateAccountLink();
		String actualUrl = signupPage.getCurrentUrl();
		String expectedUrl="https://www.hollandandbarrett.com/auth/signup";
		Assert.assertEquals(actualUrl, expectedUrl);
    }
	
	@Test(groups={"Smoke"})
	public void testBasketIcon() throws InterruptedException {	
		 HomePage homePage = new HomePage(driver);
		cartPage = homePage.clickBasketButton();
		String actualUrl = cartPage.getCurrentUrl();
		String expectedUrl = "https://www.hollandandbarrett.com/basket";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	

	@Test
	public void testSearchFunctionality() {
		homePage.searchProduct("vitamin c");
	}
	
	@Test
	public void testHoverOverShopProducts() {
		homePage.hoverOverShopProducts();
		
	}
	
	@Test(groups={"Smoke"})
	public void testNavigateFromShopProductsToVitamins() {
		vitaminsPage = homePage.hoverOverShopProductsAndClickVitamins();
		String actualUrl = vitaminsPage.getCurrentUrl();
		String expectedUrl = "https://www.hollandandbarrett.com/shop/vitamins-supplements/";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(groups={"Smoke"})
	public void testNavigateFromShopProductsToCbd() {
		cbdPage = homePage.hoverOverShopProductsAndClickCbd();
		String actualUrl = cbdPage.getCurrentUrl();
		String expectedUrl = "https://www.hollandandbarrett.com/shop/vitamins-supplements/cbd/";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(groups={"Smoke"})
	public void testNavigateFromShopProductsToCbdOil() {
		cbdoilPage = homePage.hoverOverShopProductsAndClickCbdOil();
		String actualUrl = cbdoilPage.getCurrentUrl();
		String expectedUrl = "https://www.hollandandbarrett.com/shop/vitamins-supplements/cbd/cbd-oil/";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
}

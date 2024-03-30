package com.hollandbarrett.testcases;



import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hollandbarrett.base.BaseClass;
import com.hollandbarrett.pageobjects.AccountPage;
import com.hollandbarrett.pageobjects.HomePage;
import com.hollandbarrett.pageobjects.LoginPage;
import com.hollandbarrett.pageobjects.SignupPage;



public class LoginPageTest extends BaseClass{
	private HomePage homePage;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private SignupPage signupPage;
	
	@BeforeMethod(alwaysRun=true)
	public void setupHomePage() {
        
		homePage = new HomePage(driver);
        homePage.acceptCookies(); // Accept cookies if present
    }
	
	@Test(groups={"Smoke","Regression"})
	public void testValidLogin() {
		homePage.clickSignInLink();
        loginPage = homePage.clickSignInLink();
		accountPage = loginPage.validLogin(username, password);
		String actualUrl = accountPage.getAccountPageUrl();
		String expectedUrl="https://www.hollandandbarrett.com/my-account/overview";
	    Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(groups={"Smoke","Regression"})
	public void testInvalidLogin() {	
        homePage.clickSignInLink();
        loginPage = homePage.clickSignInLink();
		accountPage = loginPage.validLogin(username1, password1);
		String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Wrong email or password";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message doesn't match.");
    }
	
	
	@Test(groups={"Smoke"})
	public void testsignupLink() {
	homePage.clickSignInLink();
    loginPage = homePage.clickSignInLink();
    signupPage = loginPage.signupLink();
	String actualUrl = signupPage.getCurrentUrl();
	String expectedUrl="https://www.hollandandbarrett.com/auth/signup";
	Assert.assertEquals(actualUrl, expectedUrl);
	
	}
	

	

}



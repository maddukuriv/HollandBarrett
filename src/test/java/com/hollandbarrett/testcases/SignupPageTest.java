package com.hollandbarrett.testcases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hollandbarrett.base.BaseClass;
import com.hollandbarrett.pageobjects.HomePage;
import com.hollandbarrett.pageobjects.LoginPage;
import com.hollandbarrett.pageobjects.SignupPage;



public class SignupPageTest extends BaseClass{
	private HomePage homePage;
	private LoginPage loginPage;
	
	
	@BeforeMethod
	public void setupHomePage() {
        homePage = new HomePage(driver);
        homePage.acceptCookies(); // Accept cookies if present
    }
	
	
	@Test
	public void testValidSignup() {
		homePage.clickSignInLink();
		LoginPage loginPage = homePage.clickSignInLink();
		loginPage.signupLink();
		
		SignupPage signupPage = new SignupPage(driver);
		signupPage.enterFirstname("veerendra");
		signupPage.enterLastName("maddukuri");
        signupPage.enterEmail("veerendrachaudhari@gmail.com");
        signupPage.confirmEmail("veerendrachaudhari@gmail.com");
        signupPage.enterPassword("Mad@239271");
        signupPage.clickCheckBox();
        signupPage.clickCreateButton();
        
        
     // Verify successful sign-up
        String welcomeMessage = signupPage.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains("Please verify your email"), "Sign-up failed.");
    
	}
	
	
	@Test
	public void testInvalidSignup() {
		homePage.clickSignInLink();
		loginPage = homePage.clickSignInLink();
		loginPage.signupLink();
		
		SignupPage signupPage = new SignupPage(driver);
		signupPage.enterFirstname("veerendra");
		signupPage.enterLastName("maddukuri");
        signupPage.enterEmail("veerendrachaudhari@gmail.com");
        signupPage.confirmEmail("veerendrachaudhari@gmail.com");
        signupPage.enterPassword("Mad@239271");
        signupPage.clickCheckBox();
        signupPage.clickCreateButton();
        
     // Verify error message(s)
        //String errorMessage = signupPage.getErrorMessage();
        //Assert.assertTrue(errorMessage.contains("Invalid email"), "Invalid email error message not displayed");
        //Assert.assertTrue(errorMessage.contains("Email addresses don't match"), "Email mismatch error message not displayed");
        //Assert.assertTrue(errorMessage.contains("Password must be at least 8 characters"), "Weak password error message not displayed");
    
    
	}

}

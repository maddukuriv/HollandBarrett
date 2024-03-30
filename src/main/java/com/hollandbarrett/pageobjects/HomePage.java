package com.hollandbarrett.pageobjects;




import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hollandbarrett.actiondriver.Action;

public class HomePage extends Action{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		//initialization
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Web Elements by page factory method
	
	
	// header bar
		// shop now link 
		@FindBy(linkText="Shop now")
		WebElement shopNowLink;
		
		// reedem instore link 
		@FindBy(xpath="//a[normalize-space()='Redeem instore | T&Cs']")
		WebElement redeemInStoreLink;
		
		
		// find a store link
		@FindBy(xpath="//a[contains(text(),'Find a store')]")
		WebElement findStoreLink;
		
		// help link
		@FindBy(xpath="//a[contains(text(),'Help')]")
		WebElement helpLink;
	
	// Essentials elements
	// logo
	@FindBy(xpath="//body/div[@id='_root_']/div[1]/div[3]/div[1]/div[1]/a[1]/*[1]")
	WebElement logo;
	
	//accept cookies button
	@FindBy(id="onetrust-accept-btn-handler")
	WebElement acceptCookiesButton;
	
	//my h&b button - signinlink
	@FindBy(xpath="//div[contains(text(),'My H&B')]")
	WebElement signInLink;
	
	
	
	//my h&b button - create account link
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/a[1]/div[3]/a[2]/div[1]")
	WebElement createAccountLink;
	
	//basket icon
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]/span[2]")
	WebElement basketButton;
	
	
	// search box
	@FindBy(xpath = "//body/div[@id='_root_']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")
    WebElement searchBox;

    // search button
	@FindBy(xpath = "//body/div[@id='_root_']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]/div[1]/div[1]")
    WebElement searchButton;
	
// Navigation & menu 
	
	@FindBy(xpath="//button[contains(text(),'Shop products')]")
	WebElement shopProducts;
	
	
	
	@FindBy(xpath="//div[@class='CategoryDesktop-module_name__k197z'][normalize-space()='Vitamins & Supplements']")
	WebElement vitaminsAndSuppliments;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/ul[2]/li[3]/span[1]/div[1]")
	WebElement Cbd;
	
	
	
	
	@FindBy(xpath="//div[normalize-space()='CBD Oil']")
	WebElement CbdOil;
	
	
	@FindBy(xpath="//button[contains(text(),'Health & Wellness')]")
	WebElement healthAndWellness;
	
	@FindBy(xpath="//button[contains(text(),'The Health Hub')]")
	WebElement theHealthHub;
	
	// promotioanal & product links
	
	
	// Footer bar
	
	
	
	
	
	// User action methods 
	
	
	public void acceptCookies() {
        if (isElementPresent(acceptCookiesButton)) {
            acceptCookiesButton.click();
        }
    }

    private boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }
	
	public PromotionPage clickShopNowLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", shopNowLink);
		return new PromotionPage(driver);
		
	}
	
	public BarcodePage clickReedemInStoreLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", redeemInStoreLink);
		return new BarcodePage(driver);
		
	}
	
	public StoresPage clickFindStoreLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", findStoreLink);
		return new StoresPage(driver);
	}
	
	public HelpPage clickHelpLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", helpLink);
		return new HelpPage(driver);
	}
    
    public String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
    
    public boolean validateLogo() throws Throwable {
		return isElementPresent(logo);
	}
    
    public SignupPage hoverOverSignInAndClickCreateAccountLink() {
        hoverOverElement(signInLink);
        clickOnElement(createAccountLink);
        return new SignupPage(driver);
    }
    
    public LoginPage clickSignInLink() {
		clickOnElement(signInLink);
		return new LoginPage(driver);
	}
    
   
    
	public SearchResultPage searchProduct(String productName) {
		enterText(searchBox, productName);
		clickOnElement(searchButton);
		return new SearchResultPage(driver);
	}
	
	public CartPage clickBasketButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", basketButton);
		//clickOnElement(basketButton);
		return new CartPage(driver);
	}
	
	public void hoverOverShopProducts() {
        hoverOverElement(shopProducts);
    }
	
	public VitaminsPage hoverOverShopProductsAndClickVitamins() {
		hoverOverElement(shopProducts);
		clickOnElement(vitaminsAndSuppliments);
		return new VitaminsPage(driver);
	}
	
	public CbdPage hoverOverShopProductsAndClickCbd() {
		hoverOverElement(shopProducts);
		hoverOverElement(vitaminsAndSuppliments);
		clickOnElement(Cbd);
		return new CbdPage(driver);
		
	}
	
	public CbdoilPage hoverOverShopProductsAndClickCbdOil() {
		hoverOverElement(shopProducts);
		hoverOverElement(vitaminsAndSuppliments);
		hoverOverElement(Cbd);
		clickOnElement(CbdOil);
		return new CbdoilPage(driver);
		
	}

}

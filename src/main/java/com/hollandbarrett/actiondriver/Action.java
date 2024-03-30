package com.hollandbarrett.actiondriver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
	
	private WebDriver driver;
	private Actions actions;

	public Action(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // Clicking on Elements
    public void clickOnElement(WebElement element) {
        actions.click(element).build().perform();
    }

    // Entering Text
    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    // Clearing Text
    public void clearText(WebElement element) {
        element.clear();
    }

    // Selecting Options by Visible Text
    public void selectOptionByVisibleText(WebElement element, String visibleText) {
        // Assuming element is a dropdown/select element
        new org.openqa.selenium.support.ui.Select(element).selectByVisibleText(visibleText);
    }

    // Mouse Hover Action
    public void hoverOverElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    // Drag and Drop Action
    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
    }

    // Double Click Action
    public void doubleClick(WebElement element) {
        actions.doubleClick(element).build().perform();
    }

    // Pressing Enter Key
    public void pressEnterKey() {
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    // Switching to Frames
    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    // Switching to Windows
    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

 

    // Getting Attribute Values
    public String getAttributeValue(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    // Getting Text
    public String getText(WebElement element) {
        return element.getText();
    }

    // Executing JavaScript
    public void executeJavaScript(String script) {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script);
    }
    
    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }
    
 
}


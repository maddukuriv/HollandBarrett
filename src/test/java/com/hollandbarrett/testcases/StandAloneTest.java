package com.hollandbarrett.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// Invoking web driver 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hollandandbarrett.com/");
		
		//accept cookies
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		// account page
	
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]/span[2]")).click();
		


		

//div.LayoutWidget-module_wrapper__vMDI8:nth-child(5) div.LayoutWidget-module_layout__Aawlk div.SearchContentContainer-module_container__LaEsO:nth-child(1) div.SearchContentContainer-module_contentContainer__KwiXg div.ProductListContainer-module_list__seqZE a.ProductCard-module_link__rImhN:nth-child(1) > div.Card-module_card__-Nhoy.ProductCard-module_card__oMW-o
	
//div.LayoutWidget-module_wrapper__vMDI8:nth-child(5) div.LayoutWidget-module_layout__Aawlk div.SearchContentContainer-module_container__LaEsO:nth-child(1) div.SearchContentContainer-module_contentContainer__KwiXg div.ProductListContainer-module_list__seqZE a.ProductCard-module_link__rImhN:nth-child(2) > div.Card-module_card__-Nhoy.ProductCard-module_card__oMW-o	






/*
		// sign in 
		driver.findElement(By.xpath("//div[contains(text(),'My H&B')]")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("maddukuri_v@hotmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Mad@239271");
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		
		
		
		
		
		
		//driver.findElement(By.id("nextbtn")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Shop products')]")).click();
		driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]")).click();
		
		
		// search and add product to cart 
		
		
		// add to cart page 
		
		
		// payment page 
		
		
		// account summary page 
		
		
		
	*/

	}

}

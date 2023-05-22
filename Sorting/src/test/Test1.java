package test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

import bsh.Parser;

public class Test1 {
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void myBeforetest() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.id("login-button")).click();
		
		
	}@Test
    public void high_to_low () {
	        WebElement selectMenu= driver.findElement(By.className("product_sort_container"));
	        selectMenu.click();
	        Select s=new Select(selectMenu);
	        s.selectByValue("hilo");
	 
	        List<WebElement>  Prices=driver.findElements(By.className("inventory_item_price"));  
	        String [] stripedPrices=new String[Prices.size()];
	        System.out.println("From hight to low Prices");
	        for (int i=0;i<Prices.size();i++){
	        stripedPrices[i]=Prices.get(i).getText().replace("$","");
	        System.out.println(i+"  "+stripedPrices[i]);
	        }
	}

    @Test
    public void low_to_high (){
        WebElement selectMenu= driver.findElement(By.className("product_sort_container"));
        selectMenu.click();
        Select s=new Select(selectMenu);
        s.selectByValue("lohi");
        List<WebElement>  Prices=driver.findElements(By.className("inventory_item_price"));    
        List<String> BeforePrices=new ArrayList<>();
        List<String> AfterPrices=new ArrayList<>();
        System.out.println("From low to high Prices");
        for (int i=0;i<Prices.size();i++){
        	BeforePrices.add(Prices.get(i).getText());
        	AfterPrices.add(BeforePrices.get(i).replace("$", ""));
	        System.out.println(i+"  "+AfterPrices.get(i));
  
        }

      
    }
	
	
	
	
	@AfterTest
	public void AfterTest() {
		
	}

}

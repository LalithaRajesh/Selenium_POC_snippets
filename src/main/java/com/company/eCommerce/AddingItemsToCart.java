package com.company.eCommerce;
//Adding an item to the cart

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AddingItemsToCart {

    public static void main(String[] args) throws InterruptedException {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //Adding just one item to the cart
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for(int i = 0;i<products.size(); i++)
        {
            String name = products.get(i).getText();
            if (name.contains("Cucumber")) {
                //clicK to ADD TO CART
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
        }
    }
}

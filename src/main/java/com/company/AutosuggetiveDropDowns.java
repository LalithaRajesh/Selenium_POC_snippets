package com.company;

//How to work on auto suggestive dropdowns
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutosuggetiveDropDowns {
    public static void main(String[] args) throws InterruptedException {
        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);

        //There are three options for 'ind'. We are going to iterate through the auto suggestions and choose one among them.
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for (WebElement option : options) {
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
    }
}

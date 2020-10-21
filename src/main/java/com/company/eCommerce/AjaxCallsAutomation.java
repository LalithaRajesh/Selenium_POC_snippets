package com.company.eCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//How to mouse over in selenium?
public class AjaxCallsAutomation {

    public static void main(String[] args) throws InterruptedException {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
    }

}

package com.company.eCommerce;

//How to type in Capital letters using SHIFT key?
//How to right click (Context click)
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CompositeActions {

    public static void main(String[] args) {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

        //How to type in Capital letters using SHIFT key?
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
        //Moves to specific element
//        a.moveToElement(move).build().perform();

        //Using Context click on a element
        a.moveToElement(move).contextClick().build().perform();
    }
}

package com.company;

//This is a simple selenium usage on facebook.com using id, name, linkText web elements
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

    public static void main(String[] args) {

        String currentDir =System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://facebook.com");
        driver.findElement(By.id("email")).sendKeys("My facebook");
        driver.findElement(By.name("pass")).sendKeys("Facebook1");
        driver.findElement(By.linkText("Forgotten password?")).click();
    }

}
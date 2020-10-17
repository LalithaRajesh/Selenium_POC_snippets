package com.company.spiceject;

//How to use check box in selenium
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxSelection {

    public static void main(String[] args) {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.spicejet.com");
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        //To check if the method has selected the check box or not
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        //To count the check boxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

    }

}

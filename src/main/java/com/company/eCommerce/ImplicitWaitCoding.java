package com.company.eCommerce;

// Usage of implicit wait mechanism
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitCoding {

    public static void main(String[] args) throws InterruptedException {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Implicit wait is declaring the wait globally. That is common to the overall code
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(1000);

        //Adding just multiple items to the cart
        String[] itemsToBeAdded= {"Cucumber", "Tomato", "Beans", "Apple", "Banana"};
        addItems(driver,itemsToBeAdded);
//        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
//        driver.findElement(By.cssSelector("input.promoCode")).sendKeys();
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
//        driver.findElement(By.cssSelector("button.promoBtn")).click();
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
        driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/button")).click();
    }

    public static void addItems(WebDriver driver,String[] itemsToBeAdded){

        int j = 0;
        //convert array into array list for easy search
        List totalItems = Arrays.asList(itemsToBeAdded);

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for(int i = 0;i<products.size(); i++)
        {
            j++;
            //format the name of vegetable in the list by removing '1 Kg' ie "Brocolli- 1 Kg'
            String[] name = products.get(i).getText().split("-");
            //trim the white spaces
            String formattedVegetableName = name[0].trim();

            //Check whether the name we had extracted is present or not
            if (totalItems.contains(formattedVegetableName)) {
                //click to ADD TO CART
                //Earlier, we added the below code to add the items to cart. But, the next script searches the next item
                //before the previous item is added to cart. Hence, we are changing the xpath by adding the parent of the below step
//                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j==itemsToBeAdded.length) {
                    break;
                }
            }
        }
    }
}

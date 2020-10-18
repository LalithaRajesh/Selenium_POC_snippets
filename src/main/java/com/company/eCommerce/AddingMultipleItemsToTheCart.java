package com.company.eCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddingMultipleItemsToTheCart {

    public static void main(String[] args) throws InterruptedException {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(1000);

        int j = 0;
        //Adding just multiple items to the cart
        String[] itemsToBeAdded= {"Cucumber", "Tomato", "Beans", "Apple", "Banana"};
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

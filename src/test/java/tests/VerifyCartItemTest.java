package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.utilities.BaseClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

    public class VerifyCartItemTest extends BaseClass {

        @Test
        public void verifyCartItemTest(){


            driver.navigate().to("https://spree-vapasi.herokuapp.com");
            addToCart("Ruby on Rails Bag");
            //String actualText = driver.findElement(By.linkText("Ruby on Rails Bag")).getText();
            String actualText = driver.findElement(By.id("cart-detail")).findElement(By.linkText("Ruby on Rails Bag")).getText();
            assertEquals(actualText, "Ruby on Rails Bag");

            //List<WebElement> items =  driver.findElements(By.xpath("//table[@id='cart-detail']/tbody/tr"));
            List<WebElement> items =  driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));

            //System.out.println(items.get(0));
            //System.out.println(items.get(1));

            //String name = items.get(0).getText();
            //String name = items.get(0).findElement(By.tagName("a")).getAttribute("value");
            //cart-item-description
            //for (int i =0;)
            for(int i=0; i<items.size();i++)
            {
                String name = items.get(i).findElement(By.className("cart-item-description")).findElement(By.tagName("a")).getText();

                System.out.println(name);

            }

            assertEquals(items.size(), 1);



        }

        private void addToCart(String productName) {

            driver.findElement(By.linkText(productName)).click();
            driver.findElement(By.id("add-to-cart-button")).click();
        }



    }

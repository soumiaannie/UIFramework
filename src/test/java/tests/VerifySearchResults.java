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

    public class VerifySearchResults extends BaseClass {



        @Test
        public void verifyResults(){



            driver.navigate().to("https://spree-vapasi.herokuapp.com");
            driver.findElement(By.id("link-to-login")).click();
            driver.findElement(By.id("spree_user_email")).sendKeys("spree@example.com");
            driver.findElement(By.id("spree_user_password")).sendKeys("spree123");
            driver.findElement(By.name("commit")).click();
            //assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
            driver.findElement(By.id("keywords")).sendKeys("bag");
            driver.findElement(By.xpath("//input[@value='Search']")).click();
            List<WebElement> results = driver.findElements(By.xpath("//div[@class='col-md-3 col-sm-6 col-xs-6 product-list-item']"));

            assertEquals(results.size(),2);

            assertTrue(results.get(0).getText().contains("Ruby on Rails Bag"), "First Product Exists");
            assertTrue(results.get(1).getText().contains("Spree Bag"), "Second Product Exists");
            //assertEquals(results.get(0).getText().contains("Ruby on Rails Bag"

            /*for(int i=0; i<results.size();i++)
            {
                assert
                String actualProductName=results.get(i).getText();
                System.out.println(actualProductName);
            }*/




        }



    }

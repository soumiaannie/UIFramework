package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.utilities.BaseClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

    public class VerifyDropdownContents extends BaseClass {


        @Test
        public void verifyDropdown(){

            driver.navigate().to("https://spree-vapasi.herokuapp.com");
            driver.findElement(By.id("link-to-login")).click();
            driver.findElement(By.id("spree_user_email")).sendKeys("spree@example.com");
            driver.findElement(By.id("spree_user_password")).sendKeys("spree123");
            driver.findElement(By.name("commit")).click();

            WebElement dropDown = driver.findElement(By.id("taxon"));
            Select mySelect = new Select(dropDown);
            List<WebElement> options = mySelect.getOptions();

            assertEquals(options.get(0).getAttribute("value"), "All departments");
            assertEquals(options.get(1).getAttribute("value"), "Categories");
            assertEquals(options.get(2).getAttribute("value"), "Brands");



        }



    }

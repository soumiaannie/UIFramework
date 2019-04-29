package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductDetailsPage {

    ChromeDriver driver;
    public ProductDetailsPage(ChromeDriver driver) {
        this.driver=driver;
    }


    public ShoppingCartPage addToCart() {

        driver.findElement(By.id("add-to-cart-button")).click();
        return new ShoppingCartPage(driver);
    }

    public void selectQuantity(String productQuantity)
    {
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys(productQuantity);
        //return new ProductDetailsPage(driver);
    }
}

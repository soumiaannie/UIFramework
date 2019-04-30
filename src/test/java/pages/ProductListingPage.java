package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class ProductListingPage {

    ChromeDriver driver;
    public ProductListingPage(ChromeDriver driver) {
        this.driver=driver;
    }



    public ProductDetailsPage selectProduct(String productName)
    {
        driver.findElement(By.linkText(productName)).click();
        return new ProductDetailsPage(driver);
    }





}

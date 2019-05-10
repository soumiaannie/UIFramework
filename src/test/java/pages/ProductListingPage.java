package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class ProductListingPage  {

    WebDriver driver;

    public ProductListingPage(WebDriver driver) {
        this.driver=driver;
    }

    public ProductDetailsPage selectProduct(String productName)
    {
        driver.findElement(By.linkText(productName)).click();
        return new ProductDetailsPage(driver);
    }





}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage  {

    WebDriver driver;

    @FindBy(id="add-to-cart-button")
    private WebElement add_To_Cart_Button;

    @FindBy(id="quantity")
    private WebElement quantityBox;

    public ProductDetailsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public ShoppingCartPage addToCart() {

        add_To_Cart_Button.click();
        return new ShoppingCartPage(driver);
    }

    public void selectQuantity(String productQuantity)
    {
        quantityBox.clear();
        quantityBox.sendKeys(productQuantity);
    }
}

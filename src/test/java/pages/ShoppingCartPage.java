package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import tests.utilities.CartDetails;

import java.util.ArrayList;
import java.util.List;



public class ShoppingCartPage  {

    WebDriver driver;

    @FindBy(id="cart-detail")
    private WebElement cartDetail;

    //@FindBys(@FindBy(id="cart-detail"),@FindBy(className = "line-item"))
    //private WebElement getCartElements;


    ArrayList<CartDetails> cartDetails = new ArrayList<CartDetails>();

    public ShoppingCartPage(WebDriver driver)
    {
     this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public List<WebElement> getCartElements() {
        return cartDetail.findElements(By.className("line-item"));
    }


    public String getActualProductNameDisplayedInCart() {
        return cartDetail.findElement(By.linkText("Ruby on Rails Bag")).getText();
    }

    public ArrayList<CartDetails> displayCartItems(List<WebElement> items) {
        for(int i=0; i<items.size();i++) {
            String name = items.get(i).findElement(By.className("cart-item-description")).findElement(By.tagName("a")).getText();
            //String quantity = items.get(i).findElement(By.className("cart-item-quantity")).findElement(By.className("form-control line_item_quantity")).getAttribute("value");
            String quantity="2";

            cartDetails.add(i, new CartDetails(name, quantity));
            System.out.println("The " + i + "th product name is" + name);
            System.out.println("The " + i + "th product quantity is" + quantity);
            System.out.println(cartDetails);

        }
        return cartDetails;
    }



}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.utilities.CartDetails;

import java.util.ArrayList;
import java.util.List;



public class ShoppingCartPage {

    ChromeDriver driver;
    ArrayList<CartDetails> cartDetails = new ArrayList<CartDetails>();

    public ShoppingCartPage(ChromeDriver driver)
    {
     this.driver=driver;
    }


    public List<WebElement> getCartElements() {
        return driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));
    }


    public String getActualProductNameDisplayedInCart() {
        return driver.findElement(By.id("cart-detail")).findElement(By.linkText("Ruby on Rails Bag")).getText();
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

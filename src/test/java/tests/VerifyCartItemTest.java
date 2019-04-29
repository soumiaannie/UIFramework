package tests;

import com.google.gson.Gson;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import tests.utilities.BaseClass;
import tests.utilities.CartDetails;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;


    public class VerifyCartItemTest extends BaseClass {

        @Test(groups="smoke")
        @Parameters("url")
        public void verifyCartItemTest(){

            ArrayList<CartDetails> expectedCartDetails= new ArrayList<CartDetails>();
            expectedCartDetails.add(0, new CartDetails("Ruby on Rails Bag", "2"));

            LoginPage loginPage=new LoginPage(driver);

            String productQuantity="2";

            ProductListingPage productListing= loginPage.login("spree@example.com", "spree123");

            ProductDetailsPage productDetails=productListing.selectProduct("Ruby on Rails Bag");
            productDetails.selectQuantity(productQuantity);
            ShoppingCartPage shoppingCart=productDetails.addToCart();

            List<WebElement> items = shoppingCart.getCartElements();

            assertEquals(items.size(), 1);

            //Printing out the product names from the cart
            ArrayList<CartDetails> actualCartDetails=shoppingCart.displayCartItems(items);
            String actualCartDetailsString=new Gson().toJson(actualCartDetails);
            String expectedCartDetailsString=new Gson().toJson(expectedCartDetails);
            //assertEquals(actualCartDetailsString,expectedCartDetailsString);
            assertEquals(actualCartDetailsString, expectedCartDetailsString);

        }

    }

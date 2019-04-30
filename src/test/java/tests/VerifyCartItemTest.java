package tests;

import com.google.gson.Gson;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import tests.utilities.BaseClass;
import tests.utilities.CartDetails;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;


    public class VerifyCartItemTest extends BaseClass {

        //@Test(groups="smoke")
        @Test(dataProvider = "getProductName", groups = "smoke")
        @Parameters("url")
        public void verifyCartItemTest(String productName, String productQuantity) {

            ArrayList<CartDetails> expectedCartDetails = new ArrayList<CartDetails>();
            expectedCartDetails.add(0, new CartDetails(productName, productQuantity));

            LoginPage loginPage = new LoginPage(driver);

            //String productQuantity = "2";

            ProductListingPage productListing = loginPage.login("spree@example.com", "spree123");

            ProductDetailsPage productDetails = productListing.selectProduct(productName);
            productDetails.selectQuantity(productQuantity);
            ShoppingCartPage shoppingCart = productDetails.addToCart();

            List<WebElement> items = shoppingCart.getCartElements();

            assertEquals(items.size(), 1);

            //Printing out the product names from the cart
            ArrayList<CartDetails> actualCartDetails = shoppingCart.displayCartItems(items);
            String actualCartDetailsString = new Gson().toJson(actualCartDetails);
            String expectedCartDetailsString = new Gson().toJson(expectedCartDetails);
            //assertEquals(actualCartDetailsString,expectedCartDetailsString);
            assertEquals(actualCartDetailsString, expectedCartDetailsString);

        }

        @DataProvider(name = "getProductName")
        public Object[][] getProductName() {
            return new Object[][]
                    {
                            {"Ruby on Rails Bag", "2"},
                            {"Ruby on Rails Tote", "2"}
                    };

        }
    }

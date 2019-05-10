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


        @Test(dataProvider = "getProductName", groups = "smoke")
        public void verifyCartItemTest(String productName, String productQuantity) {

            //Creating the expected cartdetails list using dataprovider
            ArrayList<CartDetails> expectedCartDetails = new ArrayList<CartDetails>();
            expectedCartDetails.add(0, new CartDetails(productName, productQuantity));

            //Logging in and adding item to cart by reading from dataprovider
            LoginPage loginPage = new LoginPage(driver, properties);
            ProductListingPage productListing = loginPage.navigateToURL();
            ProductDetailsPage productDetails = productListing.selectProduct(productName);
            productDetails.selectQuantity(productQuantity);
            ShoppingCartPage shoppingCart = productDetails.addToCart();

            //asserting the actual list count is as expected
            List<WebElement> items = shoppingCart.getCartElements();
            assertEquals(items.size(), 1);

            //Printing out the product names from the cart and asserting the expected and actual lists
            ArrayList<CartDetails> actualCartDetails = shoppingCart.displayCartItems(items);
            String actualCartDetailsString = new Gson().toJson(actualCartDetails);
            String expectedCartDetailsString = new Gson().toJson(expectedCartDetails);
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

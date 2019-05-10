package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.utilities.BaseClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseClass {


    @Test(groups="smoke")
    public void testLogin(){


        LoginPage loginPage = new LoginPage(driver, properties);
        loginPage.login("spree@example.com", "spree123");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        assertTrue(loginPage.isMy_account());

    }

    @Test(groups="smoke")
    public void newTest()
    {
        System.out.println("SecondTEst");

    }



}

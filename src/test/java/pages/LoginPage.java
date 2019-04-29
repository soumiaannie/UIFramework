package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage  {

    ChromeDriver driver;
    public LoginPage(ChromeDriver driver) {
        this.driver=driver;
    }

    public ProductListingPage login(String userName, String passWord) {
        driver.navigate().to("https://spree-vapasi.herokuapp.com/");
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(userName);
        driver.findElement(By.id("spree_user_password")).sendKeys(passWord);
        driver.findElement(By.name("commit")).click();
        return new ProductListingPage(driver);
    }

    public boolean isMy_account() {
        return driver.findElement(By.linkText("My Account")).isDisplayed();
    }

}

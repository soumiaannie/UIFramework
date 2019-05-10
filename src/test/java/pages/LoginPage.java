package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginPage  {

    WebDriver driver;
    Properties properties;

    @FindBy(id="link-to-login")
    private WebElement login_link;

    @FindBy(id="spree_user_email")
    private WebElement email;

    @FindBy(id="spree_user_password")
    private WebElement password;

    @FindBy(name="commit")
    private WebElement login;

    @FindBy(linkText ="My Account")
    private WebElement my_account_link;



    public LoginPage(WebDriver driver, Properties properties) {
        this.driver=driver;
        this.properties=properties;
        PageFactory.initElements(driver, this);
    }


    public ProductListingPage login(String userName, String passWord) {

        String url=properties.getProperty("url");
        driver.navigate().to(url);
        login_link.click();
        email.sendKeys(userName);
        password.sendKeys(passWord);
        login.click();
        return new ProductListingPage(driver);
    }


    public boolean isMy_account() {

        return my_account_link.isDisplayed();
    }

    //This method navigates to url without logging in
    //This will be used by later testcases for assertions as assertions would fail if we login
    //and then try to do it. This is because many users login at the same time using same credentials.
    public ProductListingPage navigateToURL()
    {
        String url=properties.getProperty("url");
        driver.navigate().to(url);
        return new ProductListingPage(driver);
    }

}

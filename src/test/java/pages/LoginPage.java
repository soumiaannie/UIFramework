package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

    ChromeDriver driver;

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



    public LoginPage(ChromeDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public ProductListingPage login(String userName, String passWord) {
        driver.navigate().to("https://spree-vapasi.herokuapp.com/");
        //login_link.click();
        //email.sendKeys(userName);
        //password.sendKeys(passWord);
        //login.click();
        return new ProductListingPage(driver);
    }

    public boolean isMy_account() {
        return my_account_link.isDisplayed();
    }

}

package tests.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver;
    protected Properties properties;

    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("Iam about to run a suite");
    }


    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Iam going to start running a set of clases belonging to a test tag in testNG");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("Iam going to start running a new class belonging to a test");
    }


    @BeforeMethod(alwaysRun = true)
    public void setUp()
    {
        System.out.println("setUp");

        //Initialising values from properties file
        FileInputStream fileInputStream = null;
        String currentUsersWorkingDir = System.getProperty("user.dir");
        System.out.println("Dir is " + currentUsersWorkingDir);

        try {
            fileInputStream = new FileInputStream(currentUsersWorkingDir + "/src/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        properties = new Properties();

        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }



        //Creating driver objects based on the driver value assigned in config.properties

        if (properties.getProperty("driver").equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver",currentUsersWorkingDir+"/src/test/resources/chromedriver");
            driver = new ChromeDriver();
        }
        else if (properties.getProperty("driver").equals("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver",currentUsersWorkingDir+"/src/test/resources/geckodriver");
            driver = new FirefoxDriver();
        }



        //Setting implicit wait for all WebElements
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        System.out.println("TearDown");
        driver.close();
        //driver.quit();
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("Iam done with running a new class belonging to a test");
    }


    @AfterTest
    public void afterTest()
    {
        System.out.println("Iam done with running a set of clases belonging to a test tag in testNG");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("Iam done with the test suite run");
    }


}

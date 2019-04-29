package tests.utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public ChromeDriver driver;

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
        //ChromeDriver driver;
        System.out.println("setUp");
        String currentUsersWorkingDir = System.getProperty("user.dir");
        System.out.println("Dir is " + currentUsersWorkingDir);
        System.setProperty("webdriver.chrome.driver",currentUsersWorkingDir+"/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        System.out.println("TearDown");
        driver.close();
        driver.quit();
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

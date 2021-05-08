package automate1.tests;

import automatenow.pages.BasePage;
import automatenow.pages.HomePage;
import automatenow.pages.NavigationBar;
import automatenow.pages.SandboxPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends BasePage {

    protected NavigationBar navigationBar;
    protected HomePage homePage;
    protected SandboxPage sandboxPage;

    @BeforeSuite
    public void setup() {
        // Navigate to home page
        Assert.assertTrue(goToHomePage(), "An error occurred while navigating to home page!!!");
        navigationBar = new NavigationBar();
        homePage = new HomePage();
        sandboxPage = new SandboxPage();
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}

package automate1.tests;

import automatenow.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest{

    HomePage homePage = new HomePage();

    @Test(description = "Verify page title")
    public void testHomePageTitle() {
        String homePageTitle = homePage.getPageTitle();
        assertEquals(homePageTitle,
                "AUTOMATENOW – A place for learning software automated testing.",
                "Wrong home page title!!!");
    }

    @Test(description = "Verify welcome message")
    public void welcomeTitleHomePage() {
        String welcomeTitle = homePage.getWelcomeMessage();
//        Assert.assertEquals(welcomeTitle, "Welcome to AUTOMATENOW", "Wrong title!");
        assertTrue(welcomeTitle.contains("Welcome to AUTOMATENOW"), "Welcome message did not match!!!");

    }
}

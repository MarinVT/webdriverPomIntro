package automatenow.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private By welcomeMsg = By.xpath("//span[contains(text(),'Welcome to AUTOMATENOW')]");


    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMsg).getText();
    }
}

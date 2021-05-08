package automatenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBar extends BasePage {

    private By sandboxObj = By.xpath("//a[contains(text(),'Sandbox')]");
    private By vlog1 = By.xpath("//a[contains(text(),'Vlog')]");
    private By menuItems = By.xpath("//a[contains(text(),'Intro to Selenium WebDriver')]");

    public SandboxPage selectSandbox() {
        driver.findElement(sandboxObj).click();
        return new SandboxPage();
    }

    public void selectDropdownMenuItem() {
        hoverOverElement(vlog1);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuItems)).click();
    }
}

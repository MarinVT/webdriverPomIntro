package automatenow.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class BasePage {
    protected static WebDriver driver;

    public String browser;
    public String baseUrl;
    public Properties properties;

    private void loadProperties() {
        FileInputStream fileInputStream = null;

        try {
            properties = new Properties();
            fileInputStream = new FileInputStream("C:\\Users\\acer\\Desktop\\pom\\webdriverintro\\src\\main\\java\\automatenow\\config\\config.properties");
            properties.load(fileInputStream);

            browser = properties.getProperty("browser");
            baseUrl = properties.getProperty("baseUrl");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void openBrowser() {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void windowCloseBrowser() {
        driver.close();
    }

    public Boolean goToHomePage() {
        try {
            loadProperties();
            openBrowser();
            driver.get(baseUrl);
        } catch (Exception e) {
            System.out.println("Unable to navigate to homepage!!!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void setText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        tab(locator);
    }

    public void tab(By locator) {
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    public String getText(By locator) {
        String displayText = driver.findElement(locator).getText();

        if (displayText.isEmpty()){
            return driver.findElement(locator).getAttribute("value");
        } else {
            return displayText;
        }
    }

    public void chooseCategory(By locator) {
        driver.findElement(locator).click();
    }

    public void clickMethod(By locator) {
        driver.findElement(locator).click();
    }

    public void goBackMethod() {
        driver.navigate().back();
    }

    public void clearInputField(By locator) {
        driver.findElement(locator).clear();
    }


    public String getWindowHandler() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandlers() {
        return driver.getWindowHandles();
    }

    public int getNumberOfOpenWindows() { return driver.getWindowHandles().size(); }

    public void openNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void dragAndDropMethod(By locator, int x, int y) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.dragAndDropBy(element, x, y).perform();
    }

    public void dismissPop() { driver.switchTo().alert().dismiss(); }
    public void acceptPop() { driver.switchTo().alert().accept(); }

    public void setAlertPromptText(String inputText) {
        driver.switchTo().alert().sendKeys(inputText);
    }

    public void waitForSpecificElementAppear(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void hoverOverElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}

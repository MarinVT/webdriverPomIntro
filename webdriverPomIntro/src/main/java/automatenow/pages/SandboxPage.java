package automatenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class SandboxPage extends  BasePage {

    private By inputField = By.cssSelector("#g1103-inputfield");
    private By formFieldLinkLocator = By.xpath("//a[contains(text(),'Form Fields')]");
    private By tableFormLocator = By.xpath("//a[contains(text(),'Tables')]");
    private By selectDropdown = By.cssSelector("#g1103-dropdownmenu");
    private By calendarFieldLocator = By.xpath("//a[contains(text(),'Calendars')]");
    //Window Operation button and sub locators
    private By windowOperationsBtnLocator = By.xpath("//a[contains(text(),'Window Operations')]");
    private By facebookBtnIcon = By.xpath("//body/div[@id='page']/div[@id='content']/section[@id='primary']/main[@id='main']/article[@id='post-1147']/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]");

    // Gestures drag and drop locators
    private By mapLocator = By.tagName("canvas");

    // Popups button locators
    private By popUpBTNlocator = By.xpath("//a[contains(text(),'Popups')]");
    private By alertBTNlocator = By.id("alert");
    private By confirmBTNlocator = By.id("confirm");
    private By resultConfirmBTNlocator = By.id("confirmResult");
    private By promptBTNlocator = By.id("prompt");
    private By promptPopResult = By.id("promptResult");

    //search box locator and search button locator
    private By searchBoxFieldLocator = By.xpath("//a[contains(text(),'Search Boxes')]");
    private By searchInputField = By.xpath("//input[@id='wp-block-search__input-1']");
    private By searchBtnLocator = By.id("wp-block-search__input-1");

    //private By noSearchResult = By.xpath("//h1[text()='Nothing Found']");
    private By searchBoxPage = By.xpath("//h1[contains(text(),'Search Boxes')]");

    // Gestures button locator
    private By gesturesBTN = By.xpath("//a[contains(text(),'Gestures')]");

    // calendar locators
    private By yearCalendarLocator = By.xpath("//span[@class='ui-datepicker-year']");
    private By monthCalendarLocator = By.xpath("//span[@class='ui-datepicker-month']");
    private By calendarInputFieldLoc = By.cssSelector("#g1065-selectorenteradate");
    private By calendarArrowRight = By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/a[2]");

    //Modal button locators
    private By modalMainBTNLocator = By.xpath("//a[contains(text(),'Modals')]");
    private By formModalBTN = By.id("formModal");
    private By modalPopupNameField = By.id("g1051-name");
    private By modalPopupEmailField = By.id("g1051-email");
    private By modalPopupMessageField = By.id("contact-form-comment-g1051-message");
    private By modalPopupSubmitField = By.xpath("//button[contains(text(),'Submit')]");

    // Hover main button locatos
    private By hoverMainButtonLocator = By.xpath("//a[contains(text(),'Hover')]");
    private By hoverFieldLocator = By.id("mouse_over");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public SandboxPage formMainButton() {
        chooseCategory(formFieldLinkLocator);
        return null;
    }

    public SandboxPage tableMainButton() {
        chooseCategory(tableFormLocator);
        return null;
    }

    public SandboxPage calendarMainButton() {
        chooseCategory(calendarFieldLocator);
        return null;
    }

    public SandboxPage searchBoxesMainButton() {
        chooseCategory(searchBoxFieldLocator);
        return null;
    }

    public SandboxPage gesturesMainButton() {
        chooseCategory(gesturesBTN);
        return null;
    }

    public SandboxPage modalMainButton() {
        chooseCategory(modalMainBTNLocator);
        return null;
    }

    public SandboxPage hoverMainButton() {
        chooseCategory(hoverMainButtonLocator);
        return null;
    }

    public SandboxPage windowOperations() {
        chooseCategory(windowOperationsBtnLocator);
        return null;
    }

    public SandboxPage popUpsButton() {
        chooseCategory(popUpBTNlocator);
        return null;
    }

    public SandboxPage setInputFieldText(String myTextInput) {
        setText(inputField, myTextInput);
        return null;
    }

    public String getInputFieldText() {
        return getText(inputField);
    }

    /**
     * Selects checkbox
     * @param option Range is 1 to 3
     * @return
     */

    public SandboxPage selectCheckbox(String option) {
        driver.findElement(By.xpath("//input[@value='Option " + option +"']")).click();
        return null;
    }

    public boolean checkboxIsSelected(String option) {
        return driver.findElement(By.xpath("//input[@value='Option " + option + "']")).isSelected();
    }

    /**
     * Select from dropdown option
     * @param selectOption Displayed text
     * @return
     */
    public SandboxPage selectDropdownSandbox(String selectOption) {
        Select dropDownSelect = new Select(driver.findElement(selectDropdown));
        dropDownSelect.selectByVisibleText(selectOption);
        return this;
    }

    public String getDropdownText() {
        Select dropDownSelect = new Select(driver.findElement(selectDropdown));
        return dropDownSelect.getFirstSelectedOption().getText();
    }

    /**
     * Selects radio button
     * @param radioBtnChoice case sensitive value
     * @return
     */
    public SandboxPage selectRadioBtn(String radioBtnChoice) {
        driver.findElement(By.cssSelector("input[value='" + radioBtnChoice + "']")).click();
        return this;
    }

    public boolean radioBtnSelected(String radioBtnChoice) {
        return driver.findElement(By.cssSelector("input[value='" + radioBtnChoice + "']")).isSelected();
    }

    public String getItemPrice(String item) {
        return driver.findElement(By.xpath("//td[text()='" + item + "']/following-sibling::td")).getText();
    }

    public SandboxPage selectDate(String month, String day, String year) {
        driver.findElement(calendarInputFieldLoc).click();

        while (true) {
            String currencMonth = getText(monthCalendarLocator);
            String currencYear = getText(yearCalendarLocator);

            if (currencMonth.equals(month) && currencYear.equals(year)) {
                break;
            }
            driver.findElement(calendarArrowRight).click();
        }

        driver.findElement(By.xpath("//table//a[text()='" + day + "']")).click();
        return this;
    }

    public String getDate() {
        return getText(calendarInputFieldLoc);
    }

    public boolean searchBlog(String textSearch) {
        setText(searchInputField, textSearch);
        clickMethod(searchBtnLocator);

        if (driver.findElements(searchBoxPage).size() > 0) {
            goBackMethod();
            return false;
        }
        return true;
    }

    public void clickFacebook() {
        clickMethod(facebookBtnIcon);
    }

    public void switchToNewWindow() {
        // Get current window handle
        String currentWindow = getWindowHandler();
        // Get all window handles
        Set<String> handlesWindows = getWindowHandlers();
        // Switch to new window
        Iterator<String> iterator = handlesWindows.iterator();
        String newWindow = null;

        while (iterator.hasNext()) {
            newWindow = iterator.next();

            if (!currentWindow.equals(newWindow)) {
                driver.switchTo().window(newWindow);
            }
        }
    }

    public void dragMap(int x_coordinates, int y_coordinates) {
        dragAndDropMethod(mapLocator, x_coordinates, y_coordinates);
    }

    public void clickAlertPopupBTN() {
        clickMethod(alertBTNlocator); }

    public void confirmPopupButton() {
        clickMethod(confirmBTNlocator);
    }

    public String getConfirmPopUpSelection() {
        return getText(resultConfirmBTNlocator);
    }

    public void clickOnPromptBTN() { clickMethod(promptBTNlocator); }

    public void waitForPromptResult(String expectedText) {
        waitForSpecificElementAppear(promptPopResult, expectedText);
    }

    public SandboxPage openModal() {
        clickMethod(formModalBTN);
        return this;
    }

    public SandboxPage modalSendMessage(String name, String email, String message) {
        setText(modalPopupNameField, name);
        setText(modalPopupEmailField, email);
        setText(modalPopupMessageField, message);
        clickMethod(modalPopupSubmitField);
        return this;
    }

    public SandboxPage doHover() {
        hoverOverElement(hoverFieldLocator);
        return this;
    }

    public String getHoverText() {
        return getText(hoverFieldLocator);
    }

    /**
     * Scrolls the document by the number of pixels
     *
     * @param x_pixels
     * @param y_pixels
     */
    public void scrollPageSandBox(int x_pixels, int y_pixels) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(" + x_pixels + "," +y_pixels +");");
    }
}

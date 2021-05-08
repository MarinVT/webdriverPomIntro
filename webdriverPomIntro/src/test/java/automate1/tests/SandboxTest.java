package automate1.tests;

import automatenow.pages.SandboxPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SandboxTest extends BaseTest{

    @BeforeClass
    public void testNavigateToSandboxPage() {
        navigationBar.selectSandbox();
    }

    @Test(priority = 1, description = "Verify page title")
    public void testPageTitle() {
        String title = sandboxPage.getPageTitle();
        assertEquals(title, "Sandbox – AUTOMATENOW", "Page title did not match!!!");
    }

    @Test(priority = 2, description = "Enters text in an input field")
    public void testEnterText() {
        sandboxPage.formMainButton();
        String myTextInput = "hello";
        sandboxPage.setInputFieldText(myTextInput);
        String displayText = sandboxPage.getInputFieldText();
        assertEquals(displayText, myTextInput, "Unable to verify entered text!!!");
    }

    @Test(priority = 3, description = "Checks a checkbox")
    public void testCheckbox() {
        sandboxPage.formMainButton();
        sandboxPage.selectCheckbox("1");
        assertTrue(sandboxPage.checkboxIsSelected("1"), "Checkbox is not selected!!!");
    }

    @Test(priority = 4, description = "Select from a dropdown")
    public void selectFromDropdown() {
        String mySelectedOption = "Binary";
        sandboxPage.formMainButton();
        sandboxPage.selectDropdownSandbox("Binary");
        assertEquals(sandboxPage.getDropdownText(), mySelectedOption, "Dropdown option is not selected!!!");
    }

    @Test(priority = 5, description = "Select a radio button")
    public void selectRadioBtn() {
        String radioBtnChoice = "White";
        sandboxPage.formMainButton();
        sandboxPage.selectRadioBtn("White");
        assertTrue(sandboxPage.radioBtnSelected(radioBtnChoice), "Radio button is not selected!");
    }

    @Test(priority = 6, description = "Select an item from table")
    public void testItemPrice() {
        sandboxPage.tableMainButton();
        String itemPrice = sandboxPage.getItemPrice("Laptop");
        assertEquals(itemPrice, "$1200.00");

        String itemPrice1 = sandboxPage.getItemPrice("Oranges");
        assertEquals(itemPrice1, "$3.99");
    }

    @Test(priority = 7, description = "select date from calendar")
    public void testSelectDateCalendar() {
        sandboxPage.calendarMainButton();
        sandboxPage.selectDate("May", "5", "2021");
        String date = sandboxPage.getDate();

        assertEquals(date, "May 5, 2021", "Mismatch between dates!!!");
    }

    @Test(priority = 8, description = "Search for a blog article")
    public void testBlogSearch() {
        sandboxPage.searchBoxesMainButton();
        boolean search;
        search = sandboxPage.searchBlog("aaaa");
        assertFalse(search, "Did not expect to find a search result!!!");
    }

    @Test(priority = 9, description = "Handles multiple windows")
    public void testMultipleOpenWindows()  {
        sandboxPage.windowOperations();
        sandboxPage.clickFacebook();
        sandboxPage.switchToNewWindow();
        String titlePage = sandboxPage.getPageTitle();
        System.out.println(titlePage);
        assertTrue(titlePage.contains("Facebook"), "The new window has no match!!!");
    }

    @Test(description = "Close a second open window")
    public void testCloseSecondWindow() {
        sandboxPage.windowOperations();
        sandboxPage.clickFacebook();
        windowCloseBrowser();
        int numberOfOpenWindows = getNumberOfOpenWindows();
        assertEquals(numberOfOpenWindows, 1);
    }

    @Test(description = "Working with multiple tabs")
    public void testMultipleTabs() {
        openNewTab();
        sandboxPage.switchToNewWindow();
        goToUrl("https://www.nasa.gov");
        String pageTitle = getPageTitle();
        assertEquals(pageTitle, "NASA", "The page title for new window did not match!!!");
        windowCloseBrowser();
    }

    @Test(description = "gestures testing - drag and drop")
    public void testGestures() {
        sandboxPage.gesturesMainButton();
        // Pixels coordinates
        int x_coordinates = 300;
        int y_coordinates = 100;

        sandboxPage.dragMap(x_coordinates, y_coordinates);
    }

    @Test(description = "Test popup windows")
    public void testPopUps() {
        sandboxPage.popUpsButton();
//        sandboxPage.clickAlertPopupBTN();
//        dismissPop();

        sandboxPage.confirmPopupButton();
        acceptPop();
        String selectPopupWindowResult = sandboxPage.getConfirmPopUpSelection();
        assertEquals(selectPopupWindowResult, "OK it is!", "The popup selection result does not match");

    }

    @Test(description = "Testing promt window popup")
    public void testPrompPopupWindow() {
        sandboxPage.popUpsButton();
        String name = "Marco1";
        sandboxPage.clickOnPromptBTN();
        setAlertPromptText(name);
        acceptPop();
        sandboxPage.waitForPromptResult(String.format("Nice to meet you %s!", name));
    }

    @Test(description = "Test modal popup window")
    public void testModalPopupWindow() {
        sandboxPage.modalMainButton();
        String name = "Marco";
        String email = "marco@abv.bg";
        String message = "Marco test 121";
        sandboxPage.openModal();
        sandboxPage.modalSendMessage(name, email, message);
    }

    @Test(description = "Hover main button - Test hover effect")
    public void testHoverEffect() {
        sandboxPage.hoverMainButton();
        sandboxPage.doHover();
        String hoverText = sandboxPage.getHoverText();
        assertEquals(hoverText, "You did it!");
    }

    @Test(description = "Test scroll effect")
    public void testScrollEffect() {
        sandboxPage.scrollPageSandBox(0, 300);
    }

    @Test(description = "Test sub menu and select specific item")
    public void testDropDownMenu() {
        navigationBar.selectDropdownMenuItem();
    }
}

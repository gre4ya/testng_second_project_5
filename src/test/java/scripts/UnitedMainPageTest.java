package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;
import pages.UnitedHeaderPage;
import pages.UnitedMainPage;
import utilities.DropdownHandler;
import utilities.Waiter;
import utilities.WindowHandler;

import javax.swing.*;
import java.util.List;
import java.util.stream.IntStream;

public class UnitedMainPageTest extends UnitedBase{

    @BeforeMethod
    public void setPage(){
        unitedBasePage = new UnitedBasePage();
        unitedMainPage = new UnitedMainPage();
    }
    /**
     Test Case 2: Validate "Book travel menu" navigation items
     Given user is on "https://www.united.com/en/us"
     Then user should see "Book travel menu" navigation items
     | Book | Flight status | Check-in | My trips |
     */
    @Test(priority = 1, description = "Validation of Book travel menu navigation items")
    public void validateBookTravelManuNavigationItems(){
        String[] bookTravelManuItemsExpected = {
                "Book",
                "Flight status",
                "Check-in",
                "My trips"};
        IntStream.range(0, unitedMainPage.bookTravelManuItems.size()).forEach(i -> {
            Assert.assertTrue(unitedMainPage.bookTravelManuItems.get(i).isDisplayed());
            Assert.assertEquals(unitedMainPage.bookTravelManuItems.get(i).getText(),
                    bookTravelManuItemsExpected[i]);
        });
    }
    /**
     Test Case 3: Validate "Round-trip" and "One-way" radio buttons
     Given user is on "https://www.united.com/en/us"
     Then validate "Roundtrip" radio button is displayed, is enabled and is selected
     And validate "One-way" radio button is displayed, is enabled but is not selected
     When user clicks on "One-way" radio button
     Then validate "One-way" radio button is selected while "Roundtrip" radio button is
     deselected
     */
    @Test(priority = 2, description = "Validation of 'Round-trip' and 'One-way' radio buttons")
    public void validateRadioButtons(){
        IntStream.range(0, unitedMainPage.radioButtonsInput.size()).forEach(i -> {
            Assert.assertTrue(unitedMainPage.radioButtonsLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedMainPage.radioButtonsInput.get(i).isEnabled());
        });
        Assert.assertTrue(unitedMainPage.radioButtonsInput.get(0).isSelected());
        Assert.assertFalse(unitedMainPage.radioButtonsInput.get(1).isSelected());
        unitedMainPage.radioButtonsInput.get(1).click();
        Assert.assertTrue(unitedMainPage.radioButtonsInput.get(1).isSelected());
        Assert.assertFalse(unitedMainPage.radioButtonsInput.get(0).isSelected());
    }
    /**
     Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
     Given user is on "https://www.united.com/en/us"
     Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
     And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
     When user clicks both checkboxes
     Then validate both checkboxes are selected
     When user clicks on both selected checkboxes again
     Then validate both checkboxes are deselected
     */
    @Test(priority = 3, description = "Validation of 'Book with miles' and 'Flexible dates' checkboxes")
    public void validateCheckBoxes(){
        Assert.assertTrue(unitedMainPage.bookWithMilesCheckBoxLabel.isDisplayed());
        Assert.assertTrue(unitedMainPage.bookWithMilesCheckBoxInput.isEnabled());
        Assert.assertFalse(unitedMainPage.bookWithMilesCheckBoxInput.isSelected());

        Assert.assertTrue(unitedMainPage.flexibleDatesCheckBoxLabel.isDisplayed());
        Assert.assertTrue(unitedMainPage.flexibleDatesCheckBoxInput.isEnabled());
        Assert.assertFalse(unitedMainPage.flexibleDatesCheckBoxInput.isSelected());

        unitedMainPage.flexibleDatesCheckBoxLabel.click();
        unitedMainPage.bookWithMilesCheckBoxLabel.click();

        Assert.assertTrue(unitedMainPage.bookWithMilesCheckBoxInput.isSelected());
        Assert.assertTrue(unitedMainPage.flexibleDatesCheckBoxInput.isSelected());

        unitedMainPage.flexibleDatesCheckBoxLabel.click();
        unitedMainPage.bookWithMilesCheckBoxLabel.click();

        Assert.assertFalse(unitedMainPage.bookWithMilesCheckBoxInput.isSelected());
        Assert.assertFalse(unitedMainPage.flexibleDatesCheckBoxInput.isSelected());
    }
    /**
     Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to
     Miami, FL, US (MIA)”
     Given user is on "https://www.united.com/en/us"
     When user selects "One-way" ticket radio button
     And user enters "Chicago, IL, US (ORD)" to from input box
     And user enters "Miami, FL, US (MIA)" to input box
     And user selects "Feb 28" to the dates input box
     And user selects "2 Adults" from travelers selector
     And user selects "Business or First" from cabin dropdown
     And user clicks on "Find Flights" button
     Then validate departure equals to "DEPART ON: February 28"
     */

    @Test(priority = 4)
    public void validateOneWayTicketSearch(){
        unitedMainPage.radioButtonsInput.get(1).click();
        Waiter.pause(5);
        unitedMainPage.flightOriginInput.sendKeys("Chicago, IL, US (ORD)");
        Waiter.pause(5);
        unitedMainPage.flightDestinationInput.sendKeys("Miami, FL, US (MIA)");
        Waiter.pause(5);
        WebElement monthGrid = driver.findElement(By.cssSelector("input[class*='DateInput_input']"));
        monthGrid.click();
        Waiter.pause(5);
        driver.findElement(By.cssSelector("button[class*='1CBAY']")).click();
        Waiter.pause(5);
        List<WebElement> allDates =
                driver.findElements(By.xpath("//div[contains(@class, 'CalendarMonth_caption')]//*[text()='February 2023']/../..//tbody//td"));
        for (WebElement date : allDates) {
            if(date.getText().equals("28")) {
                date.click();
                break;
            }
        }
        Waiter.pause(5);
        unitedMainPage.travelersSelectorButton.click();
        Waiter.pause(5);
        unitedMainPage.travelersSelectorInput.sendKeys("2");
        DropdownHandler.clickOnDropdownOption(
                unitedMainPage.cabinType, unitedMainPage.cabinDropdownOptions, "Business or First");
        unitedMainPage.findFlightsButton.click();
        Waiter.pause(5);
        WindowHandler.switchToChildWindow();
        Waiter.pause(5);
        Assert.assertEquals(unitedFlightSearchResultPage.dateSearchResultHeader.getText(),
                "DEPART ON: February 28");
        Waiter.pause(5);
        driver.close();
        WindowHandler.switchBackToParentWindow();
    }
}

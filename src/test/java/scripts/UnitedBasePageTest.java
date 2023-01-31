package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;
import pages.UnitedFlightSearchResultPage;
import utilities.DropdownHandler;
import utilities.WindowHandler;

import java.util.stream.IntStream;

public class UnitedBasePageTest extends UnitedBase{

    @BeforeMethod
    public void setPage(){
        unitedBasePage = new UnitedBasePage();
        unitedFlightSearchResultPage = new UnitedFlightSearchResultPage();
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
        IntStream.range(0, unitedBasePage.bookTravelManuItems.size()).forEach(i -> {
            Assert.assertTrue(unitedBasePage.bookTravelManuItems.get(i).isDisplayed());
            Assert.assertEquals(unitedBasePage.bookTravelManuItems.get(i).getText(),
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
        IntStream.range(0, unitedBasePage.radioButtonsInput.size()).forEach(i -> {
            Assert.assertTrue(unitedBasePage.radioButtonsLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedBasePage.radioButtonsInput.get(i).isEnabled());
        });
        Assert.assertTrue(unitedBasePage.radioButtonsInput.get(0).isSelected());
        Assert.assertFalse(unitedBasePage.radioButtonsInput.get(1).isSelected());

        unitedBasePage.radioButtonsInput.get(1).click();

        Assert.assertTrue(unitedBasePage.radioButtonsInput.get(1).isSelected());
        Assert.assertFalse(unitedBasePage.radioButtonsInput.get(0).isSelected());
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
        Assert.assertTrue(unitedBasePage.bookWithMilesCheckBoxLabel.isDisplayed());
        Assert.assertTrue(unitedBasePage.bookWithMilesCheckBoxInput.isEnabled());
        Assert.assertFalse(unitedBasePage.bookWithMilesCheckBoxInput.isSelected());

        Assert.assertTrue(unitedBasePage.flexibleDatesCheckBoxLabel.isDisplayed());
        Assert.assertTrue(unitedBasePage.flexibleDatesCheckBoxInput.isEnabled());
        Assert.assertFalse(unitedBasePage.flexibleDatesCheckBoxInput.isSelected());

        unitedBasePage.flexibleDatesCheckBoxLabel.click();
        unitedBasePage.bookWithMilesCheckBoxLabel.click();

        Assert.assertTrue(unitedBasePage.bookWithMilesCheckBoxInput.isSelected());
        Assert.assertTrue(unitedBasePage.flexibleDatesCheckBoxInput.isSelected());

        unitedBasePage.flexibleDatesCheckBoxLabel.click();
        unitedBasePage.bookWithMilesCheckBoxLabel.click();

        Assert.assertFalse(unitedBasePage.bookWithMilesCheckBoxInput.isSelected());
        Assert.assertFalse(unitedBasePage.flexibleDatesCheckBoxInput.isSelected());
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
        unitedBasePage.radioButtonsInput.get(1).click();
        unitedBasePage.flightOriginInput.clear();

        unitedBasePage.flightOriginInput.sendKeys("Chicago, IL, US (ORD)");
        unitedBasePage.flightDestinationInput.clear();

        unitedBasePage.flightDestinationInput.sendKeys("Miami, FL, US (MIA)");
        unitedBasePage.departDateInput.clear();

        unitedBasePage.departDateInput.sendKeys("Feb 28");
        unitedBasePage.departDateInput.click();

//        WebElement monthGrid = driver.findElement(By.cssSelector("input[class*='DateInput_input']"));
//        List<WebElement> allDates =
//                driver.findElements(By.xpath("//div[contains(@class, 'CalendarMonth_caption')]//*[text()='February 2023']/../..//tbody//td"));

        unitedBasePage.travelersSelectorButton.click();
        unitedBasePage.travelersSelectorInput.sendKeys("2");

        DropdownHandler.clickOnDropdownOption(
                unitedBasePage.cabinType, unitedBasePage.cabinDropdownOptions, "Business or First");
        unitedBasePage.findFlightsButton.click();

        WindowHandler.switchToChildWindow();
        Assert.assertEquals(unitedFlightSearchResultPage.dateSearchResultHeader.getText(),
                "DEPART ON: February 28");
    }
}

package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;
import pages.UnitedHeaderPage;
import pages.UnitedMainPage;

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
}

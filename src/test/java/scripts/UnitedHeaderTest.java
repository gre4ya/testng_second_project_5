package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;
import pages.UnitedHeaderPage;

import java.util.stream.IntStream;

public class UnitedHeaderTest extends UnitedBase{
    @BeforeMethod
    public void setPage(){
        unitedBasePage = new UnitedBasePage();
        unitedHeaderPage = new UnitedHeaderPage();
    }
    /**
     Test Case 1: Validate "Main menu" navigation items
     Given user is on "https://www.united.com/en/us"
     Then user should see “Main menu” navigation items
     | BOOK | MY TRIPS | TRAVEL INFO | MILEAGEPLUS® PROGRAM | DEALS | HELP |
     */
    @Test(priority = 1,  description = "Validate Main menu navigation items")
    public void validateMainManuNavigationItems(){
        String[] navigationItemsExpected = {
                "BOOK",
                "MY TRIPS",
                "TRAVEL INFO",
                "MILEAGEPLUS® PROGRAM",
                "DEALS",
                "HELP"};
        IntStream.range(0, unitedHeaderPage.navigationItems.size()).forEach(i -> {
            Assert.assertTrue(unitedHeaderPage.navigationItems.get(i).isDisplayed());
            Assert.assertEquals(unitedHeaderPage.navigationItems.get(i).getText(),
                    navigationItemsExpected[i]);
        });
    }
}

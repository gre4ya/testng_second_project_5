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

     Test Case 3: Validate "Round-trip" and "One-way" radio buttons
     Given user is on "https://www.united.com/en/us"
     Then validate "Roundtrip" radio button is displayed, is enabled and is selected
     And validate "One-way" radio button is displayed, is enabled but is not selected
     */
    @Test(priority = 1, description = "Validate Book travel menu navigation items")
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
}

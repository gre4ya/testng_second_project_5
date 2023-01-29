package scripts;

import org.testng.annotations.BeforeMethod;
import pages.UnitedBasePage;
import pages.UnitedFlightSearchResultPage;
import pages.UnitedMainPage;

public class UnitedFlightSearchResultTest extends UnitedBase{

    @BeforeMethod
    public void setPage(){
        unitedMainPage = new UnitedMainPage();
        unitedBasePage = new UnitedBasePage();
        unitedFlightSearchResultPage = new UnitedFlightSearchResultPage();
    }

    /**
     Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to
     Miami, FL, US (MIA)”
     Given user is on "https://www.united.com/en/us"
     When user selects "One-way" ticket radio button
     And user enters "Chicago, IL, US (ORD)" to from input box
     And user enters "Miami, FL, US (MIA)" to to input box
     And user selects "Feb 28" to the dates input box
     And user selects "2 Adults" from travelers selector
     And user selects "Business or First" from cabin dropdown
     And user clicks on "Find Flights" button
     Then validate departure equals to "DEPART ON: February 28"
     */
}

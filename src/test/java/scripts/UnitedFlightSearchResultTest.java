package scripts;

import org.testng.annotations.BeforeMethod;
import pages.UnitedBasePage;
import pages.UnitedFlightSearchResultPage;

public class UnitedFlightSearchResultTest extends UnitedBase{

    @BeforeMethod
    public void setPage(){
        unitedBasePage = new UnitedBasePage();
        unitedFlightSearchResultPage = new UnitedFlightSearchResultPage();
    }
}

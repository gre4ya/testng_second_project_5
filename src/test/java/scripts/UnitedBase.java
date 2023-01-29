package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.UnitedBasePage;
import pages.UnitedFlightSearchResultPage;
import pages.UnitedHeaderPage;
import pages.UnitedMainPage;
import utilities.ConfigReader;
import utilities.Driver;

public class UnitedBase {
    WebDriver driver;
    UnitedBasePage unitedBasePage;
    UnitedHeaderPage unitedHeaderPage;
    UnitedMainPage unitedMainPage;
    UnitedFlightSearchResultPage unitedFlightSearchResultPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        unitedBasePage = new UnitedBasePage();
    }
    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}

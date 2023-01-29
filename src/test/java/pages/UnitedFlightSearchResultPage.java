package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnitedFlightSearchResultPage extends UnitedBasePage{
    public UnitedFlightSearchResultPage(){super();}

    @FindBy(css = "div[class*='3_5-b']>div")
    public WebElement dateSearchResultHeader;
}

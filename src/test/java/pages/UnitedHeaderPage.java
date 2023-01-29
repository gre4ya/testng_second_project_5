package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UnitedHeaderPage extends UnitedBasePage{
    public UnitedHeaderPage(){super();}

    @FindBy(css = "div[class*='3SjnI'] a")
    public List<WebElement> navigationItems;

}

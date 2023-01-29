package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UnitedMainPage extends UnitedBasePage{
    public UnitedMainPage(){super();}

    @FindBy(css = "ul[class*='3RNBj'] li")
    public List<WebElement> bookTravelManuItems;
}

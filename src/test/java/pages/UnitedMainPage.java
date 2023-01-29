package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UnitedMainPage extends UnitedBasePage{
    public UnitedMainPage(){super();}

    @FindBy(css = "ul[class*='3RNBj'] li")
    public List<WebElement> bookTravelManuItems;
    @FindBy(css = "div[class*='3WXQM'] input")
    public List<WebElement> radioButtonsInput;
    @FindBy(css = "label[class*='VrnUD']")
    public List<WebElement> radioButtonsLabel;
    @FindBy(id = "award")
    public WebElement bookWithMilesCheckBoxInput;
    @FindBy(css = "div[class*='2SGSV']>label")
    public WebElement bookWithMilesCheckBoxLabel;
    @FindBy(id = "flexibleDates")
    public WebElement flexibleDatesCheckBoxInput;
    @FindBy(css = "div[class*='2wMRQ']>label")
    public WebElement flexibleDatesCheckBoxLabel;

}

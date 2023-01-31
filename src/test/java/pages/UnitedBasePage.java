package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UnitedBasePage {
    public UnitedBasePage(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(css = "a[id*='headerNav']")
    public List<WebElement> navigationItems;
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
    @FindBy(id = "bookFlightOriginInput")
    public WebElement flightOriginInput;
    @FindBy(id = "bookFlightDestinationInput")
    public WebElement flightDestinationInput;
    @FindBy(id = "DepartDate")
    public WebElement departDateInput;
    @FindBy(css = "//div[contains(@class, 'DayPicker_focusRegion DayPicker_focusRegion_1')]")
    public WebElement calendarGrid;
    @FindBy(css = "button[class*='1UzDj']")
    public WebElement travelersSelectorButton;
    @FindBy(xpath = "(//div[contains(@class, '2Occ')])[1]/input")
    public WebElement travelersSelectorInput;
    @FindBy(css = "li[id*='cabinType_item']")
    public List<WebElement> cabinDropdownOptions;
    @FindBy(id = "cabinType")
    public WebElement cabinType;
    @FindBy(css = "button[class*='2fg9l']")
    public WebElement findFlightsButton;

}

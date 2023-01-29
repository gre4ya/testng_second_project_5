package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UnitedBasePage {
    public UnitedBasePage(){PageFactory.initElements(Driver.getDriver(), this);}


}

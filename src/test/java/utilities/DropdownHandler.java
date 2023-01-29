package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownHandler {
    public static void clickOnDropdownOption(WebElement dropdown, List<WebElement> dropdownOptions, String optionText){
        dropdown.click();
        for (WebElement dropdownOption : dropdownOptions) {
            if(dropdownOption.getText().equals(optionText)){
                dropdownOption.click();
                break;
            }
        }
    }



    //Method for selection option in dropdown

    public static void selectByVisibleText(WebElement dropdown, String text){
        new Select(dropdown).selectByVisibleText(text);
    }
    public static void selectByValue(WebElement dropdown, String text){
        new Select(dropdown).selectByValue(text);
    }
    public static void selectByIndex(WebElement dropdown, int index){
        new Select(dropdown).selectByIndex(index);
    }

}

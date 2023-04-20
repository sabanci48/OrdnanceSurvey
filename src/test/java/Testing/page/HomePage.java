package Testing.page;

import Testing.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

   // @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiTab-root jss7 MuiTab-textColorInherit']")
    public List<WebElement> headerModules = Driver.getDriver().findElements(By.xpath("//button[@class='MuiButtonBase-root MuiTab-root jss7 MuiTab-textColorInherit']"));

    public static void headerModules1(String moduleName){
        List<WebElement> headerModules = Driver.getDriver().findElements
                (By.xpath("//button[@class='MuiButtonBase-root MuiTab-root jss7 MuiTab-textColorInherit']"));
        for (int i = 0; i < headerModules.size(); i++) {
            if(headerModules.get(i).getText().equals(moduleName)){
                headerModules.get(i).click();
                break;
            }
        }

    }


}

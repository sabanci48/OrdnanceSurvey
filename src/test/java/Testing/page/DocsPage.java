package Testing.page;

import Testing.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DocsPage {

    public DocsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //li[contains(@id, 'Menu')]

    // public List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//li[contains(@id, 'Menu')]"));



    public static List<String> setSideMenu(){
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//li[contains(@id, 'Menu')]"));

        List<String> sideMenuItems = new ArrayList<>();
        for (WebElement eachElement : elements) {
            sideMenuItems.add(eachElement.getText());
        }

        return sideMenuItems;

    }


}

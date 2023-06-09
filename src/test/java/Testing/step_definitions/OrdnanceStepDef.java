package Testing.step_definitions;

import Testing.page.DocsPage;
import Testing.page.HomePage;
import Testing.utilities.ConfigurationReader;
import Testing.utilities.Driver;
import io.cucumber.java.en.*;
import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OrdnanceStepDef {

    HomePage homePage = new HomePage();
    DocsPage docsPage= new DocsPage();

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        WebElement cookie = homePage.cookieAccept ;
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cookie));

               cookie.click();

    }
    @Then("user sees header menu objects")
    public void user_sees_header_menu_objects() {
        for (WebElement eachHeaderModule : homePage.headerModules) {
            Assert.assertTrue(eachHeaderModule.isDisplayed());
        }
    }

    @When("user clicks on the {string} page")
    public void user_clicks_on_the_page(String ModuleName) {

        homePage.clickModuleName(ModuleName);
    }
    @Then("user see the side menu below")
    public void user_see_the_side_menu_below(List<String> expectedList) {


        System.out.println("docsPage.setSideMenu() = " + DocsPage.setSideMenu());

        for (String each : expectedList) {
            Assert.assertTrue(DocsPage.setSideMenu().contains(each) );

        }











        /*

        System.out.println("expectedList = " + expectedList);

        System.out.println("docsPage.setSideMenu() = " + docsPage.setSideMenu());

        System.out.println("docsPage.sideMenu = " + docsPage.sideMenu);

        for (WebElement eachSideMenu : docsPage.sideMenu) {
            System.out.println("eachSideMenu.getText() = " + eachSideMenu.getText());

        }



        System.out.println("docsPage.setSideMenu() = " + docsPage.setSideMenu());

        for (String each : expectedList) {
            Assert.assertTrue(docsPage.setSideMenu().contains(each));


        }

        */






    }
}

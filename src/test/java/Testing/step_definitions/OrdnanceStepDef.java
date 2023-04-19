package Testing.step_definitions;

import Testing.utilities.ConfigurationReader;
import Testing.utilities.Driver;
import io.cucumber.java.en.*;

public class OrdnanceStepDef {
    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @Then("user sees header menu objects")
    public void user_sees_header_menu_objects() {

    }
    @When("user clicks on the {string} page")
    public void user_clicks_on_the_page(String string) {

    }
    @Then("user see the side menu below")
    public void user_see_the_side_menu_below(io.cucumber.datatable.DataTable dataTable) {


    }
}

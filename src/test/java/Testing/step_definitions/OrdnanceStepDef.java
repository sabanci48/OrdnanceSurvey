package Testing.step_definitions;

import Testing.utilities.ConfigurationReader;
import Testing.utilities.Driver;
import io.cucumber.java.en.*;

public class OrdnanceStepDef {
    @Given("user is on the page")
    public void user_is_on_the_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @Then("user navigates through header menu")
    public void user_navigates_through_header_menu() {

    }
    @Then("clicks on the {string} page")
    public void clicks_on_the_page(String string) {

    }
    @Then("verify items on the side menu")
    public void verify_items_on_the_side_menu() {

    }
    @Then("verify the links shown when expand the listed sections under")
    public void verify_the_links_shown_when_expand_the_listed_sections_under(io.cucumber.datatable.DataTable dataTable) {

    }

}

package Testing.step_definitions;


import Testing.utilities.ConfigurationReader;
import Testing.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

/*
In this class we will be able to create "pre" and "post" condition for ALL the SCENARIOS and even steps.
 */

public class Hooks {

    //import the @Before coming from io.cucumber.java
    @Before (order = 1)
    public void setupMethod() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }



    @After
    public void tearDownMethod(Scenario scenario){

        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        System.out.println(" ---> RUNNING AFTER EACH SCENARIO");
        Driver.closeDriver();
    }





    // @BeforeStep
    public void setupStep(){
        System.out.println("------>@BeforeStep : Running before each step");
    }

    // @AfterStep
    public void teardownStep(){
        System.out.println("--------> @AfterStep : Running after each step!");
    }




}


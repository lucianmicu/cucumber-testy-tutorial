package org.fasttrackit.workshop.change;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/jsonReports/LoginTest.json"},
        glue = {
                "org.fasttrackit.workshop"
        },
        features = {
                "src/test/resources/feature/workshop/change-pass.feature"
        }
)
@RunWith(Cucumber.class)
public class PreferesncesTest {
}
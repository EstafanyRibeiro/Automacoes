package webdriver.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
            features = "src/test/resources/features/amazonTeste.feature",
            glue = {"webdriver.steps"},
            plugin = {"pretty", "json:target/reports/CucumberReport.json"}
            )

public class runnerTest {
}

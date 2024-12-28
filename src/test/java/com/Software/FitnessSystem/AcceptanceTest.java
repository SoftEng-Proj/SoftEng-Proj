package com.Software.FitnessSystem;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/Features",
	    glue = "com.Software.FitnessSystem",
	    plugin = {"html:target/cucumber-report/report.html"},
	    monochrome = true,
	    snippets = SnippetType.CAMELCASE
	)

public class AcceptanceTest {
}
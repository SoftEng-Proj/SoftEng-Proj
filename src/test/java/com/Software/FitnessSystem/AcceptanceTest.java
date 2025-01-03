package com.Software.FitnessSystem;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "com.Software.FitnessSystem",
		plugin = {"html:target/cucumber-report/report.html"},
		monochrome = true,
		snippets = CucumberOptions.SnippetType.CAMELCASE,
		tags = "@MuathHassounTests or @AmmarShafiiTests")

public class AcceptanceTest {
}
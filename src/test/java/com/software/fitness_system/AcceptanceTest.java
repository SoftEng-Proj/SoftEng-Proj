package com.software.fitness_system;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "com.software.fitness_system",
		plugin = {"html:target/cucumber-report/report.html"},
		monochrome = true,
		snippets = CucumberOptions.SnippetType.CAMELCASE,
		tags = "@MuathHassounTests or @AmmarShafiiTests or @AlaaAlawnehTests")

/*
 * @MuathHassounTests or @AmmarShafiiTests or @AlaaAlawnehTests
 */
public class AcceptanceTest {
}
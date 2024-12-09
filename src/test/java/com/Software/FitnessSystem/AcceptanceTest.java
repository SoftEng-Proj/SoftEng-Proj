package com.Software.FitnessSystem;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = "com.Software.FitnessSystem",
	    plugin = {"pretty", "html:target/cucumber-report/report.html"},
	    monochrome = true
)

public class AcceptanceTest {
}
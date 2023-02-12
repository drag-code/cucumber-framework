package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "features" }, 
		glue = { "steps" }, 
		plugin = { "pretty", "html:target/html-report/report.html" },
		tags = "@Test",
		dryRun = false
	)
public class TestRunner { }

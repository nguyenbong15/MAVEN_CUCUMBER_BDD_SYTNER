package cucumberOption;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
	   features="src/test/java/features",
	   glue="stepDefinitions",
	   monochrome=true,
	  // plugin ={"pretty", "htmltarget/site/cucumber-report-default", "json:target/site/cucumber.json"},
	   snippets = SnippetType.CAMELCASE,
	   tags ={"@about_us_menuitem"}
)
public class sytnerRunner {

}
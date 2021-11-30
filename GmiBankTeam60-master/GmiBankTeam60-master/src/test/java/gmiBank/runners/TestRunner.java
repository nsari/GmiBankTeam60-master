package gmiBank.runners;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target\\cucumber-raporlar1.html",
                "json:target/json-reports/cucumber1.json",
                "junit:target/xml-report/cucumber1.xml"},
        features = "src/test/resources/features",
        glue = "gmiBank/stepDefinitions",


        tags = "@employeecreateaccount",
        dryRun = false


)

public class TestRunner {
}

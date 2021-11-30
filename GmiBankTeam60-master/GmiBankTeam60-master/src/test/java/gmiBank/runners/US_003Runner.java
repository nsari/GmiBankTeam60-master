package gmiBank.runners;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target\\cucumber-raporlarUS_003.html",
                "json:target/json-reports/cucumberUS_003.json",
                "junit:target/xml-report/cucumberUS_003.xml"},
        features = "src/test/resources/features",
        glue = "gmiBank/stepDefinitions",


        tags = "@US008pwdChange",
        dryRun = false


)

public class US_003Runner {
}
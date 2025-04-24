package webTest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(value= Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/Assessment.feature",
        tags = "@run ",
        glue = {"stepDefinitions"}
)
public class AssessmentRunner {
}

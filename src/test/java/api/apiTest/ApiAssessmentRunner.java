package api.apiTest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(value= Cucumber.class)
@CucumberOptions(
       /* features = {"src/test/java/api/apiFeature/DogBreedList.feature"},*/
        features = {"src/test/java/api/apiFeature"},
        tags = "@run",
        plugin = {
                "pretty", // Prints Gherkin steps in the console
                "html:target/cucumber-reports.html", // Generates HTML report
                "json:target/cucumber-reports/Cucumber.json", // Generates JSON report
                "junit:target/cucumber-reports/Cucumber.xml" // Generates JUnit XML report
        },
        glue = {"api/apiStepDefinitions"}


)
public class ApiAssessmentRunner {

}

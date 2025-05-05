package api.webTest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(value= Cucumber.class)
@CucumberOptions(
       /* features = {"src/test/java/api/apiFeature/DogBreedList.feature"},*/
        features = {"src/test/java/api/apiFeature"},
        tags = "@run1 ",
        glue = {"api/apiStepDefinitions"}
)
public class ApiAssessmentRunner {

}

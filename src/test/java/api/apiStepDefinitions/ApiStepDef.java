package api.apiStepDefinitions;

import api.BaseClassAPI;
import api.Utils;
import api.reporting.ExtentReportUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.Assert;

import org.json.JSONObject;
import org.json.JSONArray;



import java.util.List;
import java.util.Map;
;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ApiStepDef extends BaseClassAPI {

    Scenario scenario;
    public String endpoint;
    //protected JsonObject response;
    public Response response;
    public Boolean result =true;


    public String baseUrl;

    @Given("the API endpoint is available")
    public void theAPIEndpointIsAvailable() {

         baseUrl = getConfigPropertyValue("Framework.properties", "base_url");
        assertThat(baseUrl, notNullValue());

    }

    @When("^I send a GET request to \"([^\"]*)\"$")
    public void i_send_a_GET_request_to(String url) throws Throwable {

        endpoint = baseUrl+url;
        System.out.println("endpoint is "+endpoint);
        response = RestAssured.get( endpoint);

        System.out.println("Response code is as follows" + response);


        if (response != null) {
            System.out.println("Response code is as follows" + response);
        } else {
            Assert.fail("There is no response from the server.");
        }

    }

    @Then("^I should receive a \"([^\"]*)\" status$")
    public void i_should_receive_a_status_code(String status) throws Throwable {

        String statusResp = response.jsonPath().getString("status");
        System.out.println("status response is " +statusResp);
        assertEquals(status, statusResp);

    }

    @Then("^the response should contain a list of dogs$")
    public void the_response_should_contain_a_list_of_dogs() throws Throwable {

        if (response != null) {
            System.out.println("Response code is as follows" + response);

        } else {
            Assert.fail("There is no response from the server.");
        }

    }


    @And("^verify \"([^\"]*)\" breed is within the list$")
    public void verifyBreedIsWithinTheList(String retriever) {


        if (response != null) {

            Map<String, List<String>> breeds  = response.jsonPath().getMap("message");
            // Verify if "retriever" breed is in the list
            if (breeds.containsKey("retriever")) {
                System.out.println("\nThe breed 'retriever' is in the list.");
                Assert.assertEquals(result,breeds.containsKey(retriever));

            } else {
                System.out.println("\nThe breed 'retriever' is not in the list.");
                Assert.fail("The breeds does not contain the retriever.");
            }

        } else {
            Assert.fail("Failed to retrieve the list of dog breeds.");
        }

    }


    @And("verify retriever breed is within the list")
    public void verifyRetrieverBreedIsWithinTheList() {

        if (response != null) {

           Map<String, List<String>> breeds  = response.jsonPath().getMap("message");

            // Verify if "retriever" breed is in the list
            if (breeds.containsKey("retriever")) {
                System.out.println("\nThe breed 'retriever' is in the list.");
                Assert.assertEquals(result,breeds.containsKey("retriever"));

            } else {
                System.out.println("\nThe breed 'retriever' is not in the list.");
                Assert.fail("The breeds does not contain the retriever.");
            }

        } else {
            Assert.fail("Failed to retrieve the list of dog breeds.");
        }

    }

    @And("the response should contain a random image for the subbreed golden")
    public void theResponseShouldContainARandomImageForTheSubbreedGolden() {

        if (response != null) {
            String imageUrl = response.jsonPath().getString("message");
            System.out.println("Random image of a golden retriever: " + imageUrl);
            // Verify if the image URL is not null
            assertThat(imageUrl, notNullValue());

        } else {
            Assert.fail("Failed to retrieve golden retriever image");
        }


    }

    @And("the response should contain a list subbreeds for retrieve")
    public void theResponseShouldContainAListSubBreedsForRetrieve() {

        Map<String, List<String>> breeds  = response.jsonPath().getMap("message");

        // Verify if "retriever" breed is in the list
        if (breeds.containsKey("retriever")) {
            System.out.println("\nThe breed 'retriever' is in the list.");
           Assert.assertEquals(result,breeds.containsKey("retriever"));

            JSONObject jsonObject = new JSONObject(breeds);
            JSONArray retrieverArray = jsonObject.getJSONArray("retriever");

         // Create the new JSON object with the desired format
           JSONObject result = new JSONObject();
           result.put("status", "success");
           result.put("message", retrieverArray);
           //Print out the results
          System.out.println(result.toString(2));
           System.out.println("The list contains retriever breeds:");
            for (String breed : breeds.get("retriever")) {
                System.out.println(breed);
            }



        } else {
            System.out.println("\nThe breed 'retriever' is not in the list.");
            Assert.fail("Retriever' breed is not found in the list");
        }
    }




}
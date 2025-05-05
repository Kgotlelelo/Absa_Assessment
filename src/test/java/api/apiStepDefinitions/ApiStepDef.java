package api.apiStepDefinitions;

import api.BaseClassAPI;
import api.Utils;
import api.reporting.ExtentReportUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.given;


public class ApiStepDef extends BaseClassAPI {

    public String endpoint;
    public JsonObject response;


    @Given("^the API endpoint is available$")
    public void the_API_endpoint_is_available() throws Throwable {

        endpoint = getConfigPropertyValue("Framework.properties", "apiUrl");
        System.out.println("end point is as follows" + endpoint);
    }

    @When("^I send a GET request to \"([^\"]*)\"$")
    public void i_send_a_GET_request_to(String arg1) throws Throwable {
        //response = Utils.sendGetRequest(httpClient, endpoint);
    }

    @Then("^I should receive a (\\d+) status code$")
    public void i_should_receive_a_status_code(int arg1) throws Throwable {
        given().when().get(endpoint).then().statusCode(200);
    }

    @Then("^the response should contain a list of dogs$")
    public void the_response_should_contain_a_list_of_dogs() throws Throwable {
        if (response != null) {
            ExtentReportUtil.logPass("List of Dog Breeds retrieved successfully");
            JsonObject breeds = response.getAsJsonObject("message");
            System.out.println("List of all dog breeds:");
            breeds.keySet().forEach(System.out::println);
        } else {
            ExtentReportUtil.logFail("Failed to retrieve the list of dog breeds");
        }

    }

    @And("verify “retriever” breed is within the list")
    public void verifyRetrieverBreedIsWithinTheList() {

        if (response != null) {
            JsonObject breeds = response.getAsJsonObject("message");

            // Verify if "retriever" breed is in the list
            if (breeds.has("retriever")) {
                System.out.println("\nThe breed 'retriever' is in the list.");
                ExtentReportUtil.logPass("'Retriever' breed is found in the list.");
            } else {
                System.out.println("\nThe breed 'retriever' is not in the list.");
                ExtentReportUtil.logFail("'Retriever' breed is not found in the list.");
            }
        } else {
            ExtentReportUtil.logFail("Failed to retrieve the list of dog breeds.");
        }

    }

    @And("the response should contain a random image for the sub-breed {string}")
    public void theResponseShouldContainARandomImageForTheSubBreed(String arg0) {

        if (response != null) {
            String imageUrl = response.get("message").getAsString();
            System.out.println("Random image of a golden retriever: " + imageUrl);
            ExtentReportUtil.logPass("Golden retriever image retrieved successfully: " + imageUrl);
        } else {
            ExtentReportUtil.logFail("Failed to retrieved  golden retriever image.");
        }
    }


    @And("the response should contain a list sub-breeds for {string}")
    public void theResponseShouldContainAListSubBreedsFor(String arg0) {

        if (response != null) {
            JsonArray subBreeds = response.getAsJsonArray("message");

            if (subBreeds != null && subBreeds.size() > 0) {
                System.out.println("List of retriever sub-breeds:");
                subBreeds.forEach(subBreed -> System.out.println(subBreed.getAsString()));
                ExtentReportUtil.logPass("Retriever sub-breeds retrieved successfully.");
            } else {
                ExtentReportUtil.logFail("No retriever sub-breeds found.");
            }
        } else {
            ExtentReportUtil.logFail("Failed to retrieve retriever sub-breeds.");
        }


    }
}
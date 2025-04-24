package api;


import api.reporting.ExtentReportUtil;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;
import utilities.BaseClass;

public class DogBreedsAPITest extends BaseClassAPI {

    @Test
    public void getDogBreedsAPI() {
        ExtentReportUtil.createTest("GET List of Dog Breed API Test");

         String url = getConfigPropertyValue("Framework.properties", "apiUrl");
        System.out.println("end point is as follows"+url);


        JsonObject response = Utils.sendGetRequest(httpClient, url);

        if (response != null) {
            ExtentReportUtil.logPass("List of Dog Breeds retrieved successfully");
            JsonObject breeds = response.getAsJsonObject("message");
            System.out.println("List of all dog breeds:");
            breeds.keySet().forEach(System.out::println);
        } else {
            ExtentReportUtil.logFail("Failed to retrieve the list of dog breeds");
        }
    }
}

package api;

import api.reporting.ExtentReportUtil;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

public class CheckRetrieverTest extends BaseClassAPI {

    @Test
    public void checkRetrieverTest() {
        ExtentReportUtil.createTest("Verify 'retriever' breed is within the list");

        String url = getConfigPropertyValue("Framework.properties", "apiUrl");
        System.out.println("Endpoint is as follows: " + url);

        JsonObject response = Utils.sendGetRequest(httpClient, url);

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
}
package api;

import api.reporting.ExtentReportUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class RetrieverSubBreedsTest extends BaseClassAPI {


    @Test
    public void RetrieverSubBreedsTest() {

        ExtentReportUtil.createTest("produce a list of sub-breeds for “retriever");

       // String url = getConfigPropertyValue("Framework.properties", "apiUrl");
        String url = "https://dog.ceo/api/breed/retriever/list";
        System.out.println("end point is as follows"+url);


        JsonObject response = Utils.sendGetRequest(httpClient, url);

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
